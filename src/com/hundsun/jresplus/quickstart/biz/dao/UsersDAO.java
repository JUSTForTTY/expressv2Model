package com.hundsun.jresplus.quickstart.biz.dao;

import java.sql.SQLException;
import java.util.List;

import com.hundsun.jresplus.quickstart.biz.po.Users;
import com.hundsun.jresplus.quickstart.biz.query.UsersQuery;


public interface UsersDAO {
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
    Long insert(Users record);

    /**
   * 更新用户信息
   * @param record
   * @return
   */
    int update(Users record);
    
    /**
     * 通过用户id查询用户信息
     * @param id
     * @return
     */
    Users selectById(Long id);
    /**
     * 通过指定条件查询用户信息
     * @param record
     * @return
     */
    List<Users> select(Users record);

    /**
     *分页检索文件
     * @param query(封装分页的信息)
     * @return
     * @throws SQLException
     */
    UsersQuery serarchByPage(UsersQuery query);
    
  }