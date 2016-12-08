package com.hundsun.jresplus.quickstart.biz.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.hundsun.jresplus.quickstart.biz.po.Users;
import com.hundsun.jresplus.quickstart.biz.query.UsersQuery;

public interface UsersService {

	/**
	 * 分页查询user
	 * @param query
	 * @return UsersQuery
	 */
	UsersQuery selectUsersByPage(UsersQuery query);

	/**
	 * 新增user
	 * @param user
	 * @param userAgent
	 * @return boolean
	 */
	boolean addUser(Users user);


	/**
	 * 根据用户帐号获取用户对象
	 * @param account
	 * @return
	 */
	public Users getUserByAccount(String account);

	/**
	 * 更新用户状态
	 * @param user
	 * @param userAgent
	 * @return boolean
	 */
	public boolean updateUserStatus(Users user);

	/**
	 * 主键获取user对象
	 * @param id
	 * @return Users
	 */
	Users selectUserById(Long id);

	/**
	 * 删除user，逻辑删除
	 * @param userId
	 * @param userAgent
	 * @return boolean
	 */
	boolean deleteUserById(Long userId);

	/**
	 * 重置密码
	 * @param user
	 * @param userAgent
	 * @return boolean
	 */
	boolean resetPassword(Users user);

	/**
	 * 修改密码
	 * @param user
	 * @param userAgent
	 * @return boolean
	 */
	boolean updateUserPassword(Users user);

	/**
	 * 修改user和userInfo
	 * @param user
	 * @param userAgent
	 * @return boolean
	 */
	boolean updateUserWithInfo(Users user);

	/**
	 * 根据用户编号获取用户
	 * @param id
	 * @return
	 */
	public Users getUserByID(long id);

	/**
	 * 查询所有用户信息
	 * @return
	 */
	public List<Users> getUserList();

	/**
	 * 检查用户名密码是否正确
	 * @param user
	 * @return
	 */
	public boolean checkAccountAndPassword(Users user);

	/**
	 * 查询用户信息
	 * @param account
	 * @return
	 */
	public Users queryUserByAccount(String account);
	
	
	public UsersQuery  selectUsersByAuth(Long authId,Long sysId,UsersQuery query);

	public List<Users> selectListByRoleList(Long authId, Long sysId,UsersQuery query) ;

	Users selectUserByAccount(String account);
}
