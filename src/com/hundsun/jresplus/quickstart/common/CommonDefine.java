package com.hundsun.jresplus.quickstart.common;

import javax.servlet.ServletContext;

import org.springframework.web.context.WebApplicationContext;

import com.alipay.config.AlipayConfig;

public class CommonDefine {

    /*
     * 主要存在一些固定文件目录，注意路径采用相对目录，且最后不加“/”，方便进行组装
     */
    public static WebApplicationContext webAppCon;

    public static ServletContext        servletContext;

    public static String                rootPath                                 = "";

    // 上传文件的默认最大字节数
    public static final Integer         upload_default_max_size                  = 100000;

    // 系统权根列表
    public static ResourceMapping[]     mappings;

    //用户类型
    public static final Integer         USERTYPE_PERSONAL                        = 1;                                                                                                                                                                                                                             //个人客户
    public static final Integer         USERTYPE_COMPANY                         = 2;                                                                                                                                                                                                                             //企业客户
    public static final Integer         USERTYPE_BACKEND                         = 0;                                                                                                                                                                                                                             //后台用户

    //外部用户来源
    public static final Integer         USER_CREATOR_ID_PIAOYOU                  = 1;                                                                                                                                                                                                                             //票友用户

    //证件类型
    public static final String          USER_CREDENTIALTYPE_IDCARD               = "IDCARD";                                                                                                                                                                                                                      //身份证
    public static final String          USER_CREDENTIALTYPE_SBCARD               = "SBCARD";                                                                                                                                                                                                                      //社保卡
    public static final String          USER_CREDENTIALTYPE_DRIVERCARD           = "DRIVERCARD";                                                                                                                                                                                                                  //驾驶证
    public static final String          USER_CREDENTIALTYPE_SLDCARD              = "SLDCARD";                                                                                                                                                                                                                     //军人证
    public static final String          USER_CREDENTIALTYPE_STDCARD              = "STDCARD";                                                                                                                                                                                                                     //学生证
    public static final String          USER_CREDENTIALTYPE_OTHERCARD            = "OTHERCARD";                                                                                                                                                                                                                   //其他证件

    // SESSION会话
    public static final String          ACEGI_SES_USERNAME                       = "ACEGI_SECURITY_LAST_USERNAME";
    public static final String          ACEGI_SES_LOGIN_PASSWORD                 = "ACEGI_SECURITY_LAST_LOGIN_PASSWORD";
    public static final String          SES_USERNAME                             = "pUserName";                                                                                                                                                                                                                   // 登录名
    public static final String          SES_REALNAME                             = "pRealName";                                                                                                                                                                                                                   // 真实姓名
    public static final String          SES_USERSCORE                            = "pUserScore";                                                                                                                                                                                                                  // 积分
    public static final String          SES_USERPREPAY                           = "pUserPrepay";                                                                                                                                                                                                                 // 预存余额
    public static final String          SES_USERTYPE                             = "pUserType";
    public static final String          SES_USERSTATUS                           = "pUserStatus";
    public static final String          SES_RECENT_ORDERITEM_LIST                = "pRecentOrderItemList";                                                                                                                                                                                                        // 近期订单商品
    public static final String          SES_BUILDING                             = "pBuilding";                                                                                                                                                                                                                   // 所属楼宇

    //request请求固定参数
    public static final String          REQ_BUILDING                             = "b";                                                                                                                                                                                                                           // 所属楼宇

    // Cookie标识
    public static final String          COOKIE_OAMYBEST_DOMAIN                   = "oamybest.com";
    public static final String          COOKIE_OAMYBEST_USERNAME                 = "oamybest_user";
    public static final String          COOKIE_OAMYBEST_LOGOUT                   = "oamybest_logout";

    // 系统权限角色定义
    public static final int             ROLE_USER                                = 1;                                                                                                                                                                                                                             // 用户
    public static final int             ROLE_ADMIN                               = 2;                                                                                                                                                                                                                             // 超级管理员
    public static final int             ROLE_B2CADMIN                            = 3;                                                                                                                                                                                                                             // B2C管理员
    public static final int             ROLE_CMSADMIN                            = 4;                                                                                                                                                                                                                             // CMS管理员

