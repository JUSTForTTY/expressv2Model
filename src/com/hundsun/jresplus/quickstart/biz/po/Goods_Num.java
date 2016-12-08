package com.hundsun.jresplus.quickstart.biz.po;

public class Goods_Num extends BaseDomain{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1588331139080859532L;
	
	private Goods goods;
	
	private Long number;

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public Long getNumber() {
		return number;
	}

	public void setNumber(Long number) {
		this.number = number;
	}
	

}
