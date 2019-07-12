package com.nicolas.douding.dao;

/**
 * @version V1.0
 *          注意：本内容仅限于搜狐新闻，禁止外泄以及用于其他的商业目
 * @Package com.nicolas.douding.dao
 * @Description: 用一句话描述该文件做什么)
 * @author: 搜狐 - 新闻客户端 - 云端业务 - shaoxinwei
 * @date: 2019-07-10 15:58
 */

import com.nicolas.douding.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.Reader;
import java.util.HashMap;


public class UserDaoTest {

    @Test
    public void shouldAnswerWithTrue()
    {

        try {
            //使用MyBatis提供的Resources类加载mybatis的配置文件
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            //构建sqlSession的工厂
            SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);

            SqlSession session= sessionFactory.openSession();
            UserMapper mapper=session.getMapper(UserMapper.class);
            User user= mapper.getUserByID(5l);
            System.out.println("##################"+user.toString());

            HashMap <String,Object> map = new HashMap<String,Object>();
            map.put("cid","1111");
            map.put("uuid","11");
            user= mapper.getUserByCidUUid(map);
            System.out.println("##################"+user.toString());

            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}