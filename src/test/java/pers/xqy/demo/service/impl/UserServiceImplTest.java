package pers.xqy.demo.service.impl;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pers.xqy.demo.entity.User;
import pers.xqy.demo.service.UserService;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest

public class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @Test
    public void listAllUser() {
        assertEquals(1, userService.listAllUser().size());
    }

    @Test
    @Ignore
    public void checkUser() {
        assertEquals(true, userService.checkUser("tigoukai123"));
        assertEquals(false, userService.checkUser("tigoukai"));
    }

    @Test
    public void listAllUserByRegisterTime() {
        assertEquals("杨贵", userService.listAllUserByRegisterTime().get(0).getuNickName());
    }

    @Test
    public void listAllUserByLastLoginTime() {
        assertEquals("学霸", userService.listAllUserByLastLoginTime().get(0).getuNickName());
    }

    @Test
    @Ignore
    public void insertUser() {
        User user = new User();
        user.setuCountry("中国");
        user.setuAvatarUrl("https://blog.henryxzx.com");
        user.setuGender("男");
        user.setuNickName("学霸");
        user.setuOpenId("sbxueba");
        user.setuCanComment(1);
        assertEquals(true, userService.insertUser(user));
    }

    @Test
    @Ignore
    public void updateUser() {
        User user = new User();
        user.setuCountry("中国");
        user.setuAvatarUrl("https://blog.henryxzx.com/");
        user.setuGender("男");
        user.setuNickName("体🐶凯sb");
        user.setuOpenId("tigoukai123");
        user.setuCanComment(1);
        assertEquals(true, userService.updateUser(user));
    }

    @Test
    @Ignore
    public void findUserByUId() {
        User user = new User();
        user = userService.findUserByUId(1);
        assertEquals("tigoukai123", user.getuOpenId());
    }

    @Test
    @Ignore
    public void findUserByOpenId() {
        User user = new User();
        user = userService.findUserByOpenId("tigoukai123");
        assertEquals(1, user.getuId().intValue());
    }

    @Test
    @Ignore
    public void findUIdByOpenId() {
        assertEquals(1, userService.findUIdByOpenId("tigoukai123").intValue());
    }
}