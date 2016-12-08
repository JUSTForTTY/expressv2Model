package com.hundsun.jresplus.quickstart.biz.po;



import java.io.Serializable;
import java.util.Date;

 


/**
*
* @author zhouc
* 2016-03-03
*/
 
public class OrderDetail implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6759030061052259231L;
	/**
	 * 
	 */

	 
	
	private Integer id;//订单详细id
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	 
	private Long orderId;//订单id
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	 
	private Long subOrderId;//子订单id
	public Long getSubOrderId() {
		return subOrderId;
	}
	public void setSubOrderId(Long subOrderId) {
		this.subOrderId = subOrderId;
	}
	 
	private Long goodsId;//商品id
	public Long getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}
	 
	private String goodsName;//商品名
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	 
	private String miniature;//缩约图
	public String getMiniature() {
		return miniature;
	}
	public void setMiniature(String miniature) {
		this.miniature = miniature;
	}
	 
	private Long memberId;//供应商会员单位id
	
	public Long getMemberId() {
		return memberId;
	}
	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}
	 
	private String memberName;//供应商会员单位名称
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
 
	private Integer unitPrice;//单位价格
	public Integer getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(Integer unitPrice) {
		this.unitPrice = unitPrice;
	}
	 
	private Integer unitScore;//单位积分
	public Integer getUnitScore() {
		return unitScore;
	}
	public void setUnitScore(Integer unitScore) {
		this.unitScore = unitScore;
	}
	 
	private Integer goodsCount;//商品数量
	public Integer getGoodsCount() {
		return goodsCount;
	}
	public void setGoodsCount(Integer goodsCount) {
		this.goodsCount = goodsCount;
	}
	 
	private Integer singlePrice;//总价格
	 
	 
	private Integer singleScore;//总积分
	 
	 
	private Date gmtCreate;//创建时间
	public Date getGmtCreate() {
		return gmtCreate;
	}
	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}
	 
private Date gmtModify;//修改时间
	public Date getGmtModify() {
		return gmtModify;
	}
	public void setGmtModify(Date gmtModify) {
		this.gmtModify = gmtModify;
	}
	public Integer getSinglePrice() {
		return singlePrice;
	}
	public void setSinglePrice(Integer singlePrice) {
		this.singlePrice = singlePrice;
	}
	public Integer getSingleScore() {
		return singleScore;
	}
	public void setSingleScore(Integer singleScore) {
		this.singleScore = singleScore;
	}
	
	
	
}
