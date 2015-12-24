package me.joshua.arsenal4j.java.html;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.FastDateFormat;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

/**
 * 
 * @author daonan.zhan
 */
public class JsoupTest {

	private FastDateFormat POST_TIME_FORMAT = FastDateFormat.getInstance("yyyy-M-d HH:mm");

	@Test
	public void test() throws Throwable {
		Document doc = Jsoup.connect("http://bbs.hangzhou.com.cn/forum-158-1.html")
				.userAgent("Mozilla/5.0 (Windows; U; WindowsNT 5.1; en-US; rv1.8.1.6) Gecko/20070725 Firefox/2.0.0.6")
				.referrer("http://bbs.hangzhou.com.cn/").get();
		Elements posts = doc.select("#threadlisttableid tbody");

		Date startDate = POST_TIME_FORMAT.parse("2015-1-1 00:00");

		for (Element post : posts) {
			Element timeElm = post.select(".by em span").first();
			if (null == timeElm) {
				continue;
			}

			Date postTime = POST_TIME_FORMAT.parse(timeElm.text());
			if (startDate.after(postTime)) {
				continue;
			}

			Element tagElm = post.select(".common em a, .new em a").first();
			if (null == tagElm) {
				continue;
			}
			if (!StringUtils.equals("报名", tagElm.text())) {
				continue;
			}

			Element titleElm = post.select(".common a.xst, .new a.xst").first();
			if (null == titleElm) {
				continue;
			}
			System.out.println(String.format("[%s]%s", POST_TIME_FORMAT.format(postTime), titleElm.text()));
		}
	}
}
