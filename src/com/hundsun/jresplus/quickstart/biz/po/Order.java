package com.hundsun.jresplus.quickstart.biz.po;



import java.io.Serializable;
import java.util.Date;

 



/**
*
* @author zhouc
* 2016-03-03
*/
 
public class Order implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3480590125812331901L;
	 
	
	private Long id;//订单id
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	 
	private Date orderTime;//下单时间
	public Date getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}
	 
	private Integer totalPrice;//总价
	public Integer getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Integer totalPrice) {
		this.totalPrice = totalPrice;
	}
	 
	private Integer totalScore;//总积分
	public Integer getTotalScore() {
		return totalScore;
	}
	public void setTotalScore(Integer totalScore) {
		this.totalScore = totalScore;
	}
	 
	private Integer goodsTypeCount;//商品种类
	public Integer getGoodsTypeCount() {
		return goodsTypeCount;
	}
	public void setGoodsTypeCount(Integer goodsTypeCount) {
		this.goodsTypeCount = goodsTypeCount;
	}
	 
	private Integer goodsCount;//商品总数
	public Integer getGoodsCount() {
		return goodsCount;
	}
	public void setGoodsCount(Integer goodsCount) {
		this.goodsCount = goodsCount;
	}
	 
	private String receiverName;//收货人姓名
	public String getReceiverName() {
		return receiverName;
	}
	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}
	 
	private String receiverAddress;//收货人地址
	public String getReceiverAddress() {
		return receiverAddress;
	}
	public void setReceiverAddress(String receiverAddress) {
		this.receiverAddress = receiverAddress;
	}
	 
	private String receiverMobile;//收货人手机号
	public String getReceiverMobile() {
		return receiverMobile;
	}
	public void setReceiverMobile(String receiverMobile) {
		this.receiverMobile = receiverMobile;
	}
	 
	private String userName;//下单账号
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	 
	private String payType;//支付类型
	public String getPayType() {
		return payType;
	}
	public void setPayType(String payType) {
		this.payType = payType;
	}
	 
	private String user_remarks;
	
	
	private String isSplit;//是否拆分
	public String getIsSplit() {
		return isSplit;
	}
	public void setIsSplit(String isSplit) {
		this.isSplit = isSplit;
	}
	 
	private Integer status;//状态 （init-初始化；paid-已付款；prepared-已备货；deliverying-已发货；received-已收货；commented-已评论）
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	 
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
	public String getUser_remarks() {
		return user_remarks;
	}
	public void setUser_remarks(String user_remarks) {
		this.user_remarks = user_remarks;
	}
	
	
	
}
