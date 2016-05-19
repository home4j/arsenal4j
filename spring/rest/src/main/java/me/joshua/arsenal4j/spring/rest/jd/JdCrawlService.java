package me.joshua.arsenal4j.spring.rest.jd;

import java.net.URI;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;

import me.joshua.arsenal4j.spring.rest.jd.model.Catelogy;
import me.joshua.arsenal4j.spring.rest.jd.model.CatelogyParam;
import me.joshua.arsenal4j.spring.rest.jd.model.CatelogyResponse;
import me.joshua.arsenal4j.spring.rest.jd.model.Sku;
import me.joshua.arsenal4j.spring.rest.jd.model.SkuData;
import me.joshua.arsenal4j.spring.rest.jd.model.SkuParam;
import me.joshua.arsenal4j.spring.rest.jd.model.SkuResponse;

@Service
public class JdCrawlService {

	private static final ObjectMapper mapper = new ObjectMapper();

	@Autowired
	@Qualifier("restTemplate4Jd")
	private RestTemplate restTemplate;

	public List<Catelogy> queryCatelogy(Long cid) {
		CatelogyParam param = new CatelogyParam(1L, 100L, cid);
		try {
			URI uri = UriComponentsBuilder.newInstance().scheme("http").host(JdConstants.ZGB_HOST)
			        .path(JdConstants.ZGB_CATELOGY_PATH).query("body=" + mapper.writeValueAsString(param)).build()
			        .toUri();
			CatelogyResponse catelogyData = restTemplate.getForObject(uri, CatelogyResponse.class);
			if (null != catelogyData && null != catelogyData.getData()) {
				return catelogyData.getData().getCatelogys();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public SkuData querySku(Long page, Long pageSize, Long cid) {
		SkuParam param = new SkuParam(page, pageSize, cid);
		try {
			URI uri = UriComponentsBuilder.newInstance().scheme("http").host(JdConstants.ZGB_HOST)
			        .path(JdConstants.ZGB_SKU_PATH).query("body=" + mapper.writeValueAsString(param)).build().toUri();
			SkuResponse response = restTemplate.getForObject(uri, SkuResponse.class);
			if (null != response && null != response.getData()) {
				return response.getData();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Sku> querySku(Long cid) {
		List<Sku> skus = new LinkedList<>();
		long start = 1;
		while (true) {
			SkuData data = querySku(start, 10L, cid);
			if (null == data || start > ObjectUtils.defaultIfNull(data.getPageCount(), 0L)) {
				break;
			}
			if (CollectionUtils.isNotEmpty(data.getWareInfoList())) {
				skus.addAll(data.getWareInfoList());
			}
			start++;
		}
		return skus;
	}

}
