package com.oo.zhihu.response;

import com.oo.zhihu.entity.News;

import java.io.Serializable;
import java.util.List;

/**
 * 类名 OOZhihu
 * 作者 Keyu Chan
 * 创建日期 2016/8/12
 * 邮箱 chenky@corp.21cn.com
 * 说明
 */
public class WXHotResponse implements Serializable{

    public int code;

    public String msg;

    public List<News> newslist;

    @Override
    public String toString() {
        return "WXHotResponse{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", newslist=" + newslist +
                '}';
    }
}
