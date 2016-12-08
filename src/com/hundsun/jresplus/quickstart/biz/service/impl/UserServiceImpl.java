package com.hundsun.jresplus.quickstart.biz.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hundsun.jresplus.common.util.StringUtil;
import com.hundsun.jresplus.quickstart.biz.bo.Result;
import com.hundsun.jresplus.quickstart.biz.dao.UserDAO;
import com.hundsun.jresplus.quickstart.biz.po.GoodsCollect;
import com.hundsun.jresplus.quickstart.biz.po.User;
import com.hundsun.jresplus.quickstart.biz.query.GoodsCollectQuery;
import com.hundsun.jresplus.quickstart.biz.query.UserQuery;
import com.hundsun.jresplus.quickstart.biz.service.UserService;
import com.hundsun.jresplus.quickstart.common.UserAgent;
import com.hundsun.jresplus.quickstart.enums.EnumGoodsCollectType;
import com.hundsun.jresplus.quickstart.enums.EnumUserStatus;
import com.hundsun.jresplus.quickstart.enums.EnumUsersType;
import com.hundsun.jresplus.quickstart.utils.MD5utils;

@Service("UserService")
public class UserServiceImpl implements UserService {

    protected Log log = LogFactory.getLog(this.getClass());

    @Autowired
    UserDAO       userDAO;

    public User getUserByAccount(String username) {
        User user = new User();
        user.setUsername(username);
        List<User> userList = userDAO.select(user);
        if (userList != null && userList.size() > 0) {
            user = userList.get(0);
            return user;
        }
        return null;
    }

    public User selectUserByAccount(String username) {
        User user = new User();
        user.setUsername(username);
        List<User> userList = userDAO.select(user);
        if (userList != null && userList.size() > 0) {
            return userList.get(0);
        }
        return null;
    }

    public User queryUserByAccount(String username) {
        User user = new User();
        user.setUsername(username);
        List<User> userList = userDAO.select(user);
        if (userList != null && userList.size() > 0) {
            user = userList.get(0);
            return user;
        }
        return null;
    }

    public boolean updateUserStatus(User user) {
        log.info("UserServiceImpl.updateUser method");
        try {
            if (userDAO.update(user) > 0) {

            }
        } catch (Exception e) {
            log.error(e.getMessage());
            return false;
        }
        return true;
    }

