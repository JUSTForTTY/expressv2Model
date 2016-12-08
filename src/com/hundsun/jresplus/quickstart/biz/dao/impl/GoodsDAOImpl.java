package com.hundsun.jresplus.quickstart.biz.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import com.hundsun.jresplus.quickstart.biz.dao.GoodsDAO;
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
import com.hundsun.network.common.dao.BaseDAO;

@Repository("goodsDAO")
public class GoodsDAOImpl extends BaseDAO implements GoodsDAO {

    private static final String SQL_SPACE = "GOODS.";

    @Override
    public Goods getById(Long id) {
        return (Goods) this.getSqlMapClientTemplate().queryForObject(SQL_SPACE + "getById", id);
    }

    @Override
    public void getPagination(GoodsQuery query) {
        this.getPagination(query, SQL_SPACE + "providerCount", SQL_SPACE + "providerList");
    }

    @Override
    public void getPagination(GoodsQuery query, Model model) {
        this.getPagination(query, SQL_SPACE + "buildingGoodsCount", SQL_SPACE + "buildingGoodsList");
    }

    @Override
    public void getAuctionPagination(GoodsQuery query, Model model) {
        this.getPagination(query, SQL_SPACE + "AuctionGoodsCount", SQL_SPACE + "AuctionGoodsList");
    }

