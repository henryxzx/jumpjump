package pers.xqy.demo.dao;

import com.github.pagehelper.Page;
import pers.xqy.demo.entity.User;

public interface UserDao {
    /**
     * @Author henryxzx
     * @Description //TODO 查找所有用户 获取用户所有信息
     * @Date 14:04 2019-01-18
     * @Param []
     * @return java.util.List<pers.xqy.demo.entity.User>
     **/

    public Page<User> listAllUser();


    /**
     * @Author henryxzx
     * @Description //TODO 查找用户是否存在
     * @Date 14:32 2019-01-18
     * @Param [openId]
     * @return java.lang.Integer
     **/

    public Integer checkUser(String openId);


    /**
     * @Author henryxzx
     * @Description //TODO 列出所有用户根据注册时间
     * @Date 15:22 2019-01-19
     * @Param []
     * @return java.util.List<pers.xqy.demo.entity.User>
     **/

    public Page<User> listAllUserByRegisterTime();


    /**
     * @Author henryxzx
     * @Description //TODO 列出所用用户根据最后登陆时间
     * @Date 15:28 2019-01-19
     * @Param []
     * @return java.util.List<pers.xqy.demo.entity.User>
     **/

    public Page<User> listAllUserByLastLoginTime();


    /**
     * @Author henryxzx
     * @Description //TODO 注册功能 添加用户信息进入数据库
     * @Date 14:07 2019-01-18
     * @Param [user]
     * @return java.lang.Integer
     **/

    public Integer insertUser(User user);

    /**
     * @Author henryxzx
     * @Description //TODO 更新用户信息
     * @Date 13:18 2019-01-19
     * @Param [user]
     * @return java.lang.Integer
     **/

    public Integer updateUser(User user);

    /**
     * @Author henryxzx
     * @Description //TODO 用Id查找用户 返回用户信息
     * @Date 14:42 2019-01-19
     * @Param [userId]
     * @return pers.xqy.demo.entity.User
     **/
    public User findUserByUId(int uId);

    /**
     * @Author henryxzx
     * @Description //TODO 用OpenId查找用户 返回用户信息
     * @Date 14:08 2019-01-18
     * @Param [openId]
     * @return pers.xqy.demo.entity.User
     **/

    public User findUserByOpenId(String openId);

    /**
     * @Author henryxzx
     * @Description //TODO 用OpenId查找用户 返回用户Id
     * @Date 13:57 2019-01-19
     * @Param [openId]
     * @return int
     **/
    public int findUIdByOpenId(String openId);


}
