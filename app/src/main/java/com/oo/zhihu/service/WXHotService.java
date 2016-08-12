package com.oo.zhihu.service;

import com.oo.zhihu.response.WXHotResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

/**
 * 类名 OOZhihu
 * 作者 Keyu Chan
 * 创建日期 2016/8/12
 * 邮箱 chenky@corp.21cn.com
 * 说明 微信热门精选的Service
 */
public interface WXHotService {

    public static final String HOST = "http://apis.baidu.com/txapi/weixin/";

    @Headers("apikey:4b87570dffbe4b4a003bc22eb9de5ad5")
    @GET("wxhot")
    Call<WXHotResponse> getWXHot(@Query("num") String num, @Query("rand") String rand,
                                 @Query("word") String word, @Query("page") String page, @Query("src") String src);

}
