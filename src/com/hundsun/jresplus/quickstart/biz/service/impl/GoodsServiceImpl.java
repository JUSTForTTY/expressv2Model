package com.hundsun.jresplus.quickstart.biz.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.hundsun.jresplus.common.util.StringUtil;
import com.hundsun.jresplus.quickstart.biz.dao.GoodsDAO;
import com.hundsun.jresplus.quickstart.biz.po.Activity;
import com.hundsun.jresplus.quickstart.biz.po.ActivityMember;
import com.hundsun.jresplus.quickstart.biz.po.ActivityProject;
import com.hundsun.jresplus.quickstart.biz.po.Club;
import com.hundsun.jresplus.quickstart.biz.po.ClubMember;
import com.hundsun.jresplus.quickstart.biz.po.Goods;
import com.hundsun.jresplus.quickstart.biz.po.GoodsCollect;
import com.hundsun.jresplus.quickstart.biz.po.Log;
import com.hundsun.jresplus.quickstart.biz.po.Sequence;
import com.hundsun.jresplus.quickstart.biz.po.UserCostItem;
import com.hundsun.jresplus.quickstart.biz.query.GoodsQuery;
import com.hundsun.jresplus.quickstart.biz.query.NormalGoodsQuery;
import com.hundsun.jresplus.quickstart.biz.query.SocityActivityQuery;
import com.hundsun.jresplus.quickstart.biz.query.SocityClubMemberQuery;
import com.hundsun.jresplus.quickstart.biz.query.SocityClubQuery;
import com.hundsun.jresplus.quickstart.biz.service.BaseService;
import com.hundsun.jresplus.quickstart.biz.service.GoodsService;
 
import com.hundsun.jresplus.quickstart.common.CommonDefine;

@Service("goodsService")
public class GoodsServiceImpl extends BaseService implements GoodsService {

    @Autowired
    private GoodsDAO goodsDAO;

    @Override
    public void getPagination(GoodsQuery query) {
        goodsDAO.getPagination(query);
    }

    @Override
    public Goods getById(Long id) {
        Goods goods = goodsDAO.getById(id);
        // 图片列表整理
        List<String> imageList = new ArrayList<String>();
        String image1 = goods.getImage1();
        String image2 = goods.getImage2();
        String image3 = goods.getImage3();
        String image4 = goods.getImage4();
        String image5 = goods.getImage5();
        if (StringUtil.isNotBlank(image1)) {
            imageList.add(image1);
        }
        if (StringUtil.isNotBlank(image2)) {
            imageList.add(image2);
        }
        if (StringUtil.isNotBlank(image3)) {
            imageList.add(image3);
        }
        if (StringUtil.isNotBlank(image4)) {
            imageList.add(image4);
        }
        if (StringUtil.isNotBlank(image5)) {
            imageList.add(image5);
        }
        goods.setImageList(imageList);
        return goods;
    }

    @Override
    public void getPagination(GoodsQuery query, Model model) {
        goodsDAO.getPagination(query, model);
    }

    @Override
    public void getAuctionPagination(GoodsQuery query, Model model) {
        goodsDAO.getAuctionPagination(query, model);
    }

    @Override
    public void getPagination(NormalGoodsQuery query, Model model) {
        goodsDAO.getPagination(query, model);

    }

    @Override
    public List<Goods> getGoodsList(GoodsQuery query) {
        return goodsDAO.getGoodsList(query);
    }

    @Override
    public void getProviderList(GoodsQuery query,Model model) {
          goodsDAO.getProviderList(query,model);
    }


    @Override
    public List<Goods> getHouseList(GoodsQuery query) {
        return goodsDAO.getHouseList(query);
    }

    @Override
    public Goods create(Long goodsid) {
        return goodsDAO.create(goodsid);
    }

    @Override
    public GoodsCollect getCollectionById(Long goodsid) {
        return (GoodsCollect) goodsDAO.getCollectionById(goodsid);
    }

    @Override
    public void increaseSpecificNumById(Long goods_id, String numfield, Integer num) {
        Map map = new HashMap();
        map.put("id", goods_id);
        map.put("numfield", numfield);
        map.put("num", num);
        goodsDAO.increaseSpecificNumById(map);
    }

    @Override
    public boolean isInSupply(Long goodId, Integer num) {
        Goods goods = goodsDAO.getById(goodId);
        if (goods == null) {
            return false;
        } else {
            // 库存
            Long stocknum = goods.getStocknum();
            // 订购数
            Long ordernum = goods.getOrdernum();
            // 库存-订购数
            Long remainnum = (stocknum == null || ordernum == null) ? 0 : (stocknum - ordernum);
            if (num <= remainnum) {
                return true;
            } else {
                return false;
            }
        }
    }

