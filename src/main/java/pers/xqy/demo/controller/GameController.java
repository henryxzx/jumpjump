package pers.xqy.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pers.xqy.demo.entity.Game;
import pers.xqy.demo.service.GameService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/game")
public class GameController {
    @Autowired
    private GameService gameService;
    /**
    首页显示
    默认每页10条
     */
    @RequestMapping(value = "/initGameInfo", method = RequestMethod.GET)
    private Map<String, Object> listGameInfo(String page) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        int p = Integer.parseInt(page);
//        int p = 1;
        List<Game> list = gameService.findAllLimit((p-1)*10);
        modelMap.put("gameList", list);
        return modelMap;
    }


    /**
    根据游戏名称查找游戏
     */
    @RequestMapping(value = "/getGameByName", method = RequestMethod.GET)
    private Map<String, Object> getGameByName(String gameName){
        Map<String, Object> modelMap = new HashMap<String, Object>();
//        gameName = "测试";
        Game game = gameService.findByName(gameName);
        modelMap.put("gameList", game);
        return modelMap;
    }

    /**
     * @Author henryxzx
     * @Description //TODO 根据游戏类型获取游戏信息
     * @Date 14:16 2019-02-16
     * @Param [gameType]
     * @return java.util.Map<java.lang.String,java.lang.Object>
     **/
    @RequestMapping(value = "/getGameByType", method = RequestMethod.GET)
    private Map<String, Object> getGameByType(String gameType){
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<Game> list = gameService.listByType(gameType);
        modelMap.put("gameList", list);
        return modelMap;
    }

    /**
     * @Author henryxzx
     * @Description //TODO 根据游戏发行商获取游戏信息
     * @Date 16:25 2019-02-16
     * @Param [gamePublisher]
     * @return java.util.Map<java.lang.String,java.lang.Object>
     **/
    @RequestMapping(value = "/getGameByPublisher", method = RequestMethod.GET)
    private Map<String, Object> getGameByPublisher(String gamePublisher){
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<Game> list = gameService.listByPublisher(gamePublisher);
        modelMap.put("gameList", list);
        return modelMap;
    }

    
    /**
     * @Author henryxzx
     * @Description //TODO 根据游戏发行时间获取游戏信息
     * @Date 16:25 2019-02-16
     * @Param [page]
     * @return java.util.Map<java.lang.String,java.lang.Object>
     **/
    @RequestMapping(value = "/getGameByPublishTime", method = RequestMethod.GET)
    private Map<String, Object> getGameByPublishTime(String page){
        Map<String, Object> modelMap = new HashMap<String, Object>();
        int p = Integer.parseInt(page);
        List<Game> list = gameService.listByPublishTime(p);
        modelMap.put("gameList", list);
        return modelMap;
    }

    
    /**
     * @Author henryxzx
     * @Description //TODO 根据游戏评分获取游戏信息
     * @Date 16:27 2019-02-16
     * @Param [page]
     * @return java.util.Map<java.lang.String,java.lang.Object>
     **/
    @RequestMapping(value = "/getGameByScore", method = RequestMethod.GET)
    private Map<String, Object> getGameByScore(String page){
        Map<String, Object> modelMap = new HashMap<String, Object>();
        int p = Integer.parseInt(page);
        List<Game> list = gameService.listByGameScore(p);
        modelMap.put("gameList", list);
        return modelMap;
    }






}
