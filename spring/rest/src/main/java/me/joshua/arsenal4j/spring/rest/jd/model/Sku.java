package me.joshua.arsenal4j.spring.rest.jd.model;

import me.joshua.arsenal4j.java.commons.BaseObject;

public class Sku extends BaseObject {
	private static final long serialVersionUID = -6893964430617621339L;

	private String name;
	private String skuId;
	private String imageUrl;
	private String jdPrice;
	private String marketPrice;
	private Boolean addCart;
	private Integer sales;
	private Integer status;
	private Integer lowPurchaseCount;
	private Long firstCatId;
	private Long secondCatId;
	private Long thirdCatId;
	private Boolean gifts;
	private Integer isCanUseDq;
	private Integer isSevenReturn;
	private String zgbUpcCode;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSkuId() {
		return skuId;
	}

	public void setSkuId(String skuId) {
		this.skuId = skuId;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getJdPrice() {
		return jdPrice;
	}

	public void setJdPrice(String jdPrice) {
		this.jdPrice = jdPrice;
	}

	public String getMarketPrice() {
		return marketPrice;
	}

	public void setMarketPrice(String marketPrice) {
		this.marketPrice = marketPrice;
	}

	public Boolean getAddCart() {
		return addCart;
	}

	public void setAddCart(Boolean addCart) {
		this.addCart = addCart;
	}

	public Integer getSales() {
		return sales;
	}

	public void setSales(Integer sales) {
		this.sales = sales;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getLowPurchaseCount() {
		return lowPurchaseCount;
	}

	public void setLowPurchaseCount(Integer lowPurchaseCount) {
		this.lowPurchaseCount = lowPurchaseCount;
	}

	public Long getFirstCatId() {
		return firstCatId;
	}

	public void setFirstCatId(Long firstCatId) {
		this.firstCatId = firstCatId;
	}

	public Long getSecondCatId() {
		return secondCatId;
	}

	public void setSecondCatId(Long secondCatId) {
		this.secondCatId = secondCatId;
	}

	public Long getThirdCatId() {
		return thirdCatId;
	}

	public void setThirdCatId(Long thirdCatId) {
		this.thirdCatId = thirdCatId;
	}

	public Boolean getGifts() {
		return gifts;
	}

	public void setGifts(Boolean gifts) {
		this.gifts = gifts;
	}

	public Integer getIsCanUseDq() {
		return isCanUseDq;
	}

	public void setIsCanUseDq(Integer isCanUseDq) {
		this.isCanUseDq = isCanUseDq;
	}

	public Integer getIsSevenReturn() {
		return isSevenReturn;
	}

	public void setIsSevenReturn(Integer isSevenReturn) {
		this.isSevenReturn = isSevenReturn;
	}

	public String getZgbUpcCode() {
		return zgbUpcCode;
	}

	public void setZgbUpcCode(String zgbUpcCode) {
		this.zgbUpcCode = zgbUpcCode;
	}
}
