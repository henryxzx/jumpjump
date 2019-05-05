package pers.xqy.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pers.xqy.demo.entity.NewsLogs;
import pers.xqy.demo.entity.User;
import pers.xqy.demo.service.NewsLogsService;
import pers.xqy.demo.service.UserService;
import pers.xqy.demo.utils.HttpRequestUtil;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;



/**
 * @program: demo
 * @description: 用户Controller层
 * @author: henryxzx
 * @create: 2019-02-12 13:10
 **/
@RestController
@RequestMapping("/User")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    public NewsLogsService newsLogsService;
    /**
     * @Author henryxzx
     * @Description //TODO 微信小程序登录注册功能。
     * @Date 14:27 2019-02-24
     * @Param [code, userInfo]
     * @return java.util.Map<java.lang.String,java.lang.Object>
     **/
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Map<String, Object> getCode(@RequestParam(value = "code") String code, @RequestParam(value = "userInfo") String userInfo){
//        System.out.println(code);
//        System.out.println(userInfo);
        Map<String, Object> modelMap = new HashMap<String, Object>();

        String APPID = "wxe441ec2425d06167";
        String js_code = code;
        String secret = "ff0df6f9400b322d357307c3079b1de9";
        String url = "https://api.weixin.qq.com/sns/jscode2session?" + "appid="+ APPID + "&secret=" + secret + "&js_code=" + js_code + "&grant_type=authorization_code";
        //获取到返回的openid和sessionId
        String result = HttpRequestUtil.get(url);
        //处理返回的result 转换为JsonObject
        JSONObject jsonResult= JSONObject.parseObject(result);
        //处理返回的userInfo 转换为JsonObject
        JSONObject jsonUserInfo = JSONObject.parseObject(userInfo);
//        System.out.println("result" + result);
//        System.out.println("code:" + code);
        System.out.println("userInfo:" + userInfo);
//        System.out.println(jsonResult.getString("openid"));
//        System.out.println(jsonUserInfo.toString());
        //获取OpenId
        String openId = jsonResult.getString("openid");
        if (openId == null){
            modelMap.put("success", null);
            modelMap.put("errMsg", "获取openid错误");
            return modelMap;
        }
        if(userService.checkUser(openId) == true){
            User user = userService.findUserByOpenId(openId);
            user.setuNickName(jsonUserInfo.getString("nickName"));
            if (jsonUserInfo.getIntValue("gender") == 1){
                user.setuGender("男");
            }else if (jsonUserInfo.getIntValue("gender") == 0){
                user.setuGender("女");
            }else {
                user.setuGender("外星人");
            }
            user.setuAvatarUrl(jsonUserInfo.getString("avatarUrl"));
            user.setuCountry(jsonUserInfo.getString("country"));
            user.setuLastLoginTime(new Date());
            if(userService.updateUser(user)) {
                modelMap.put("success", "登陆成功！");
                modelMap.put("openid", openId);
                modelMap.put("uId",user.getuId());
            }else {
                modelMap.put("success", null);
                modelMap.put("errMsg", "登录失败！");
            }
        }else{
            User user = new User();
            user.setuOpenId(openId);
            user.setuNickName(jsonUserInfo.getString("nickName"));
            if (jsonUserInfo.getIntValue("gender") == 1){
                user.setuGender("男");
            }else if (jsonUserInfo.getIntValue("gender") == 0){
                user.setuGender("女");
            }else {
                user.setuGender("外星人");
            }
            user.setuAvatarUrl(jsonUserInfo.getString("avatarUrl"));
            user.setuCountry(jsonUserInfo.getString("country"));
            user.setuRegisterTime(new Date());
            user.setuLastLoginTime(new Date());
            user.setuCanComment(1);
            if(userService.insertUser(user) == true){
                modelMap.put("success", "注册成功！登陆成功！");
                modelMap.put("openid", openId);
                modelMap.put("uId", user.getuId());
            }else {
                modelMap.put("success", null);
                modelMap.put("errMsg", "注册失败！");
            }
        }
        return modelMap;
    }

    @RequestMapping(value = "/listAllUserByRegisterTime", method = RequestMethod.GET)
    public PageInfo<User> listAllUserByRegisterTime(@RequestParam(defaultValue = "1") int pageNo, @RequestParam(defaultValue = "10") int pageSize){
        PageHelper.startPage(pageNo,pageSize);
        PageInfo<User> pageInfo = new PageInfo<>(userService.listAllUserByRegisterTime());
        return pageInfo;
    }

    @RequestMapping(value = "/listAllUserByLastLoginTime", method = RequestMethod.GET)
    public PageInfo<User> listAllUserByLastLoginTime(@RequestParam(defaultValue = "1") int pageNo, @RequestParam(defaultValue = "10") int pageSize){
        PageHelper.startPage(pageNo, pageSize);
        PageInfo<User> pageInfo = new PageInfo<>(userService.listAllUserByLastLoginTime());
        return pageInfo;
    }

    @RequestMapping(value = "/insert", method = RequestMethod.GET)
    public Map<String, Object> insert(@RequestParam(value = "gameId") int gameId, @RequestParam(value = "uId")int uId){
        Map<String, Object> modelMap = new HashMap<String, Object>();
        NewsLogs newsLogs = new NewsLogs();
        newsLogs.setNewsId(gameId);
        newsLogs.setUserId(uId);
        if(newsLogsService.insert(newsLogs) == true){
            modelMap.put("success", "插入记录成功！");
        }else {
            modelMap.put("errMsg", "插入记录失败！");
        }
        return modelMap;
    }
}
