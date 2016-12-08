package com.hundsun.jresplus.quickstart.biz.service;

import java.util.List;

import com.hundsun.jresplus.quickstart.biz.bo.Result;
import com.hundsun.jresplus.quickstart.biz.po.User;
import com.hundsun.jresplus.quickstart.biz.query.UserQuery;
import com.hundsun.jresplus.quickstart.common.UserAgent;

public interface UserService {

    /**
     * 分页查询user
     * @param query
     * @return UsersQuery
     */
    UserQuery selectUserByPage(UserQuery query);

    /**
     * 新增user
     * @param user
     * @param userAgent
     * @return boolean
     */
    boolean addUser(User user);

    /**
     * 根据用户帐号获取用户对象
     * @param account
     * @return
     */
    public User getUserByAccount(String account);

    /**
     * 更新用户状态
     * @param user
     * @param userAgent
     * @return boolean
     */
    public boolean updateUserStatus(User user);

    /**
     * 主键获取user对象
     * @param id
     * @return User
     */
    User selectUserById(Long id);
    
    User getById(Long id);

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
    boolean resetPassword(User user);

    /**
     * 修改密码
     * @param user
     * @param userAgent
     * @return boolean
     */
    boolean updateUserPassword(User user);

    /**
     * 修改user和userInfo
     * @param user
     * @param userAgent
     * @return boolean
     */
    boolean updateUserWithInfo(User user);

    /**
     * 根据用户编号获取用户
     * @param id
     * @return
     */
    public User getUserByID(Long id);

    /**
     * 查询所有用户信息
     * @return
     */
    public List<User> getUserList();

    /**
     * 检查用户名密码是否正确
     * @param user
     * @return
     */
    public boolean checkAccountAndPassword(User user);

    /**
     * 查询用户信息
     * @param account
     * @return
     */
    public User queryUserByAccount(String account);

    public UserQuery selectUserByAuth(Long authId, Long sysId, UserQuery query);

    public List<User> selectListByRoleList(Long authId, Long sysId, UserQuery query);

    User selectUserByAccount(String account);

    void updatePrepayById(Long id, double d);
    void updateScoreById(Long id, double d);

    boolean checkUserNameUnique(Long id, String username);

    boolean checkEmailUnique(Long id, String email);

    boolean checkMobileUnique(Long id, String mobile);

    void update(User userInfo);

    void update4Edit(User userInfo);

    boolean insert4Register(User user);

    Result passwordEdit(UserAgent user, String pwdOld, String pwdNew, String pwdConfirm);

    User getByUserName(String userName);

	void updateEdit(User userInfo);
}