    // 用户状态
    public static final Integer         USER_STATUS_FROOZE                       = 0;                                                                                                                                                                                                                             // 冻结
    public static final Integer         USER_STATUS_NORMAL                       = 1;                                                                                                                                                                                                                             // 正常

    public static final int             ISOPEN_NO                                = 0;                                                                                                                                                                                                                             // 禁用
    public static final int             ISOPEN_YES                               = 1;                                                                                                                                                                                                                             // 可用

    //订单状态: 个位表示订单的配送等状态,十位表示支付状态; 
    //订单数位含义: 1代表未执行, 2代表执行中, 3代表执行结束, 4代表执行失败, 5代表缺货, 0代表取消
    public static final int             ORDERINFO_STATUS_NEW                     = 11;                                                                                                                                                                                                                            //待付款新订单,未付款未配送
    public static final int             ORDERINFO_STATUS_NOPAY_SENDING           = 12;                                                                                                                                                                                                                            //未付款配送中,适用于货到付款的订单
    public static final int             ORDERINFO_STATUS_NOPAY_SENDED            = 13;                                                                                                                                                                                                                            //未付款已交货,实际交易中应当不会出现
    public static final int             ORDERINFO_STATUS_PAYING_NOSEND           = 21;                                                                                                                                                                                                                            //付款中未配送（网上支付时，用户页面转到支付网关前，应先将订单状态置为21，代表用户支付已开始）
    public static final int             ORDERINFO_STATUS_PAYING_SENDING          = 22;                                                                                                                                                                                                                            //付款中配送中，实际交易中应当不会出现
    public static final int             ORDERINFO_STATUS_PAYING_SENDED           = 23;                                                                                                                                                                                                                            //付款中已交货，实际交易中应当不会出现
    public static final int             ORDERINFO_STATUS_PAYED_NOSEND            = 31;                                                                                                                                                                                                                            //已付款未配送，实际交易中应当不会出现（付款成功会立即进入配送中状态，不会停留在此状态）
    public static final int             ORDERINFO_STATUS_PAYED_SENDING           = 32;                                                                                                                                                                                                                            //已付款配送中，网银支付成功后为此状态
    public static final int             ORDERINFO_STATUS_CLOSED                  = 33;                                                                                                                                                                                                                            //订单已完成，即已付款已配送(包括月结未支付订单)
    public static final int             ORDERINFO_STATUS_CANCLE                  = 0;                                                                                                                                                                                                                             //已取消状态，过期订单或后台取消订单
    public static final int             ORDERINFO_STATUS_ALLOUT                  = 50;                                                                                                                                                                                                                            //完全缺货订单，订单中所有商品缺货，通常为拆分后的缺货订单
    public static final int             ORDERINFO_STATUS_PARTOUT                 = 51;                                                                                                                                                                                                                            //部分缺货订单，订单中部分商品缺货，通常为用户选择不做拆分的缺货订单
    public static final int             ORDERINFO_STATUS_RECEIVED                = 34;
    
    //订单支付方式
                                                                                                                                                                                                                            //货到付款
    public static final int             ORDERPAYTYPE_BANK                        = 2;                                                                                                                                                                                                                             //银行汇款
    public static final int             ORDERPAYTYPE_PAYONLINE                   = 3;                                                                                                                                                                                                                             //网上支付
    public static final int             ORDERPAYTYPE_PREPAY                      = 1;                                                                                                                                                                                                                             //预存款支付
    public static final int             ORDERPAYTYPE_MONTHPAY                    = 5;
    public static final int             ORDERPAYTYPE_ALIPAY                      = 6;
    public static final int             ORDERPAYTYPE_SCORE                       = 7;
    public static final int             ORDERPAYTYPE_ALIPAYWAP                   = 16;
    //月结

    //预存款交易类别
    public static final String          PREPAYLOG_TYPE_PREPAY                    = "prepay";                                                                                                                                                                                                                      //充值
    public static final String          PREPAYLOG_TYPE_ANTIPAY                   = "antipay";                                                                                                                                                                                                                     //扣款
    public static final String          PREPAYLOG_TYPE_PAYMENT                   = "payment";                                                                                                                                                                                                                     //订单支付

