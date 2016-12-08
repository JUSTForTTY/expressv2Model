package com.hundsun.jresplus.quickstart.biz.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.hundsun.jresplus.quickstart.biz.dao.UserDAO;
import com.hundsun.jresplus.quickstart.biz.po.User;
import com.hundsun.jresplus.quickstart.biz.query.UserQuery;
import com.hundsun.jresplus.quickstart.enums.EnumUserStatus;
import com.hundsun.network.common.dao.BaseDAO;

@Repository("userDAO")
public class UserDAOImpl extends BaseDAO implements UserDAO {

    public Long insert(User record) {
        if (record != null) {
            return (Long) this.getSqlMapClientTemplate().insert("USER.INSERT", record);
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    public List<User> select(User record) {
        if (record != null) {
            return this.getSqlMapClientTemplate().queryForList("USER.SELECT", record);
        }
        return null;
    }

    public User selectById(Long id) {
        if (id != null) {
            return (User) this.getSqlMapClientTemplate().queryForObject("USER.SELECT_BY_ID", id);
        }
        return null;
    }

    public int update(User record) {
        if (record != null) {
            return this.getSqlMapClientTemplate().update("USER.UPDATE", record);
        }
        return 0;
    }

    public int update4Edit(User record) {
    
        return this.getSqlMapClientTemplate().update("USER.update4Edit", record);
    }
    public int updateEdit(User userInfo) {
    	
    	return this.getSqlMapClientTemplate().update("USER.updateEdit", userInfo);
    }

    public int delete(Long id) {
        if (id != null) {
            User user = selectById(id);
            if (user != null) {
                user.setStatus(EnumUserStatus.DELETE_STATUS.getCode());
                return this.getSqlMapClientTemplate().update("USER.UPDATE", user);
            }
        }
        return 0;
    }

    public UserQuery serarchByPage(UserQuery query) {
        return null;

    }

    @Override
    public void updatePrepayById(Map map) {
        this.getSqlMapClientTemplate().update("USER.updatePrepayById", map);
    }

    @Override
    public void updateScoreById(Map map) {
        this.getSqlMapClientTemplate().update("USER.updateScoreById", map);
    }

    @Override
    public Long getIdByUsername(String username) {
        return (Long) this.getSqlMapClientTemplate().queryForObject("USER.getIdByUsername",
            username);
    }

    @Override
    public Long getIdByEmail(String email) {
        return (Long) this.getSqlMapClientTemplate().queryForObject("USER.getIdByEmail", email);
    }

    @Override
    public Long getIdByMobile(String mobile) {
        return (Long) this.getSqlMapClientTemplate().queryForObject("USER.getIdByMobile", mobile);
    }

    @Override
    public Long insert4Register(User user) {
        return (Long) this.getSqlMapClientTemplate().insert("USER.insert4Register", user);
    }

    @Override
    public int updatePassword(String userName, String pwdNew, String pwdOld) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("userName", userName);
        map.put("pwdNew", pwdNew);
        map.put("pwdOld", pwdOld);
        return this.getSqlMapClientTemplate().update("USER.updatePassword", map);
    }

    @Override
    public User getByUserName(String userName) {
        return (User) this.getSqlMapClientTemplate().queryForObject("USER.getByUserName", userName);
    }

    @Override
    public User getById(Long id) {
        return (User) this.getSqlMapClientTemplate().queryForObject("USER.getById", id);
    }

}