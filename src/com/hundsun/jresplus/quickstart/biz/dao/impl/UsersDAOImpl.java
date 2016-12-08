package com.hundsun.jresplus.quickstart.biz.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hundsun.jresplus.quickstart.biz.dao.UsersDAO;
import com.hundsun.jresplus.quickstart.biz.po.Users;
import com.hundsun.jresplus.quickstart.biz.query.UsersQuery;
import com.hundsun.jresplus.quickstart.enums.EnumUserStatus;
import com.hundsun.network.common.dao.BaseDAO;

@Repository("usersDao")
public class UsersDAOImpl extends BaseDAO implements UsersDAO {

	
	public Long insert(Users record) {
		 if(record!=null){
			 return (Long) this.getSqlMapClientTemplate().insert("USERS.INSERT",record);
		 }
		 return null;
	}

	@SuppressWarnings("unchecked")
	public List<Users> select(Users record) {
		if(record!=null){
			return this.getSqlMapClientTemplate().queryForList("USERS.SELECT", record);
		}
		return null;
	}

	
	public Users selectById(Long id) {
		if(id!=null){
			return (Users) this.getSqlMapClientTemplate().queryForObject("USERS.SELECT_BY_ID",id);
		}
		return null;
	}

	
	public int update(Users record) {
		if(record!=null){
			return this.getSqlMapClientTemplate().update("USERS.UPDATE", record);
		}
		return 0;
	}

	
	public int delete(Long id) {
		if(id!=null){
			Users user = selectById(id);
			if(user!=null){
				user.setStatus(EnumUserStatus.DELETE_STATUS.getCode());
				return this.getSqlMapClientTemplate().update("USERS.UPDATE", user);
			}
		}
		return 0;
	}
	
	
    public UsersQuery serarchByPage(UsersQuery query) {
        query = (UsersQuery) this.getPagination(query, "USERS.usersCountAll",
            "USERS.usersSelectAll");
        return query;

    }

  }