    //全局变量，用作BILL支付时的同步进程控制
    public static String                orderId                                  = "";

    //订单拆分标识
    public static final int             ORDERINFO_SPLITORDER_YES                 = 1;                                                                                                                                                                                                                             //缺货订单，用户选择拆分
    public static final int             ORDERINFO_SPLITORDER_NO                  = 0;                                                                                                                                                                                                                             //缺货订单，用户选择不拆分
    public static final int             ORDERINFO_SPLITORDER_NONE                = -1;                                                                                                                                                                                                                            //无缺货订单

    //订单明细项是否缺货的标识定义
    public static final int             ORDERITEM_ITEMNO_HAVE                    = 1;                                                                                                                                                                                                                             //此项商品有现货
    public static final int             ORDERITEM_ITEMNO_NONE                    = 0;                                                                                                                                                                                                                             //此项商品缺货

    //消息发送日志类型定义
    public final static int             MSGSENDLOG_TYPE_EMAIL                    = 0;                                                                                                                                                                                                                             //消息发送类别:邮件消息
    public final static int             MSGSENDLOG_TYPE_MSN                      = 1;                                                                                                                                                                                                                             //消息发送类别:MSN消息
    public final static int             MSGSENDLOG_TYPE_MOBILE                   = 2;                                                                                                                                                                                                                             //消息发送类别:手机短信

    //消息发送日志状态定义
    public final static int             MSGSENDLOG_STATUS_UNSEND                 = 0;                                                                                                                                                                                                                             //消息发送状态:未发送
    public final static int             MSGSENDLOG_STATUS_SENDED                 = 1;                                                                                                                                                                                                                             //消息发送状态:已发送
    public final static int             MSGSENDLOG_STATUS_FAILED                 = -1;                                                                                                                                                                                                                            //消息发送状态:发送失败

    //邮件发送属性名称定义
    public final static String          SMTPHOST                                 = "SMTPHOST";
    public final static String          SMTPPORT                                 = "SMTPPORT";
    public final static String          SMTPAUTH                                 = "SMTPAUTH";
    public final static String          MAILACCOUNT                              = "MAILACCOUNT";
    public final static String          MAILACCPSWD                              = "MAILACCPSWD";
    public final static String          MIMETYPE                                 = "MIMETYPE";
    public final static String          CHARSET                                  = "CHARSET";
    public final static String          MAILFROM                                 = "MAILFROM";

    //新用户注册成功后的欢迎邮件定义
    public final static String          MAIL_WELCOME_TITLE                       = "MAIL_WELCOME_TITLE";
    public final static String          MAIL_WELCOME_CONTENT                     = "MAIL_WELCOME_CONTENT";
    public final static String          MAIL_WELCOME_TITLE_DEFAULT_VAL           = "欢迎您注册物业快车网！";
    public final static String          MAIL_WELCOME_CONTENT_DEFAULT_VAL         = "亲爱的会员<USERNAME>：<br>&nbsp;&nbsp;&nbsp;&nbsp;恭喜您，您已成功注册物业快车网。<br/>&nbsp;&nbsp;&nbsp;&nbsp;您在物业快车网的登录帐号：<USERNAME>&nbsp;&nbsp;&nbsp;&nbsp;登录密码：<PASSWD><Br>欢迎您加入物业快车网，我们将竭诚为您服务！<br><br>物业快车网全体工作人员";

    //找回密码邮件设置
    public final static String          MAIL_FETCHPWD_TITLE                      = "MAIL_FETCHPWD_TITLE";
    public final static String          MAIL_FETCHPWD_CONTENT                    = "MAIL_FETCHPWD_CONTENT";
    public final static String          MAIL_FETCHPWD_TITLE_DEFAULT_VAL          = "您在物业快车网的密码！";
    public final static String          MAIL_FETCHPWD_CONTENT_DEFAULT_VAL        = "亲爱的会员<USERNAME>：<br>&nbsp;&nbsp;&nbsp;&nbsp;恭喜您，您已成功找回您在物业快车网的以下帐户密码。<br/>&nbsp;&nbsp;&nbsp;&nbsp;您在上海光大会展物业快车网的登录帐号：<USERNAME>&nbsp;&nbsp;&nbsp;&nbsp;登录密码：<PASSWD><Br>欢迎您继续使用上海光大会展物业快车，我们将竭诚为您服务！<br><br>上海光大会展物业快车全体工作人员";

