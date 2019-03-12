package pers.xqy.demo.service.impl;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pers.xqy.demo.dao.UserDao;
import pers.xqy.demo.entity.User;
import pers.xqy.demo.service.UserService;

import java.util.Date;

/**
 * @program: demo
 * @description: 用户Service层Impl
 * @author: henryxzx
 * @create: 2019-02-13 15:06
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    /**
     * @Author henryxzx
     * @Description //TODO 列出所有用户
     * @Date 14:03 2019-02-16
     * @Param []
     * @return java.util.List<pers.xqy.demo.entity.User>
     **/
    @Transactional
    @Override
    public Page<User> listAllUser() {
        return userDao.listAllUser();
    }

    
    /**
     * @Author henryxzx
     * @Description //TODO 检查用户是否存在
     * @Date 14:04 2019-02-16
     * @Param [openId]
     * @return boolean
     **/
    @Transactional
    @Override
    public boolean checkUser(String openId) {
        if (userDao.checkUser(openId) == 1){
            return true;
        }else {
            return false;
        }
    }
    
    
    /**
     * @Author henryxzx
     * @Description //TODO 根据用户注册时间列出用户
     * @Date 14:04 2019-02-16
     * @Param []
     * @return java.util.List<pers.xqy.demo.entity.User>
     **/
    @Transactional
    @Override
    public Page<User> listAllUserByRegisterTime() {
        return userDao.listAllUserByRegisterTime();
    }

    
    /**
     * @Author henryxzx
     * @Description //TODO 根据用户最后登录时间列出用户
     * @Date 14:04 2019-02-16
     * @Param []
     * @return java.util.List<pers.xqy.demo.entity.User>
     **/
    @Transactional
    @Override
    public Page<User> listAllUserByLastLoginTime() {
        return userDao.listAllUserByLastLoginTime();
    }

    
    /**
     * @Author henryxzx
     * @Description //TODO 插入新的用户（注册功能）
     * @Date 14:04 2019-02-16
     * @Param [user]
     * @return boolean
     **/
    @Transactional
    @Override
    public boolean insertUser(User user) {
        if (user.getuOpenId() != null) {
            user.setuRegisterTime(new Date());
            user.setuLastLoginTime(new Date());
            try {
                int effectedNum = userDao.insertUser(user);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("插入用户信息失败");
                }
            } catch (Exception e) {
                throw new RuntimeException("插入用户信息失败" + e.getMessage());
            }
        }else{
            throw new RuntimeException("用户信息不能为空");
        }
    }

    
    /**
     * @Author henryxzx
     * @Description //TODO 更新用户信息（登录功能）
     * @Date 14:05 2019-02-16
     * @Param [user]
     * @return boolean
     **/
    @Transactional
    @Override
    public boolean updateUser(User user) {
        if (user.getuOpenId() != null) {
            user.setuLastLoginTime(new Date());
            try {
                int effectedNum = userDao.updateUser(user);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("更新用户信息失败");
                }
            } catch (Exception e) {
                throw new RuntimeException("更新用户信息失败" + e.getMessage());
            }
        }else{
            throw new RuntimeException("用户信息不能为空");
        }
    }

    
    /**
     * @Author henryxzx
     * @Description //TODO 根据用户uid获取用户信息
     * @Date 14:05 2019-02-16
     * @Param [uId]
     * @return pers.xqy.demo.entity.User
     **/
    @Transactional
    @Override
    public User findUserByUId(int uId) {
        return userDao.findUserByUId(uId);
    }

    
    /**
     * @Author henryxzx
     * @Description //TODO 根据用户openid获取用户信息
     * @Date 14:06 2019-02-16
     * @Param [openId]
     * @return pers.xqy.demo.entity.User
     **/
    @Transactional
    @Override
    public User findUserByOpenId(String openId) {
        return userDao.findUserByOpenId(openId);
    }
    
    
    /**
     * @Author henryxzx
     * @Description //TODO 根据用户openid返回用户uid
     * @Date 14:09 2019-02-16
     * @Param [openId]
     * @return java.lang.Integer
     **/
    @Transactional
    @Override
    public Integer findUIdByOpenId(String openId) {
        return userDao.findUIdByOpenId(openId);
    }
}
