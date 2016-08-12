package com.oo.zhihu.entity;

/**
 * 类名 OOZhihu
 * 作者 Keyu Chan
 * 创建日期 2016/8/12
 * 邮箱 chenky@corp.21cn.com
 * 说明
 */
public class News {

    public String ctime;

    public String title;

    public String description;

    public String picUrl;

    public String url;

    @Override
    public String toString() {
        return "News{" +
                "ctime='" + ctime + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", picUrl='" + picUrl + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