    //对工作人员发送任务提醒邮件的收件人帐户
    public final static String          MAIL_NOTICE_RECIPIENT                    = "MAIL_NOTICE_RECIPIENT";

    //积分规则属性定义
    public final static String          SCORE_POINTRATE                          = "SCORE_POINTRATE";                                                                                                                                                                                                             //积分比率，每订购一元商品对应的积分值，如此值为1则每1元商品积1分

    //services返回码定义
    public final static String          SERVICES_CODE_SUCCESS                    = "200";                                                                                                                                                                                                                         //可以注册或操作成功
    public final static String          SERVICES_CODE_EXISTED                    = "421";                                                                                                                                                                                                                         //用户已存在
    public final static String          SERVICES_CODE_PARAMSERROR                = "401";                                                                                                                                                                                                                         //语法错误或参数不合法
    public final static String          SERVICES_CODE_IPFORBIDDEN                = "410";                                                                                                                                                                                                                         //IP禁止，IP非法
    public final static String          SERVICES_CODE_USERNOTEXIST               = "400";                                                                                                                                                                                                                         //用户不存在
    public final static String          SERVICES_CODE_USERNAMEERROR              = "422";                                                                                                                                                                                                                         //用户名错误（含非法字符）
    public final static String          SERVICES_CODE_SERVERERROR                = "500";                                                                                                                                                                                                                         //服务器端错误
    public final static String          SERVICES_CODE_SERVERMAINTAIN             = "503";                                                                                                                                                                                                                         //服务器正在维护

    //ARTICLE预定栏位编码定义
    public static final String          ARTICLE_CODE_BRANDEXPRESS                = "BRAND_EXPRESS";                                                                                                                                                                                                               //品牌直通车
    public static final String          ARTICLE_CODE_HOTKEYWORDS                 = "HOT_KEYWORDS";                                                                                                                                                                                                                //热门关键字
    public static final String          ARTICLE_CODE_HPSCROLLPLAY                = "HP_SCROLLPLAY";                                                                                                                                                                                                               //首页轮播区
    public static final String          ARTICLE_CODE_HPGOODSEXPRESS              = "HP_GOODSEXPRESS";                                                                                                                                                                                                             //首页右侧商品直荐区
    public static final String          ARTICLE_CODE_HPWEEKLYHOT                 = "HP_WEEKLYHOT";                                                                                                                                                                                                                //首页本周热销
    public static final String          ARTICLE_CODE_NEWESTEXPRESS               = "HP_NEWESTEXPRESS";                                                                                                                                                                                                            //首页右侧最新专递区
    public static final String          ARTICLE_CODE_HOTGOODSTOP10               = "HOTGOODSTOP10";                                                                                                                                                                                                               //热销商品排行榜
    public static final String          ARTICLE_CODE_NEWGOODSREC                 = "NEWGOODSREC";                                                                                                                                                                                                                 //新品介绍
    public static final String          ARTICLE_CODE_HPBANNER                    = "HP_BANNER";                                                                                                                                                                                                                   //首页中部BANNER区
    public static final String          ARTICLE_CODE_HPNEWSINFOREC               = "HP_NEWSINFOREC";                                                                                                                                                                                                              //首页资讯推荐区
    public static final String          ARTICLE_CODE_HPNEWSINFOREC2              = "HP_NEWSINFOREC2";                                                                                                                                                                                                             //首页资讯推荐区2
    public static final String          ARTICLE_CODE_HP_QQ                       = "HP_QQ";
    public static final String          ARTICLE_CODE_KF_QQ                       = "KF_QQ";                                                                                                                                                                                                                       //首页客服QQ号                                                                                                                                                                                                                   //首页QQ号
    public static final String          ARTICLE_CODE_REGTERM                     = "REG_TERM";                                                                                                                                                                                                                    //注册协议

    public static final String          ARTICLE_CODE_CUSTOMSERVICE               = "CUSTOMSERVICE";                                                                                                                                                                                                               //个性化服务，特色服务
    public static final String          ARTICLE_CODE_FAVORABLEAREA               = "FAVORABLEAREA";                                                                                                                                                                                                               //优惠专区

