package com.hundsun.jresplus.quickstart.biz.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.hundsun.jresplus.quickstart.biz.po.User;
import com.hundsun.jresplus.quickstart.biz.query.UserQuery;

public interface UserDAO {
    /**
     * 通过id删除用户信息
     * @param id
     * @return
     */
    int delete(Long id);

    /**
     * 新增用户信息
     * @param record
     */
    Long insert(User record);

    /**
    * 更新用户信息
    * @param record
    * @return
    */
    int update(User record);

    /**
     * 通过用户id查询用户信息
     * @param id
     * @return
     */
    User selectById(Long id);

    /**
     * 通过指定条件查询用户信息
     * @param record
     * @return
     */
    List<User> select(User record);

    /**
     *分页检索文件
     * @param query(封装分页的信息)
     * @return
     * @throws SQLException
     */
    UserQuery serarchByPage(UserQuery query);

    void updatePrepayById(Map map);

    Long getIdByUsername(String username);

    Long getIdByEmail(String email);

    Long getIdByMobile(String mobile);

	void updateScoreById(Map map);

    int update4Edit(User userInfo);

    Long insert4Register(User user);

    int updatePassword(String userName, String md5Encode, String md5Encode2);

    User getByUserName(String userName);

    User getById(Long id);

	int updateEdit(User userInfo);

}