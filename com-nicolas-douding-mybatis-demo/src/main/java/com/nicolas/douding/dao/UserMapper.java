package com.nicolas.douding.dao;

import com.nicolas.douding.entity.User;

/**
 * @version V1.0
 *          注意：本内容仅限于搜狐新闻，禁止外泄以及用于其他的商业目
 * @Package com.nicolas.douding.dao
 * @Description: 用一句话描述该文件做什么)
 * @author: 搜狐 - 新闻客户端 - 云端业务 - shaoxinwei
 * @date: 2019-07-10 16:17
 */
public interface UserMapper {

    User getUserByID(long id) throws Exception;
}