    public UserQuery selectUserByPage(UserQuery query) {
        log.info("UserServiceImpl.selectByPage method");
        try {
            return userDAO.serarchByPage(query);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return null;
    }

    public boolean addUser(User user) {
        log.info("UserServiceImpl.addUser method");
        try {
            String psw = user.getPasswd();
            if (StringUtil.isBlank(psw)) {
                psw = "123456";
            }
            //MD5加密
            user.setPasswd(MD5utils.MD5Encode(psw));
            user.setStatus(EnumUserStatus.INIT.getCode());
            user.setUsertype(EnumUsersType.BASE_DATA.getCode());
            user.setPrepay(0D);
            user.setRegtime(new Date());
            //新增user
            Long userId = userDAO.insert(user);
            return userId != null;
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean insert4Register(User user) {
        log.info("UserServiceImpl.addUser method");
        try {
            String psw = user.getPasswd();
            if (StringUtil.isBlank(psw)) {
                psw = "123456";
            }
            //MD5加密
            user.setPasswd(MD5utils.MD5Encode(psw));
            user.setStatus(EnumUserStatus.INIT.getCode());
            user.setUsertype(EnumUsersType.BASE_DATA.getCode());
            user.setPrepay(0D);
            user.setRegtime(new Date());
            //新增user
            Long userId = userDAO.insert4Register(user);
            return userId != null;
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return false;
    }

    public User selectUserById(Long id) {
        log.info("UserServiceImpl.selectUserById method");
        try {
            return userDAO.selectById(id);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return null;
    }

    public boolean deleteUserById(Long userId) {
        log.info("UserServiceImpl.deleteUserById method");
        try {
            if (userDAO.delete(userId) > 0) {
                return true;
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return false;
    }

    public boolean resetPassword(User user) {
        return false;
    }

    public boolean updateUserPassword(User user) {
        return false;
    }

    public boolean updateUserWithInfo(User user) {
        boolean flag = false;
        return flag;
    }

    public User getUserByID(Long id) {
        User user = new User();
        user.setId(id);
        List<User> userList = userDAO.select(user);
        if (userList != null && userList.size() > 0) {
            user = userList.get(0);
            return user;
        }
        return null;
    }

    public List<User> getUserList() {
        return userDAO.select(new User());
    }

    public boolean checkAccountAndPassword(User user) {
        return false;
    }

    public UserQuery selectUserByAuth(Long authId, Long sysId, UserQuery query) {
        return null;
    }

    public List<User> selectListByRoleList(Long authId, Long sysId, UserQuery query) {
        log.info("UserServiceImpl.selectListByRoleList method");
        return null;
    }

    @Override
    public void updatePrepayById(Long id, double sum) {
        Map map = new HashMap();
        map.put("id", id);
        map.put("sum", sum);
        updatePrepayById(map);
    }

    @Override
    public void updateScoreById(Long id, double score) {
        Map map = new HashMap();
        map.put("id", id);
        map.put("score", score);
        userDAO.updateScoreById(map);
    }

    public void updatePrepayById(Map map) {
        userDAO.updatePrepayById(map);
    }

    @Override
    public boolean checkUserNameUnique(Long id, String username) {
        if (log.isDebugEnabled()) {
            log.debug("UserServiceImpl.checkUserNameUnique method");
        }
        if (StringUtils.isBlank(username)) {
            return true;
        }
        Long rawId = this.userDAO.getIdByUsername(username);
        if (id == null || id == 0) {
            return rawId == null || rawId == 0;
        } else {
            return rawId == null || rawId == 0 || rawId.compareTo(id) == 0;
        }
    }

    @Override
    public boolean checkEmailUnique(Long id, String email) {
        if (log.isDebugEnabled()) {
            log.debug("UserServiceImpl.checkUserNameUnique method");
        }
        if (StringUtils.isBlank(email)) {
            return true;
        }
        Long rawId = this.userDAO.getIdByEmail(email);
        if (id == null || id == 0) {
            return rawId == null || rawId == 0;
        } else {
            return rawId == null || rawId == 0 || rawId.compareTo(id) == 0;
        }
    }

    @Override
    public boolean checkMobileUnique(Long id, String mobile) {
        if (log.isDebugEnabled()) {
            log.debug("UserServiceImpl.checkUserNameUnique method");
        }
        if (StringUtils.isBlank(mobile)) {
            return true;
        }
        Long rawId = this.userDAO.getIdByMobile(mobile);
        if (id == null || id == 0) {
            return rawId == null || rawId == 0;
        } else {
            return rawId == null || rawId == 0 || rawId.compareTo(id) == 0;
        }
    }

    @Override
    public void update(User userInfo) {
        userDAO.update(userInfo);
    }

    @Override
    public void update4Edit(User userInfo) {
        userDAO.update4Edit(userInfo);
    }
    @Override
    public void updateEdit(User userInfo) {
    	userDAO.updateEdit(userInfo);
    }

    @Override
    public Result passwordEdit(UserAgent user, String pwdOld, String pwdNew, String pwdConfirm) {
        Result result = new Result();
        String userName = user.getUserName();
        if (user == null || userName == null) {
            result.setIsSuccess(false);
            result.setMessage("请先登录！");
            return result;
        }
        if (StringUtil.isBlank(pwdOld) || StringUtil.isBlank(pwdNew)) {
            result.setIsSuccess(false);
            result.setMessage("请正确输入原密码和新密码！");
            return result;
        }
        if (!pwdNew.equals(pwdConfirm)) {
            result.setIsSuccess(false);
            result.setMessage("确认密码与新密码不一致！");
            return result;
        }
        User userQuery = new User();
        userQuery.setUsername(userName);
        List<User> userList = userDAO.select(userQuery);
        if (userList == null || userList.size() <= 0) {
            result.setIsSuccess(false);
            result.setMessage("请重新登录后再进行操作！");
            return result;
        }
        int updateCount = userDAO.updatePassword(userName, MD5utils.MD5Encode(pwdNew),
            MD5utils.MD5Encode(pwdOld));
        if (updateCount <= 0) {
            result.setIsSuccess(false);
            result.setMessage("原密码输入不正确！");
            return result;
        }
        return result;
    }

    @Override
    public User getByUserName(String userName) {
        return userDAO.getByUserName(userName);
    }

    @Override
    public User getById(Long id) {
        return userDAO.getById(id);
    }
}
