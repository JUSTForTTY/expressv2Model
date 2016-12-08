package com.hundsun.jresplus.quickstart.biz.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hundsun.jresplus.common.util.StringUtil;
import com.hundsun.jresplus.quickstart.biz.dao.UsersDAO;
import com.hundsun.jresplus.quickstart.biz.po.Users;
import com.hundsun.jresplus.quickstart.biz.query.UsersQuery;
import com.hundsun.jresplus.quickstart.biz.service.UsersService;
import com.hundsun.jresplus.quickstart.enums.EnumUserStatus;


@Service("usersService")
public class UsersServiceImpl  implements UsersService{

	protected Log      log = LogFactory.getLog(this.getClass());

	@Autowired
	UsersDAO userDao;

	
	public Users getUserByAccount(String account) {
		Users user = new Users();
		user.setAccount(account);
		user.setStatus(EnumUserStatus.NORMAL.getCode());
		List<Users> userList = userDao.select(user);
		if(userList!=null && userList.size()>0){
			user =  userList.get(0);
//			Long[] roleIds = getRolesByUserID(user.getId());
//			user.setRoleId(roleIds);
			return user;
		}
		return null;
	}
	
	
	public Users selectUserByAccount(String account) {
		Users user = new Users();
		user.setAccount(account);
		user.setStatus(EnumUserStatus.NORMAL.getCode());
		List<Users> userList = userDao.select(user);
		if(userList!=null && userList.size()>0){
			return userList.get(0);
		}
		return null;
	}
	
	public Users queryUserByAccount(String account) {
		Users user = new Users();
		user.setAccount(account);
	/*	user.setStatus(EnumUserStatus.USE_STATUS.getCode());*/
		List<Users> userList = userDao.select(user);
		if(userList!=null && userList.size()>0){
			user =  userList.get(0);
//			Long[] roleIds = getRolesByUserID(user.getId());
//			user.setRoleId(roleIds);
			return user;
		}
		return null;
	}
	
	public boolean updateUserStatus(Users user){
		log.info("UsersServiceImpl.updateUser method");
		try {
			String str = "";
			if(userDao.update(user)>0){
				
			}
		} catch (Exception e) {
            log.error(e.getMessage());
            return false;
        }
		return true;
	}

	
	public UsersQuery selectUsersByPage(UsersQuery query) {
		log.info("UsersServiceImpl.selectByPage method");
        try {
            return userDao.serarchByPage(query);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return null;
	}

	
	public boolean addUser(Users user) {
		log.info("UsersServiceImpl.addUser method");
        try {
        	String psw = "" ;
        	if(StringUtil.isBlank(psw)){
                psw = "123456";
            }
        	//MD5加密
        	user.setStatus(EnumUserStatus.NORMAL.getCode());
        	//新增user
        	Long userId = userDao.insert(user) ;
        	return  userId!=null;
        } catch (Exception e) {
            log.error(e.getMessage());
        }
		return false;
	}

	
	public Users selectUserById(Long id) {
		log.info("UsersServiceImpl.selectUserById method");
		try {
		    return userDao.selectById(id);
		} catch (Exception e) {
	        log.error(e.getMessage());
	    }
		return null;
	}

	
	public boolean deleteUserById(Long userId) {
		log.info("UsersServiceImpl.deleteUserById method");
		try {
			if(userDao.delete(userId)>0){
				return true;
			}
		} catch (Exception e) {
	        log.error(e.getMessage());
	    }
		return false;
	}

	
	public boolean resetPassword(Users user) {
		return false;
	}

	
	public boolean updateUserPassword(Users user) {
    	return false;
	}

	
	public boolean updateUserWithInfo(Users user) {
		boolean flag = false ;
		return flag ;
	}

	
	public Users getUserByID(long id) {
		Users user = new Users();
		user.setId(id);
		user.setStatus(EnumUserStatus.NORMAL.getCode());
		List<Users> userList = userDao.select(user);
		if(userList!=null && userList.size()>0){
			user =  userList.get(0);
//			Long[] roleIds = getRolesByUserID(user.getId());
//			user.setRoleId(roleIds);
			return user;
		}
		return null;
	}

	
	public List<Users> getUserList() {
		return userDao.select(new Users());
	}

	public boolean checkAccountAndPassword(Users user) {
			return false;
	}

	
	public UsersQuery selectUsersByAuth(Long authId, Long sysId,UsersQuery query) {
        return null;
	}
	
	public List<Users> selectListByRoleList(Long authId, Long sysId,UsersQuery query) {
		log.info("UsersServiceImpl.selectListByRoleList method");
        return null;
	}
}
