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
//        int p = Integer.parseInt(page);
        int p = 1;
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
        gameName = "测试";
        Game game = gameService.findByName(gameName);
        modelMap.put("gameList", game);
        return modelMap;
    }





}
