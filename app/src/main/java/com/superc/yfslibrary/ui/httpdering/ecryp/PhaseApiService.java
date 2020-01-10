package com.superc.yfslibrary.ui.httpdering.ecryp;


import com.alibaba.fastjson.JSONObject;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface PhaseApiService {
    /*登录*/
    @POST("v3/app/shop/login")
    Observable<JSONObject> login(@Body RequestBody map);
    /*登出*/
    @POST("v3/app/shop/logout")
    Observable<JSONObject> logout(@Body RequestBody map);
     /*线下扫码收款*/
    @POST("v3/app/shop/offlineScanningCodeCollection")
    Observable<JSONObject> offlineScanningCodeCollection(@Body RequestBody map);
    /*线上平台收款*/
    @POST("v3/app/shop/onlinePlatformCollection")
    Observable<JSONObject> onlinePlatformCollection(@Body RequestBody map);
    /*线下扫码账本*/
    @POST("v3/app/shop/myBooksQuery")
    Observable<JSONObject> myBooksQuery(@Body RequestBody map);
    /*线上平台账本*/
    @POST("v3/app/shop/onlinePlatformBook")
    Observable<JSONObject> onlinePlatformBook(@Body RequestBody map);
    /*优惠券管理*/
    @POST("v3/app/shop/couponManagement")
    Observable<JSONObject> couponManagement(@Body RequestBody map);
    /*是否有待确认，待审核，待上线，进行中的活动*/
    @POST("v3/app/shop/isPossibleSettings")
    Observable<JSONObject> isPossibleSettings(@Body RequestBody map);
    /*支付营销券列表*/
    @POST("v3/app/shop/marketingDetails")
    Observable<JSONObject> marketingDetails(@Body RequestBody map);
    /*停止发放*/
    @POST("v3/app/shop/underwayActivity")
    Observable<JSONObject> underwayActivity(@Body RequestBody map);
    /*商家确认*/
    @POST("v3/app/shop/merchantConfirmation")
    Observable<JSONObject> merchantConfirmation(@Body RequestBody map);
    /*商家驳回*/
    @POST("v3/app/shop/merchantRejected")
    Observable<JSONObject> merchantRejected(@Body RequestBody map);
    /*营销券详情以及驳回原因反显*/
    @POST("v3/app/shop/currentActivity")
    Observable<JSONObject> currentActivity(@Body RequestBody map);
    /*创建支付营销券*/
    @POST("v3/app/shop/campaignSettings")
    Observable<JSONObject> campaignSettings(@Body RequestBody map);
    /*历史使用记录*/
    @POST("v3/app/shop/historicalUsageRecord")
    Observable<JSONObject> historicalUsageRecord(@Body RequestBody map);
    /*往期全部券*/
    @POST("v3/app/shop/shopVoucher")
    Observable<JSONObject> shopVoucher(@Body RequestBody map);
    /*优惠券领取使用明细*/
    @POST("v3/app/shop/voucherCollectionDetails")
    Observable<JSONObject> voucherCollectionDetails(@Body RequestBody map);
    /*营销券领取使用明细*/
    @POST("v3/app/shop/marketingVoucherCollectionDetails")
    Observable<JSONObject> marketingVoucherCollectionDetails(@Body RequestBody map);
    /*店铺信息*/
    @POST("v3/app/shop/shopMessage")
    Observable<JSONObject> shopMessage(@Body RequestBody map);
    /*通知消息*/
    @POST("v3/app/shop/notificationMessage")
    Observable<JSONObject> notificationMessage(@Body RequestBody map);
    /*收款账户*/
    @POST("v3/app/shop/accountsReceivable")
    Observable<JSONObject> accountsReceivable(@Body RequestBody map);
    /*渠道经理*/
    @POST("v3/app/shop/channelManager")
    Observable<JSONObject> channelManager(@Body RequestBody map);
    /*绑定收款码*/
    @POST("v3/app/shop/bindingReceiptCode")
    Observable<JSONObject> bindingReceiptCode(@Body RequestBody map);
    /*收款码明细*/
    @POST("v3/app/shop/collectionCodeDetails")
    Observable<JSONObject> collectionCodeDetails(@Body RequestBody map);
    /*发送验证码（银行预留手机）*/
    @POST("v3/app/shop/obtainSMSVerificationCode")
    Observable<JSONObject> obtainSMSVerificationCode(@Body RequestBody map);
    /*验证验证码*/
    @POST("v3/app/shop/verificationCodeCheck")
    Observable<JSONObject> verificationCodeCheck(@Body RequestBody map);
    /*修改密码*/
    @POST("v3/app/shop/updatePassword")
    Observable<JSONObject> updatePassword(@Body RequestBody map);
    /*删除消息*/
    @POST("v3/app/shop/viewMessage")
    Observable<JSONObject> viewMessage(@Body RequestBody map);
    /*消息的红点*/
    @POST("v3/app/shop/isthereCurrentlyUnreadMessage")
    Observable<JSONObject> isthereCurrentlyUnreadMessage(@Body RequestBody map);
    /*商铺信息*/
    @POST("v3/app/shop/getTheLatestStoreInformation")
    Observable<JSONObject> getTheLatestStoreInformation(@Body RequestBody map);
    /*线下账单明细*/
    @POST("v3/app/shop/billingDetails")
    Observable<JSONObject> billingDetails(@Body RequestBody map);
    /*线上账单明细*/
    @POST("v3/app/shop/onlineBillingDetails")
    Observable<JSONObject> onlineBillingDetails(@Body RequestBody map);
    /*原验券*/
    @POST("v3/bcoupon/checkTicket")
    Observable<JSONObject> checkTicket(@Body RequestBody map);
    /*原数量*/
    @POST("v3/bcoupon/getTicketNums")
    Observable<JSONObject> getTicketNums(@Body RequestBody map);
    /*现验券*/
    @POST("v3/bcoupon/checkGiftCode")
    Observable<JSONObject> checkGiftCode(@Body RequestBody map);
    /*营销券取消红点*/
    @POST("v3/app/shop/cancelRed")
    Observable<JSONObject> cancelRed(@Body RequestBody map);
    /*帐号获取验证码*/
    @POST("v3/app/shop/forgetPassword")
    Observable<JSONObject> forgetPassword(@Body RequestBody map);
    /*返利金取消红点*/
    @POST("v3/bcoupon/getByClient")
    Observable<JSONObject> getByClient(@Body RequestBody map);
    /**/
    @POST("v3/app/shop/cancellationOfRebate")
    Observable<JSONObject> cancellationOfRebate(@Body RequestBody map);
    /*音箱码是否绑定*/
    @POST("v3/app/shop/isBindingSound")
    Observable<JSONObject> isBindingSound(@Body RequestBody map);
    /*绑定音箱码*/
    @POST("v3/app/shop/bindingSound")
    Observable<JSONObject> bindingSound(@Body RequestBody map);

    //    ------------------------------------------三期 ------------------------------------------
    /*返利金首页金额*/
    @POST("v3/shop/homeMoney")
    Observable<JSONObject> homeMoney(@Body RequestBody map);
    /*返利金首页列表*/
    @POST("v3/shop/homeList")
    Observable<JSONObject> homeList(@Body RequestBody map);
    /*返利奖励详情*/
    @POST("v3/shop/rebateRewardDetails")
    Observable<JSONObject> rebateRewardDetails(@Body RequestBody map);
    /*提现详情页*/
    @POST("v3/shop/detailsOfPresentation")
    Observable<JSONObject> detailsOfPresentation(@Body RequestBody map);
    /*发送验证码*/
    @POST("v3/shop/obtainSMSVerificationCode")
    Observable<JSONObject> thirdSMSVerificationCode(@Body RequestBody map);
    /*提现操作*/
    @POST("v3/shop/cashWithdrawal")
    Observable<JSONObject> cashWithdrawal(@Body RequestBody map);
    /*提现成功页*/
    @POST("v3/shop/cashWithdrawalSuccess")
    Observable<JSONObject> cashWithdrawalSuccess(@Body RequestBody map);
    /*确认提现按钮判断*/
    @POST("v3/shop/startSendCode")
    Observable<JSONObject> startSendCode(@Body RequestBody map);

    @POST(Constant.CSJ+"login/getPublic")
    Observable<JSONObject> getPublic(@Body RequestBody map);
    @POST(Constant.CSJ+"login/getPrivateKey")
    Observable<JSONObject> getPrivateKey(@Body RequestBody map);
}
