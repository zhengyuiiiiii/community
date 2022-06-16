package com.zhengyu.community;


import com.zhengyu.community.dao.DiscussPostMapper;
import com.zhengyu.community.dao.UserMapper;
import com.zhengyu.community.entity.DiscussPost;
import com.zhengyu.community.entity.User;


import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class MapperTests {

    @Autowired
    private UserMapper usermapper;

    @Autowired
    private DiscussPostMapper discussPostMapper;

    @Test
    public void testSelectUser() {
        User user = usermapper.selectById(101);
        System.out.println(user);

        User user1 = usermapper.selectByName("zhangfei");
        System.out.println(user1);
    }

    @Test
    public void testInsertUser() {
        User user = new User();
        user.setUsername("zhengyuiiiiii");
        user.setPassword("123456");
        user.setSalt("abc");
        user.setEmail("452885853@qq.com");
        user.setHeaderUrl("http://www.nowcoder.com/101.png");
        user.setCreateTime("2017-03-02 15:22:22");

        int rows = usermapper.insertUser(user);
        System.out.println(rows);
        System.out.println(user.getId());
    }

    @Test
    public void updateUser() {
        int rows = usermapper.updateStatus(150,1);
        System.out.println(rows);

        rows = usermapper.updatePassword(150,"1234567");
        System.out.println(rows);
    }

    @Test
    public void testSelectPosts() {
        List<DiscussPost> list = discussPostMapper.selectDiscussPosts(149, 0, 10);
        for(DiscussPost post : list) {
            System.out.println(post);
        }

        int rows = discussPostMapper.selectDiscussPostRows(149);
        System.out.println(rows);
    }
}