    @Override
    public Integer getGoodsCountByQuery(GoodsQuery query) {
        return goodsDAO.getGoodsCountByQuery(query);
    }

	@Override
	public void getSocietyPagination(SocityClubQuery query,Model model) {
		 
		goodsDAO.getSocityPagination(query, model);;
	}

	@Override
	public Club getById(String cid) {
		// 
		
		
		return goodsDAO.getById(cid);
	}

	@Override
	public void getClubMemberPagination(SocityClubQuery socityClubQuery) {
		//
		
		goodsDAO.getClubMemberPagination(socityClubQuery);
		
	}

	@Override
	public void getActivityPagination(SocityActivityQuery query,Model model) {
		 
		
		goodsDAO.getActivityPagination(query,model);
		
	}

	@Override
	public boolean checkClubMember(SocityClubMemberQuery query) {
		// 
		
		
		return goodsDAO.checkClubMember(query);
	}

	@Override
	public void saveClubMember(ClubMember club) {
		// 
		
		
		goodsDAO.saveClubMember(club);
	}

	@Override
	public String getSequence(Sequence sequence) {
		// 
		
		
		
		return goodsDAO.getSequence(sequence);
	}

	@Override
	public Activity getActivityById(String aid) {
		 
		
		
		
		return goodsDAO.getActivityById(aid);
	}

	@Override
	public void getActivityMemberPagination(SocityActivityQuery query) {
		//
		
		
		goodsDAO.getActivityMemberPagination(query);
		
	}

	@Override
	public void getActivityProjectPagination(SocityActivityQuery query) {
		
		
		goodsDAO.getActivityProjectPagination(query);
	}

	@Override
	public List<ClubMember> getClubMember(SocityClubQuery query) {
		
		
		
		return goodsDAO.getClubMember(query);
	}

	@Override
	public ActivityProject getActivityProjectById(String apid) {
		// 
		
		
		return goodsDAO.getActivityProjectById(apid);
	}

	@Override
	public ActivityMember getActivityMemberById(String aid) {
		// TODO Auto-generated method stub
		return goodsDAO.getActivityMemberById(aid);
	}

	@Override
	public ClubMember selectClubMember(ClubMember clubMember) {
		  
		
		return goodsDAO.selectClubMember(clubMember);
	}

	@Override
	public void saveOrUpdateActivityMember(ActivityMember activityMemberbean, ActivityMember activityMember,
     ClubMember useragent, ActivityProject activityProject) {
		 
		// 增加
				if(null==activityMemberbean||"".equals(activityMemberbean)){
					
					Sequence sequence=new Sequence();
					sequence.setTablename("AMID");
					String amid=goodsDAO.getSequence(sequence);
					//String sql="CALL pro_getRunningNO('AMID')";
					
					
					activityMemberbean=new ActivityMember();
					activityMemberbean.setAmid(amid);
					activityMemberbean.setBid(0);
					activityMemberbean.setAid(activityProject.getAid());
					activityMemberbean.setCmid(useragent.getCmid());
					activityMemberbean.setName(activityMember.getName());
					activityMemberbean.setMobile(activityMember.getMobile());
					activityMemberbean.setCreateUser(useragent.getUid());
					activityMemberbean.setCreateTime(new Timestamp(new Date().getTime()));
					activityMemberbean.setModifyUser(useragent.getUid());
					activityMemberbean.setModifyTime(new Timestamp(new Date().getTime()));
					goodsDAO.saveActivityMember(activityMemberbean);
				}
				//更新
				else{
					activityMemberbean.setName(activityMember.getName());
					activityMemberbean.setMobile(activityMember.getMobile());
					activityMemberbean.setModifyUser(useragent.getUid());
					activityMemberbean.setModifyTime(new Timestamp(new Date().getTime()));
					goodsDAO.updateActivityMember(activityMemberbean);
				}
				
				 
		
		
		
	}

	@Override
	public void insertLog(Log log) {
		 
		goodsDAO.insertLog(log);
	}

	@Override
	public void insertUserCostItem(UserCostItem userCostItem) {
		
		goodsDAO.insertUserCostItem(userCostItem);
		
		
	}

	@Override
	public Log getLogById(String lid) {
		 
		
		return goodsDAO.getLogById(lid);
	}

	@Override
	public void addActivityClickNum(String aid) {
		 
		goodsDAO.addActivtyClickNum(aid);
	}

	@Override
	public void updateLog(Log log) {
		 
		goodsDAO.updateLog(log);
	}

	@Override
	public void updateUserCostItem(UserCostItem userCostItem) {
		 goodsDAO.updateUserCostItem(userCostItem);
		
	}
}
