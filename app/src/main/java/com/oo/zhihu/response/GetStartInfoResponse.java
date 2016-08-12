package com.oo.zhihu.response;

import java.io.Serializable;

/**
 * StartInfoResponse <br/>
 * Created by xiaqiulei on 2015-12-30.
 */
public class GetStartInfoResponse implements Serializable {

    public String text;

    public String img;

    @Override
    public String toString() {
        return "StartInfoResponse{" +
                "text='" + text + '\'' +
                ", img='" + img + '\'' +
                "} " + super.toString();
    }
}