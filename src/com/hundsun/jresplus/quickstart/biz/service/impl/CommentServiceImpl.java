package com.hundsun.jresplus.quickstart.biz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.hundsun.jresplus.quickstart.biz.dao.CommentDAO;
import com.hundsun.jresplus.quickstart.biz.po.Comment;
import com.hundsun.jresplus.quickstart.biz.query.ActivityCommentQuery;
import com.hundsun.jresplus.quickstart.biz.query.CommentQuery;
import com.hundsun.jresplus.quickstart.biz.service.BaseService;
import com.hundsun.jresplus.quickstart.biz.service.CommentService;

@Service("commentService")
public class CommentServiceImpl extends BaseService implements CommentService {

    @Autowired
    private CommentDAO commentDAO;

    @Override
    public Comment getById(Long id) {
        // TODO Auto-generated method stub
        return commentDAO.getById(id);
    }

    @Override
    public void getPagination(CommentQuery query, Model model) {
        // TODO Auto-generated method stub
        commentDAO.getPagination(query, model);

    }

    @Override
    public Comment create(Comment comment) {
       
        return commentDAO.create(comment);
    }

    @Override
    public Long insert(Comment comment) {
        comment.setContent(comment.getContentHead() + comment.getContent());
        return commentDAO.insert(comment);
    }
    
    @Override
	public int delete(Long id) {
		// TODO Auto-generated method stub
		return commentDAO.delete(id);
	}

	@Override
	public Comment update(Long id) {
		// TODO Auto-generated method stub
		return commentDAO.update(id);
	}

	@Override
	public int update(Comment comment) {
		// TODO Auto-generated method stub
		return commentDAO.update(comment);
	}

	@Override
	public void getNewCommentList(ActivityCommentQuery activityCommentQuery) {
		// 
		
		
		 commentDAO.getNewCommentList(activityCommentQuery);
	}

}
