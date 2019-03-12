package pers.xqy.demo.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pers.xqy.demo.entity.Game;
import pers.xqy.demo.entity.GameCommunity;
import pers.xqy.demo.entity.News;
import pers.xqy.demo.service.GameCommunityService;
import pers.xqy.demo.service.GameService;
import pers.xqy.demo.service.NewsService;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/game")
public class GameController {
    @Autowired
    private GameService gameService;
    @Autowired
    private NewsService newsService;
    @Autowired
    private GameCommunityService gameCommunityService;

    /**
    首页显示
    默认每页10条
     */
    @RequestMapping(value = "/initGameInfo", method = RequestMethod.GET)
    private PageInfo<Game> listGameInfo(@RequestParam(defaultValue = "1") int pageNo, @RequestParam(defaultValue = "10") int pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        PageInfo<Game> pageInfo = new PageInfo<>(gameService.findAllLimit());
        return pageInfo;
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
    private PageInfo<Game> getGameByType(@RequestParam(defaultValue = "1") int pageNo, @RequestParam(defaultValue = "10") int pageSize,@RequestParam String gameType){
        PageHelper.startPage(pageNo,pageSize);
        PageInfo<Game> pageInfo = new PageInfo<>(gameService.listByType(gameType));
        return pageInfo;
    }

    /**
     * @Author henryxzx
     * @Description //TODO 根据游戏发行商获取游戏信息
     * @Date 16:25 2019-02-16
     * @Param [gamePublisher]
     * @return java.util.Map<java.lang.String,java.lang.Object>
     **/
//    @RequestMapping(value = "/getGameByPublisher", method = RequestMethod.GET)
//    private Map<String, Object> getGameByPublisher(String gamePublisher){
//        Map<String, Object> modelMap = new HashMap<String, Object>();
//        List<Game> list = gameService.listByPublisher(gamePublisher);
//        modelMap.put("gameList", list);
//        return modelMap;
//    }

    
    /**
     * @Author henryxzx
     * @Description //TODO 根据游戏发行时间获取游戏信息
     * @Date 16:25 2019-02-16
     * @Param [page]
     * @return java.util.Map<java.lang.String,java.lang.Object>
     **/
    @RequestMapping(value = "/getGameByPublishTime", method = RequestMethod.GET)
    private PageInfo<Game> getGameByPublishTime(@RequestParam(defaultValue = "1") int pageNo, @RequestParam(defaultValue = "10") int pageSize){
        PageHelper.startPage(pageNo,pageSize);
        PageInfo<Game> pageInfo = new PageInfo<>(gameService.listByPublishTime());
        return pageInfo;
    }

    
    /**
     * @Author henryxzx
     * @Description //TODO 根据游戏评分获取游戏信息
     * @Date 16:27 2019-02-16
     * @Param [page]
     * @return java.util.Map<java.lang.String,java.lang.Object>
     **/
    @RequestMapping(value = "/getGameByScore", method = RequestMethod.GET)
    private PageInfo<Game> getGameByScore(@RequestParam(defaultValue = "1") int pageNo, @RequestParam(defaultValue = "10") int pageSize){
        PageHelper.startPage(pageNo,pageSize);
        PageInfo<Game> pageInfo = new PageInfo<>(gameService.listByGameScore());
        return pageInfo;
    }

    /**
     * @Author henryxzx
     * @Description //TODO 根据游戏Id获取游戏信息
     * @Date 16:46 2019-03-10
     * @Param [gameId]
     * @return java.util.Map<java.lang.String,java.lang.Object>
     **/
    @RequestMapping(value = "/getGameById", method = RequestMethod.GET)
    private Map<String, Object> getGameById(String gameId){
        Map<String, Object> modelMap = new HashMap<String, Object>();
        int id = Integer.parseInt(gameId);
        Game game = gameService.findById(id);
        modelMap.put("game", game);
        return modelMap;
    }


    @RequestMapping(value = "/addGame", method = RequestMethod.POST)
    private Map<String, Object> addGame(@RequestParam(value = "gameName") String gameName, @RequestParam(value = "gameContent")String gameContent, @RequestParam(value = "gameTypeId")int gameTypeId,
                                        @RequestParam(value = "gamePublisher") String gamePublisher, @RequestParam(value = "gamePublishTime") Date gamePublishTime, @RequestParam(value = "gameScore") int gameScore,
                                        @RequestParam(value = "gameImage") String gameImage){
        Map<String, Object> modelMap = new HashMap<String, Object>();
        System.out.println(gameName);
        Game game = new Game();
        game.setGameTypeId(gameTypeId);
        game.setGameContent(gameContent);
        game.setGameImage(gameImage);
        game.setGameName(gameName);
        game.setGamePublisher(gamePublisher);
        game.setGamePublishTime(gamePublishTime);
        game.setGameScore(gameScore);
        if(gameService.insert(game) == true){
            game.setGameId(gameService.findByName(game.getGameName()).getGameId());
            News news = new News();
            news.setContent(game.getGameContent());
            news.setId(game.getGameId());
            news.setTitle(game.getGameName());
            news.setModuleId(game.getGameTypeId());
            if(newsService.insert(news) == true){
                GameCommunity gameCommunity = new GameCommunity();
                gameCommunity.setGameId(game.getGameId());
                gameCommunity.setGameCommunityImage(gameImage);
                if(gameCommunityService.insert(gameCommunity) == true){
                    modelMap.put("success", "插入游戏成功！");
                }else {
                    modelMap.put("errMsg","插入游戏社区失败！");
                }
            }else {
                modelMap.put("errMsg", "插入游戏引擎失败！");
            }
        }else {
            modelMap.put("errMsg","插入游戏失败！");
        }
        return modelMap;
    }







}
