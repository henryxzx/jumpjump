package pers.xqy.demo.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pers.xqy.demo.entity.Recommend;
import pers.xqy.demo.entity.Recommendations;
import pers.xqy.demo.service.RecommendService;
import pers.xqy.demo.service.RecommendationsService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: demo
 * @description: 游戏推荐信息Controller
 * @author: henryxzx
 * @create: 2019-02-16 16:07
 **/

@RestController
@RequestMapping("/recommend")
public class RecommendController {
    @Autowired
    private RecommendService recommendService;

    @Autowired
    private RecommendationsService recommendationsService;

    /**
     * @Author henryxzx
     * @Description //TODO 列出所有推荐信息
     * @Date 16:53 2019-02-16
     * @Param []
     * @return java.util.Map<java.lang.String,java.lang.Object>
     **/
//    @RequestMapping(value = "/listAllRecommend", method = RequestMethod.GET)
//    private Map<String, Object> listAllRecommend(@RequestParam(defaultValue = "1") int pageNo, @RequestParam(defaultValue = "2") int pageSize){
//        Map<String, Object> modelMap = new HashMap<String, Object>();
//        PageHelper.startPage(pageNo,pageSize);
//        List<Recommend> list = recommendService.listAllRecommend();
//        modelMap.put("recommendList", list);
//        return modelMap;
//    }

    @RequestMapping(value = "/listAllRecommend", method = RequestMethod.GET)
    private PageInfo<Recommend> listAllRecommend(@RequestParam(defaultValue = "1") int pageNo, @RequestParam(defaultValue = "10") int pageSize){
//        Map<String, Object> modelMap = new HashMap<String, Object>();
        PageHelper.startPage(pageNo,pageSize);
        PageInfo<Recommend> pageInfo = new PageInfo<>(recommendService.listAllRecommend());
        return pageInfo;
    }


    @RequestMapping(value = "/listById", method = RequestMethod.GET)
    public Map<String, Object> listById(int uId){
//        PageHelper.startPage(pageNo, pageSize);
//        PageInfo<Recommendations> pageInfo = new PageInfo<>(recommendationsService.listById(uId));
//        return pageInfo;
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<Recommendations> list = recommendationsService.listById(uId);
        modelMap.put("List", list);
        return modelMap;
    }
}
