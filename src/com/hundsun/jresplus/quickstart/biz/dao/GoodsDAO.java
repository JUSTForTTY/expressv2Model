package com.hundsun.jresplus.quickstart.biz.dao;

import java.util.List;
import java.util.Map;

import org.springframework.ui.Model;

import com.hundsun.jresplus.quickstart.biz.po.GoodsCollect;
import com.hundsun.jresplus.quickstart.biz.po.Log;
import com.hundsun.jresplus.quickstart.biz.po.Sequence;
import com.hundsun.jresplus.quickstart.biz.po.UserCostItem;
import com.hundsun.jresplus.quickstart.biz.po.Activity;
import com.hundsun.jresplus.quickstart.biz.po.ActivityMember;
import com.hundsun.jresplus.quickstart.biz.po.ActivityProject;
import com.hundsun.jresplus.quickstart.biz.po.Club;
import com.hundsun.jresplus.quickstart.biz.po.ClubMember;
import com.hundsun.jresplus.quickstart.biz.po.Goods;
import com.hundsun.jresplus.quickstart.biz.query.GoodsQuery;
import com.hundsun.jresplus.quickstart.biz.query.NormalGoodsQuery;
 
import com.hundsun.jresplus.quickstart.biz.query.SocityActivityQuery;
import com.hundsun.jresplus.quickstart.biz.query.SocityClubMemberQuery;
import com.hundsun.jresplus.quickstart.biz.query.SocityClubQuery;

/**
 * 商品dao
 * @author chengy
 *
 */
public interface GoodsDAO {

    public Goods getById(Long id);

    public Club  getById(String id);
    
    public Activity getActivityById(String id);
    
    public void getClubMemberPagination(SocityClubQuery socityClubQuery);
    
    
    public void getActivityMemberPagination(SocityActivityQuery query);
    
    public List<ClubMember> getClubMember(SocityClubQuery query);
    
    public void getActivityProjectPagination(SocityActivityQuery query);
    
    public ActivityProject getActivityProjectById(String apid);
    
    public ActivityMember  getActivityMemberById(String aid);
    
    
    public void saveOrUpdateActivityMember(ActivityMember activityMemberbean,ActivityMember activityMember,ClubMember useragent,ActivityProject activityProject);
    
    public void saveActivityMember(ActivityMember activityMember);
    
    public void updateActivityMember(ActivityMember activityMember);
    
    public ClubMember  selectClubMember(ClubMember clubMember);
    
    public void insertLog(Log log);
    
    public void updateLog(Log log);
    
    public void insertUserCostItem(UserCostItem userCostItem);
    
    public void updateUserCostItem(UserCostItem userCostItem);
    
    public Log  getLogById(String lid);
     
    public void addActivtyClickNum(String aid);
    
    public void getActivityPagination(SocityActivityQuery socityActivityQuery,Model model);
    
    public void saveClubMember(ClubMember ciubmember);
    
    public String getSequence(Sequence suquence);
    
    public boolean checkClubMember(SocityClubMemberQuery socityClubMemberQuery);
    
    public void getPagination(GoodsQuery query);
    
    public void getSocityPagination(SocityClubQuery query,Model model);

    public void getPagination(GoodsQuery query, Model model);
    
    public void getAuctionPagination(GoodsQuery query, Model model);
    
    public void getPagination(NormalGoodsQuery query, Model model);
    
    public List<Goods> getGoodsList(GoodsQuery query);
    
    public void getProviderList(GoodsQuery query,Model model);
    
    public List<Goods> getHouseList(GoodsQuery query);
    
    public Goods create(Long goodsid);
    
    public GoodsCollect getCollectionById(Long goodsid);

    public void increaseSpecificNumById(Map map);

    public Integer getGoodsCountByQuery(GoodsQuery query);

}
