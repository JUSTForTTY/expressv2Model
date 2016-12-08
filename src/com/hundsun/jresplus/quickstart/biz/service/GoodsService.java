package com.hundsun.jresplus.quickstart.biz.service;

import java.util.List;

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

public interface GoodsService {

    public void getPagination(GoodsQuery query);

    public Goods getById(Long id);
    
    public Club  getById(String cid);
    
    public Activity getActivityById(String aid);
    
    public Log getLogById(String lid);
    
    public void getClubMemberPagination(SocityClubQuery query);
    
    public List<ClubMember>  getClubMember(SocityClubQuery query);
    
    public void getActivityMemberPagination(SocityActivityQuery query);
    
    public void getActivityProjectPagination(SocityActivityQuery query); 
    
    public ActivityProject getActivityProjectById(String apid);
    
    public ActivityMember  getActivityMemberById(String aid);
    
    public ClubMember   selectClubMember(ClubMember clubMember);
    
    public void saveOrUpdateActivityMember(ActivityMember activityMemberbean,ActivityMember activityMember,ClubMember useragent,ActivityProject activityProject);
    
    public  void addActivityClickNum(String aid);
    
    public void insertLog(Log log);
    
    public void updateLog(Log log);
    
    public void insertUserCostItem(UserCostItem userCostItem);
    
    public void updateUserCostItem(UserCostItem userCostItem);
    
    public void getActivityPagination(SocityActivityQuery query,Model model);
    
    public boolean checkClubMember(SocityClubMemberQuery query);
    
    
    public void saveClubMember(ClubMember club);
    
    public String getSequence(Sequence sequence);
    
    public void getPagination(GoodsQuery query, Model model);
    
    public void getSocietyPagination(SocityClubQuery query,Model model);
    
    public void getPagination(NormalGoodsQuery query, Model model);
    
    public List<Goods> getGoodsList(GoodsQuery query);
    
    public   void getProviderList(GoodsQuery query,Model model);
    
    public List<Goods> getHouseList(GoodsQuery query);
    
    public void getAuctionPagination(GoodsQuery query, Model model);
    
    public Goods create(Long goodsid);
    
    public GoodsCollect getCollectionById(Long goodsid);

    public void increaseSpecificNumById(Long goods_id, String string, Integer itemnum);

    public boolean isInSupply(Long goodId, Integer num);

    public Integer getGoodsCountByQuery(GoodsQuery query);

}
