package com.hundsun.jresplus.quickstart.biz.dao;

import org.springframework.ui.Model;

import com.hundsun.jresplus.quickstart.biz.po.Comment;
import com.hundsun.jresplus.quickstart.biz.query.ActivityCommentQuery;
import com.hundsun.jresplus.quickstart.biz.query.CommentQuery;

public interface CommentDAO {

    public Comment getById(Long id);

    public void getPagination(CommentQuery query, Model model);

    //增加评论

    public Comment create(Comment comment);

    public Long insert(Comment comment);
    
	public  int  delete(Long id);
	
	public Comment update(Long id);
	
	public int update(Comment comment);
	
	public void  getNewCommentList(ActivityCommentQuery activityCommentQuery);
	

}
