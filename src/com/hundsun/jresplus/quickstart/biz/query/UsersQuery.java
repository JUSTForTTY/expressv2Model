package com.hundsun.jresplus.quickstart.biz.query;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hundsun.jresplus.common.util.StringUtil;
import com.hundsun.network.common.query.QueryPage;

/**
 *  获取所有的会员管理分页显示
 * @author li_ben
 *
 */
public class UsersQuery extends QueryPage {
    private static final long serialVersionUID = 777061030649295723L;
    
    private String            id;
    //用户的名字检索
    private String            account;
    //用户的真实姓名
    private String            realName;
    //用户状态
    private String            status;
    //用户类型
    private String            userType;
    private String            startDate;
    private String            endDate;

    //登录用户类型
    private String            agentUserType ;
    
    //部门id
    private String            deptId;
    
    private List<Long>    roleList;
    
    private String              roleId;
    
    private String              authId;
    
    /**
     * 是否接口查询
     */
    private String              isInterface;
    
    public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	@Override
    public Map<String, String> getParameters() {
        Map<String, String> map = new HashMap<String, String>();
        if (StringUtil.isNotBlank(account)) {
            map.put("account", account.trim());
        }
        if (StringUtil.isNotBlank(realName)) {
            map.put("realName", realName.trim());
        }
        if (StringUtil.isNotBlank(status)) {
            map.put("status", status);
        }
        if (StringUtil.isNotBlank(userType)) {
            map.put("userType", userType);
        }
        if (StringUtil.isNotBlank(startDate)) {
            map.put("startDate", startDate);
        }
        if (StringUtil.isNotBlank(endDate)) {
            map.put("endDate", endDate);
        }
        if (StringUtil.isNotBlank(agentUserType)) {
            map.put("agentUserType", agentUserType);
        }
        if (StringUtil.isNotBlank(roleId)) {
            map.put("roleId", roleId);
        }
        if (StringUtil.isNotBlank(authId)) {
            map.put("authId", authId);
        }
        return map;
    }

    public String getAccount() {
    	if(account!=null)
    		account =  account.trim();
    		
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getRealName() {
		if(realName!=null)
			realName =  realName.trim();
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
        
    public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getAgentUserType() {
		return agentUserType;
	}

	public void setAgentUserType(String agentUserType) {
		this.agentUserType = agentUserType;
	}
	
	public List<Long> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<Long> roleList) {
		this.roleList = roleList;
	}

	public void setSearchDate(int date){
        if (StringUtil.isBlank(startDate) || StringUtil.isBlank(endDate)) {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.DATE, -date);
            startDate = dateFormat.format(calendar.getTime());
            endDate = dateFormat.format(new Date());
        }
    }

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getAuthId() {
		return authId;
	}

	public void setAuthId(String authId) {
		this.authId = authId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIsInterface() {
		return isInterface;
	}

	public void setIsInterface(String isInterface) {
		this.isInterface = isInterface;
	}
}