    // 导出EXCEL文件的结果码定义   
    public static final int             EXPORT_EXCEL_SUCCESS                     = 1;                                                                                                                                                                                                                             // 成功导出EXCEL文件  
    public static final int             EXPORT_EXCEL_NO_DATA                     = -1;                                                                                                                                                                                                                            // 没有数据   
    public static final int             EXPORT_EXCEL_SYSTEM_EXCEPTION            = -2;                                                                                                                                                                                                                            // 系统异常   
    public static final int             EXPORT_EXCEL_OTHER_EXCEPTION             = -3;                                                                                                                                                                                                                            // 其他异常   
    public static final int             EXPORT_EXCEL_NOFILE_EXCEPTION            = -4;                                                                                                                                                                                                                            // 文件路径和文件名无效 
    public static final int             EXPORT_EXCEL_ARRAYNOTHESAME_EXCEPTION    = -5;                                                                                                                                                                                                                            // 集合对象中的数组存放的数据个数不一致   
    public static final int             EXPORT_EXCEL_NULL_OUTPUTSTREAM_EXCEPTION = -6;                                                                                                                                                                                                                            // 传入的OUTPUTSTREAM为空 
    public static final int             EXPORT_EXCEL_COLSNUM_NOTRIGHT            = 2;                                                                                                                                                                                                                             // 宽度设置参数有误，按默认值设定宽度   

    
    public static final String          PAY_TYPE_YUNKUNCUN                       = "8";
    public static final int             PAY_TYPE_ALIPAY                          = 6;
    public static final int             PAY_TYPE_PREPAY                          = 1;
    public static final int             PAY_TYPE_AFTERPAY                        = 4;
    public static final int             PAY_TYPE_SCORE                           = 5;
    
    public static final int             OUTPAY_STATUS_INIT                       = 1;
    public static final int             OUTPAY_STATUS_SUCCESS                    = 0;
    public static final int             OUTPAY_STATUS_FAILED                     = 2;
    
    public static final String          ALIPAY_NOTIFY_URL = AlipayConfig.notify_url;
    public static final String          ALIPAY_RETURN_URL = AlipayConfig.return_url;
    
    public static final String          ALIPAY_WAP_NOTIFY_URL = "http://trade.wuyeok.com/settle/callback/alipayWapNotify.htm";
    public static final String          ALIPAY_WAP_CALLBACK_URL = "http://trade.wuyeok.com/settle/callback/alipayWapReturn.htm";
    
    
    
    /*
     * 新闻分类
     */
    public static final String          DOWNLOAD_NEWS="1";       
    public static final String          ZONGHE_NEWS="2";  
    public static final String          WUYEOK_NEWS="3";  
    public static final String          GONGGAO_NEWS="4";  
    public static final String          HOUSE_NEWS="5";  
    public static final String          QUICK_NEWS="6";  
    
    
    public static final Integer     IS_DELETE_NO=0;
    public static final Integer     IS_DELETE_YES=1;
    
    
    public static final String      STATUS_INIT="0";
    public static final String      STATUS_OPEN="1";
    public static final String     STATUS_DELETE="2";
    
    public static final String     ACTIVITY_NORMAL="0";
    public static final String     ACTIVITY_CANCLE="1";
    public static final String     ACTIVITY_OVER="2";
    
    
    public static final Integer     STATUS_NOPAY=1;
    public static final Integer     STATUS_PAYDONE=0;
    public static final Integer     STATUS_PAYCANCLE=2;
    
     
    public static final Integer     LOG_PAY_STATUS_TRUE=0;
    public static final Integer     LOG_PAY_STATUS_FALSE=1;	
   
    
     
    /**
     * 用于初始化数据;
     * 
     * @param rootPath
     */
    public static void setRootPath(String rootPath) {
        if (rootPath.endsWith("\\") || rootPath.endsWith("/")) {
            rootPath = rootPath.substring(0, rootPath.length() - 1);
        }
        // 使用统一路径编码
        rootPath = rootPath.replace("\\", "/");
        CommonDefine.rootPath = rootPath;
    }
}
