package com.oo.zhihu.service;

import com.oo.zhihu.response.GetStartInfoResponse;

import java.util.Objects;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * 类名 OOZhihu
 * 作者 Keyu Chan
 * 创建日期 2016/8/11
 * 邮箱 chenky@corp.21cn.com
 * 说明 和风天气的API
 */
public interface HeWeatherService {

    public static final String HOST = "http://news-at.zhihu.com/api/4/";


    @GET("start-image/{width}*{height}")
    Call<GetStartInfoResponse> getStartInfo(@Path("width") int width, @Path("height") int height);
}