    @Override
    public void getPagination(NormalGoodsQuery query, Model model) {
        this.getPagination(query, SQL_SPACE + "normalGoodsCount", SQL_SPACE + "normalGoodsList");
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Goods> getGoodsList(GoodsQuery query) {
        return (List<Goods>) this.getSqlMapClientTemplate().queryForList(
            SQL_SPACE + "saleForEight", query);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void getProviderList(GoodsQuery query,Model model) {
       
        this.getPagination(query, SQL_SPACE + "providerGoodsCount", SQL_SPACE + "providerGoodsList");
        
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Goods> getHouseList(GoodsQuery query) {
        return (List<Goods>) this.getSqlMapClientTemplate().queryForList(
            SQL_SPACE + "saleForEight", query);
    }

    @Override
    public Goods create(Long goodsid) {
        Goods goods = getById(goodsid);
        return (Goods) this.getSqlMapClientTemplate().insert(SQL_SPACE + "create", goods);
    }

    @Override
    public GoodsCollect getCollectionById(Long goodsid) {
        return (GoodsCollect) this.getSqlMapClientTemplate().queryForObject(
            SQL_SPACE + "getBygoodsId", goodsid);
    }

    @Override
    public void increaseSpecificNumById(Map map) {
        this.getSqlMapClientTemplate().update(SQL_SPACE + "increaseSpecificNumById", map);
    }

    @Override
    public Integer getGoodsCountByQuery(GoodsQuery query) {
        return (Integer) this.getSqlMapClientTemplate().queryForObject(
            SQL_SPACE + "buildingGoodsCount", query);
    }

	@Override
	public void getSocityPagination(SocityClubQuery query,Model model) {
		
		
      this.getPagination(query, SQL_SPACE + "socityClubCount", SQL_SPACE + "socityClubList");
		
	}

	@Override
	public Club getById(String id) {
		// 
		
		
	 return (Club) this.getSqlMapClientTemplate().queryForObject(SQL_SPACE + "getClubById", id);
	}

	@Override
	public void getClubMemberPagination(SocityClubQuery socityClubQuery) {
		 
		
		this.getPagination(socityClubQuery, SQL_SPACE + "socityClubMemberCount", SQL_SPACE + "socityClubMemberList");
	}
	
	

	@Override
	public void getActivityPagination(SocityActivityQuery socityActivityQuery,Model model) {
		 
		
		
		this.getPagination(socityActivityQuery, SQL_SPACE + "socityActivityCount", SQL_SPACE + "socityActivityList");
		
	}

	@Override
	public boolean checkClubMember(SocityClubMemberQuery socityClubMemberQuery) {
		// 
		
		
		  Integer size= (Integer) this.getSqlMapClientTemplate().queryForObject(
		            SQL_SPACE + "checkSocityClubMember", socityClubMemberQuery);
		  if(size>0){
			  return true;
		  }else{
			  return false; 
		  }
		
		 
	}

	@Override
	public void saveClubMember(ClubMember ciubmember) {
		// 
		
		this.getSqlMapClientTemplate().update(SQL_SPACE + "increaseClubMember", ciubmember);
		
	}

	@Override
	public String getSequence(Sequence suquence) {
		// TODO Auto-generated method stub
		 
		//先insert，再查询出sequence
		this.getSqlMapClientTemplate().update(SQL_SPACE + "increaseSeqno", suquence.getTablename());
		
	     Integer seqno = (Integer) this.getSqlMapClientTemplate().queryForObject(
		            SQL_SPACE + "getMaxSeqno", suquence.getTablename());
		
		 
		return seqno.toString();
		
	}

	@Override
	public Activity getActivityById(String id) {
		 
		
		
	  return (Activity) this.getSqlMapClientTemplate().queryForObject(SQL_SPACE + "getActivityById", id);
	}

	@Override
	public void getActivityMemberPagination(SocityActivityQuery query) {
		 
		
		this.getPagination(query, SQL_SPACE + "socityActivityMemberCount", SQL_SPACE + "socityActivityMemberList");
		
	}

	@Override
	public void getActivityProjectPagination(SocityActivityQuery query) {
		// 
		
		this.getPagination(query, SQL_SPACE + "socityActivityProjectCount", SQL_SPACE + "socityActivityProjectList");
		
	}

	@Override
	public List<ClubMember> getClubMember(SocityClubQuery query) {
		// 

	    
		
		return this.getSqlMapClientTemplate().queryForList(SQL_SPACE+"socityClubMemberListSimple",query);
	}

	@Override
	public ActivityProject getActivityProjectById(String apid) {
		 
		 return (ActivityProject) this.getSqlMapClientTemplate().queryForObject(SQL_SPACE + "getActivityProjectById", apid);
	}

	@Override
	public ActivityMember getActivityMemberById(String aid) {
		
		
		
		return (ActivityMember) this.getSqlMapClientTemplate().queryForObject(SQL_SPACE + "getActivityMemberById", aid);
	}

	@Override
	public ClubMember selectClubMember(ClubMember clubMember) {
		 
		
		return (ClubMember) this.getSqlMapClientTemplate().queryForObject(SQL_SPACE + "selectClubMember", clubMember);
	}

	@Override
	public void saveOrUpdateActivityMember(ActivityMember activityMemberbean, ActivityMember activityMember,
			ClubMember useragent, ActivityProject activityProject) {
		 
		
		
		
	}

	@Override
	public void saveActivityMember(ActivityMember activityMember) {
		//  
		
		
		this.getSqlMapClientTemplate().update(SQL_SPACE + "increaseActivityMember", activityMember);
		
	}

	@Override
	public void updateActivityMember(ActivityMember activityMember) {
		// 
		this.getSqlMapClientTemplate().update(SQL_SPACE + "updateActivityMember", activityMember);
	}

	@Override
	public void insertLog(Log log) {


		this.getSqlMapClientTemplate().update(SQL_SPACE + "increaseLog", log);
		
	}

	@Override
	public void insertUserCostItem(UserCostItem userCostItem) {
		
		
		this.getSqlMapClientTemplate().update(SQL_SPACE + "increaseUserCostItem", userCostItem);
		
	}

	@Override
	public Log getLogById(String lid) {

     
		return (Log) this.getSqlMapClientTemplate().queryForObject(SQL_SPACE + "getLogById", lid);
	}

	@Override
	public void addActivtyClickNum(String aid) {
		
		
		this.getSqlMapClientTemplate().update(SQL_SPACE + "increaseActivityClickNum", aid);
		
	}

	@Override
	public void updateLog(Log log) {
		 
		this.getSqlMapClientTemplate().update(SQL_SPACE + "updateLog", log);
		
	}

	@Override
	public void updateUserCostItem(UserCostItem userCostItem) {
		 
		
		this.getSqlMapClientTemplate().update(SQL_SPACE + "updateUserCostItem", userCostItem);
	}

}
