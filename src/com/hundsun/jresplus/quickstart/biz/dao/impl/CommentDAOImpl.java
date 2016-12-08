package com.hundsun.jresplus.quickstart.biz.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import com.hundsun.jresplus.quickstart.biz.dao.CommentDAO;
import com.hundsun.jresplus.quickstart.biz.po.Comment;
import com.hundsun.jresplus.quickstart.biz.query.ActivityCommentQuery;
import com.hundsun.jresplus.quickstart.biz.query.CommentQuery;
import com.hundsun.network.common.dao.BaseDAO;

@Repository("commentDAO")
public class CommentDAOImpl extends BaseDAO implements CommentDAO {
    private final String SQL_SPACE = "COMMENTS.";

    @Override
    public Comment getById(Long id) {
        // TODO Auto-generated method stub
        return (Comment) this.getSqlMapClientTemplate().queryForObject(SQL_SPACE + "getById", id);
    }

    @Override
    public void getPagination(CommentQuery query, Model model) {
        // TODO Auto-generated method stub
        this.getPagination(query, SQL_SPACE + "commentCount", SQL_SPACE + "commentList");
    }

    @Override
    public Comment create(Comment comment) {
        // TODO Auto-generated method stub
        return (Comment) this.getSqlMapClientTemplate().insert(SQL_SPACE + "create", comment);
    }

    @Override
    public Long insert(Comment comment) {
        return (Long) this.getSqlMapClientTemplate().insert(SQL_SPACE + "insert", comment);
    }
    
    @Override
	public int delete(Long id) {
		// TODO Auto-generated method stub
		return this.getSqlMapClientTemplate().delete(SQL_SPACE+"delete",id);
	}

	@Override
	public Comment update(Long id) {
		// TODO Auto-generated method stub
		return (Comment) this.getSqlMapClientTemplate().queryForObject(SQL_SPACE+"update",id);
	}

	@Override
	public int update(Comment comment) {
		// TODO Auto-generated method stub
		return this.getSqlMapClientTemplate().update(SQL_SPACE+"doUpdate",comment);
	}

	@Override
	public void getNewCommentList(ActivityCommentQuery activityCommentQuery) {
		 
		 
		 this.getPagination(activityCommentQuery, SQL_SPACE + "newCommentCount", SQL_SPACE + "newCommentList");
		
	}

}
