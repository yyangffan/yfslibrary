package com.superc.yfslibrary.ui.httpdering.ecryp;

public class Constant {
    /*测试服务器地址:http://lifetest.qujie365.com/smpay/
     *正式服务器地址：    http://life.qujie365.com/smpay/
     *新元：http://192.168.1.122:8888/smpay/
     *袁帅：http://192.168.1.118:8011/smpay/
     **/
     /*图片地址-- 测试地址  http://lifetest.qujie365.com/jeesite/  正式地址http://61.240.30.232:8890/  */
    public static final String IMG_URL = "http://61.240.30.232:8890/";
    public static final boolean IS_JIAMI = true;/*扫码部分接口是否使用加密  true:使用  false:不使用*/
    /*-----------------------------------------------------------------------------------------------------*/
    public static final boolean OPEN_RIZHI = false;/*是否打印上传参数  true:打印  false：不打印*/
    public static final String BASE_URL = "http://life.qujie365.com/smpay/";
    /*图片地址--前面需要拼接这个*/
    /*----------------------------一期一期一期一期一期---------------------------------------------*/
//    注意：：：        服务器地址、图片地址、版本号、启动页
//    public static final boolean OPEN_RIZHI=false;/*是否打印上传参数  true:打印  false：不打印*/
//    public static final String BASE_URL = "http://life.qujie365.com/";
    /*----------------------------一期一期一期一期一期---------------------------------------------*/
    /*
     * 新元接口：v1/ 测试接口：smpay/v1/ */
    public static final String CSJ = "v1/";
    /*如下更新后分为两个接口方式访问  其中注意对图片的正式地址的修改   测试jeesite/  正式life/*/
    public static final String GYW = "life/";
    /*----------------------------一期一期一期一期一期---------------------------------------------*/
}
