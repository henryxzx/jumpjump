package pers.xqy.demo.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pers.xqy.demo.service.UserService;
import pers.xqy.demo.utils.HttpRequestUtil;

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

    //烂了
    @RequestMapping(value = "/login", method = RequestMethod.POST, consumes = "application/x-www-form-urlencoded")
    private Map<String, Object> getCode(@RequestParam(name = "code") String code, @RequestParam(name = "userInfo") String userInfo){
        Map<String, Object> modelMap = new HashMap<String, Object>();
        String APPID = "wxe441ec2425d06167";
        String js_code = code;
        String secret = "ff0df6f9400b322d357307c3079b1de9";
        String url = "https://api.weixin.qq.com/sns/jscode2session?" + "appid="+ APPID + "&secret=" + secret + "&js_code=" + js_code + "&grant_type=authorization_code";
        String result = HttpRequestUtil.get(url);
        JSONObject jsonResult= JSONObject.parseObject(result);
        JSONObject jsonUserInfo = JSONObject.parseObject(userInfo);
        System.out.println("result" + result);
//        System.out.println("code:" + code);
        System.out.println("userInfo:" + userInfo);
        System.out.println(jsonResult.getString("openid"));
        System.out.println(jsonUserInfo.toString());
        modelMap.put("success", "登陆成功！");
        modelMap.put("openid", jsonResult.getString("openid"));
        return modelMap;
    }


}
