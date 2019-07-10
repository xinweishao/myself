package com.nicolas.douding.entity;

import com.alibaba.fastjson.JSON;
import com.oracle.webservices.internal.api.databinding.DatabindingMode;
import lombok.Data;

import java.io.Serializable;

/**
 * @version V1.0
 *          注意：本内容仅限于搜狐新闻，禁止外泄以及用于其他的商业目
 * @Package com.nicolas.douding.entity
 * @Description: 用一句话描述该文件做什么)
 * @author: 搜狐 - 新闻客户端 - 云端业务 - shaoxinwei
 * @date: 2019-07-10 16:04
 */
@Data
public class User implements Serializable {

    private static final long serialVersionUID = 8104961490512068314L;
    private Long id;
    private Long clientId;
    private Integer productId;
    private String version;
    private String token;
    private Integer status;
    private String channelId;
    private Integer activeLevel;

    @Override
    public String toString() {
        return JSON.toJSONStringWithDateFormat(this, "yyyy-MM-dd HH:mm:ss");
    }

}