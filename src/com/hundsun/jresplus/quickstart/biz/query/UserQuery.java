package com.hundsun.jresplus.quickstart.biz.query;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.hundsun.jresplus.common.util.StringUtil;
import com.hundsun.network.common.query.QueryPage;

/**
 *  获取所有的会员管理分页显示
 * @author li_ben
 *
 */
public class UserQuery extends QueryPage {
    private static final long serialVersionUID = 777061030649295723L;
    
    private Long id;
	private String username;
	private String passwd;
	private String userquestion;
	private String useranswer;
	private String realname;
	private String gender;
	private String tel;
	private String email;
	private String qq;
	private String mobile;
	private String address;
	private double prepay;
	private int source;
	private Date regtime;
	private int usertype;
	private int companyId;
	private int status;
	private int creatorId;
	private Date createtime;
	private int recuserId;
	private String recusername;
	private int buildingId;
	private int cardId;

	@Override
    public Map<String, String> getParameters() {
        Map<String, String> map = new HashMap<String, String>();
        if (StringUtil.isNotBlank(username)) {
            map.put("username", username.trim());
        }
        if (StringUtil.isNotBlank(passwd)) {
            map.put("passwd", passwd.trim());
        }
        if (StringUtil.isNotBlank(realname)) {
            map.put("realname", realname.trim());
        }
        if (StringUtil.isNotBlank(userquestion)) {
            map.put("userquestion", userquestion.trim());
        }
        if (StringUtil.isNotBlank(useranswer)) {
            map.put("useranswer", useranswer.trim());
        }
        return map;
    }


	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}


	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}


	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}


	/**
	 * @return the realname
	 */
	public String getRealname() {
		return realname;
	}


	/**
	 * @param realname the realname to set
	 */
	public void setRealname(String realname) {
		this.realname = realname;
	}


	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}


	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}


	/**
	 * @return the passwd
	 */
	public String getPasswd() {
		return passwd;
	}


	/**
	 * @param passwd the passwd to set
	 */
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}


	/**
	 * @return the userquestion
	 */
	public String getUserquestion() {
		return userquestion;
	}


	/**
	 * @param userquestion the userquestion to set
	 */
	public void setUserquestion(String userquestion) {
		this.userquestion = userquestion;
	}


	/**
	 * @return the useranswer
	 */
	public String getUseranswer() {
		return useranswer;
	}


	/**
	 * @param useranswer the useranswer to set
	 */
	public void setUseranswer(String useranswer) {
		this.useranswer = useranswer;
	}


	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}


	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}


	/**
	 * @return the tel
	 */
	public String getTel() {
		return tel;
	}


	/**
	 * @param tel the tel to set
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}


	/**
	 * @return the qq
	 */
	public String getQq() {
		return qq;
	}


	/**
	 * @param qq the qq to set
	 */
	public void setQq(String qq) {
		this.qq = qq;
	}


	/**
	 * @return the mobile
	 */
	public String getMobile() {
		return mobile;
	}


	/**
	 * @param mobile the mobile to set
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}


	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}


	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}


	/**
	 * @return the prepay
	 */
	public double getPrepay() {
		return prepay;
	}


	/**
	 * @param prepay the prepay to set
	 */
	public void setPrepay(double prepay) {
		this.prepay = prepay;
	}


	/**
	 * @return the source
	 */
	public int getSource() {
		return source;
	}


	/**
	 * @param source the source to set
	 */
	public void setSource(int source) {
		this.source = source;
	}


	/**
	 * @return the regtime
	 */
	public Date getRegtime() {
		return regtime;
	}


	/**
	 * @param regtime the regtime to set
	 */
	public void setRegtime(Date regtime) {
		this.regtime = regtime;
	}


	/**
	 * @return the usertype
	 */
	public int getUsertype() {
		return usertype;
	}


	/**
	 * @param usertype the usertype to set
	 */
	public void setUsertype(int usertype) {
		this.usertype = usertype;
	}


	/**
	 * @return the companyId
	 */
	public int getCompanyId() {
		return companyId;
	}


	/**
	 * @param companyId the companyId to set
	 */
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}


	/**
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}


	/**
	 * @param status the status to set
	 */
	public void setStatus(int status) {
		this.status = status;
	}


	/**
	 * @return the creatorId
	 */
	public int getCreatorId() {
		return creatorId;
	}


	/**
	 * @param creatorId the creatorId to set
	 */
	public void setCreatorId(int creatorId) {
		this.creatorId = creatorId;
	}


	/**
	 * @return the createtime
	 */
	public Date getCreatetime() {
		return createtime;
	}


	/**
	 * @param createtime the createtime to set
	 */
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}


	/**
	 * @return the recuserId
	 */
	public int getRecuserId() {
		return recuserId;
	}


	/**
	 * @param recuserId the recuserId to set
	 */
	public void setRecuserId(int recuserId) {
		this.recuserId = recuserId;
	}


	/**
	 * @return the recusername
	 */
	public String getRecusername() {
		return recusername;
	}


	/**
	 * @param recusername the recusername to set
	 */
	public void setRecusername(String recusername) {
		this.recusername = recusername;
	}


	/**
	 * @return the buildingId
	 */
	public int getBuildingId() {
		return buildingId;
	}


	/**
	 * @param buildingId the buildingId to set
	 */
	public void setBuildingId(int buildingId) {
		this.buildingId = buildingId;
	}


	/**
	 * @return the cardId
	 */
	public int getCardId() {
		return cardId;
	}


	/**
	 * @param cardId the cardId to set
	 */
	public void setCardId(int cardId) {
		this.cardId = cardId;
	}

}
