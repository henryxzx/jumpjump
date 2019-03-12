package pers.xqy.demo.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pers.xqy.demo.entity.GameCommunityPosting;
import pers.xqy.demo.entity.GameCommunityPostingEvaluate;
import pers.xqy.demo.service.GameCommunityPostingEvaluateService;
import pers.xqy.demo.service.GameCommunityPostingService;
import pers.xqy.demo.service.GameCommunityService;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: demo
 * @description: 游戏社区Controller层
 * @author: henryxzx
 * @create: 2019-03-10 22:09
 **/
@RestController
@RequestMapping("/gameCommunity")
public class GameCommunityController {
    @Autowired
    private GameCommunityService gameCommunityService;
    @Autowired
    private GameCommunityPostingService gameCommunityPostingService;
    @Autowired
    private GameCommunityPostingEvaluateService gameCommunityPostingEvaluateService;

    /**
     * @Author henryxzx
     * @Description //TODO 根据游戏Id返回游戏社区信息
     * @Date 23:33 2019-03-10
     * @Param [gameId]
     * @return java.util.Map<java.lang.String,java.lang.Object>
     **/
    @RequestMapping(value = "/getByGameId", method = RequestMethod.GET)
    private Map<String, Object> getByGameId(int gameId){
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("community", gameCommunityService.findByGameId(gameId));
        return modelMap;
    }

    @RequestMapping(value = "/getPostingById", method = RequestMethod.GET)
    private PageInfo<GameCommunityPosting> getPostingById(@RequestParam(defaultValue = "1") int pageNo, @RequestParam(defaultValue = "10") int pageSize,int gameCommunityId){
        int id = gameCommunityId;
        PageHelper.startPage(pageNo,pageSize);
        PageInfo<GameCommunityPosting> pageInfo = new PageInfo<>(gameCommunityPostingService.listAllById(id));
        return pageInfo;
    }

    @RequestMapping(value = "/getPostingContentById", method = RequestMethod.GET)
    private Map<String, Object> getPostingContentById(@RequestParam(defaultValue = "1") int pageNo, @RequestParam(defaultValue = "10") int pageSize,int gameCommunityPostingId){
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("posting", gameCommunityPostingService.findById(gameCommunityPostingId));
        return modelMap;
    }

    @RequestMapping(value = "/getPostingEvaluateById", method = RequestMethod.GET)
    private PageInfo<GameCommunityPostingEvaluate> getPostingEvaluateById(@RequestParam(defaultValue = "1") int pageNo, @RequestParam(defaultValue = "10") int pageSize,int gameCommunityPostingId){
        int id = gameCommunityPostingId;
        PageHelper.startPage(pageNo,pageSize);
        PageInfo<GameCommunityPostingEvaluate> pageInfo = new PageInfo<>(gameCommunityPostingEvaluateService.listAllById(id));
        return pageInfo;
    }

    @RequestMapping(value = "/addPosting", method = RequestMethod.POST)
    private Map<String, Object> addPosting(@RequestParam(value = "gameCommunityPostingContent")String gameCommunityPostingContent, @RequestParam(value = "gameCommunityPostingTitle")String gameCommunityPostingTitle,
                                           @RequestParam(value = "gameCommunityPostingUid") int gameCommunityPostingUid, @RequestParam(value = "gameCommuntiyPostingGameCommuntiyId") int gameCommuntiyPostingGameCommuntiyId) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        GameCommunityPosting gameCommunityPosting = new GameCommunityPosting();
        gameCommunityPosting.setGameCommunityPostingContent(gameCommunityPostingContent);
        gameCommunityPosting.setGameCommunityPostingTitle(gameCommunityPostingTitle);
        gameCommunityPosting.setGameCommunityPostingUid(gameCommunityPostingUid);
        gameCommunityPosting.setGameCommuntiyPostingGameCommuntiyId(gameCommuntiyPostingGameCommuntiyId);
        if (gameCommunityPostingService.insert(gameCommunityPosting) == true) {
            modelMap.put("success", "插入成功！");
        }else {
            modelMap.put("errMsg", "插入失败");
        }
        return modelMap;
    }

    @RequestMapping(value = "/addPostingEvaluate", method = RequestMethod.POST)
    private Map<String, Object> addPostingEvaluate(@RequestParam(value = "gameCommunityPostingEvaluateConetent") String gameCommunityPostingEvaluateConetent,
                                                   @RequestParam(value = "gameCommunityPostingEvaluatePostingId") int gameCommunityPostingEvaluatePostingId,
                                                   @RequestParam(value = "gameCommunityPostingEvaluateUid") int gameCommunityPostingEvaluateUid){
        Map<String, Object> modelMap = new HashMap<String, Object>();
        GameCommunityPostingEvaluate gameCommunityPostingEvaluate = new GameCommunityPostingEvaluate();
        gameCommunityPostingEvaluate.setGameCommunityPostingEvaluateContent(gameCommunityPostingEvaluateConetent);
        gameCommunityPostingEvaluate.setGameCommunityPostingEvaluatePostingId(gameCommunityPostingEvaluatePostingId);
        gameCommunityPostingEvaluate.setGameCommunityPostingEvaluateUid(gameCommunityPostingEvaluateUid);
        if(gameCommunityPostingEvaluateService.insert(gameCommunityPostingEvaluate) == true){
            modelMap.put("success", "插入成功！");
        }else {
            modelMap.put("errMsg", "插入失败！");
        }
        return modelMap;
    }


}
