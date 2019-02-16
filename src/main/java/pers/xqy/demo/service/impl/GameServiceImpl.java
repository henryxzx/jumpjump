package pers.xqy.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pers.xqy.demo.dao.GameDao;
import pers.xqy.demo.dao.GamePublisherDao;
import pers.xqy.demo.dao.GameTypeDao;
import pers.xqy.demo.entity.Game;
import pers.xqy.demo.service.GamePublisherService;
import pers.xqy.demo.service.GameService;
import pers.xqy.demo.service.GameTypeService;

import java.util.List;

@Service
public class GameServiceImpl implements GameService {

    @Autowired
    private GameDao gameDao;
    @Autowired
    private GameTypeDao gameTypeDao;
    @Autowired
    private GamePublisherDao gamePublisherDao;

    @Autowired
    private GameTypeService gameTypeService;

    @Autowired
    private GamePublisherService gamePublisherService;

    /**
     * @Author henryxzx
     * @Description //TODO 工具类 获取游戏类型和发行商
     * @Date 10:36 2019-02-11
     * @Param [listGame]
     * @return java.util.List<pers.xqy.demo.entity.Game>
     **/
    private List<Game> getGames(List<Game> listGame) {
        for (int i = 0; i < listGame.size(); i++){
            listGame.get(i).setGamePublisher(gamePublisherDao.findById(listGame.get(i).getGamePublisherId()));
            listGame.get(i).setGameType(gameTypeDao.findById(listGame.get(i).getGameTypeId()));
        }
        return listGame;
    }
    
    /**
     * @Author henryxzx
     * @Description //TODO 首页显示 按10条显示
     * @Date 16:03 2019-01-18
     * @Param [start]
     * @return java.util.List<pers.xqy.demo.entity.Game>
     **/
    @Transactional
    @Override
    public List<Game> findAllLimit(int start){
        List<Game> listGame = gameDao.findAllLimit(start);
        return getGames(listGame);
    }
    
    
    /**
     * @Author henryxzx
     * @Description //TODO 按名字查找游戏
     * @Date 16:07 2019-01-18
     * @Param [gameName]
     * @return pers.xqy.demo.entity.Game
     **/
    @Transactional
    @Override
    public Game findByName(String gameName){
        Game game = gameDao.findByName(gameName);
        game.setGamePublisher(gamePublisherDao.findById(game.getGamePublisherId()));
        game.setGameType(gameTypeDao.findById(game.getGameTypeId()));
        return game;
    }
    
    
    /**
     * @Author henryxzx
     * @Description //TODO 根据游戏Id查找游戏
     * @Date 17:57 2019-02-10
     * @Param [gameId]
     * @return pers.xqy.demo.entity.Game
     **/
    @Transactional
    @Override
    public Game findById(int gameId){
        return gameDao.findById(gameId);
    }
    
    /**
     * @Author henryxzx
     * @Description //TODO 根据游戏类型返回游戏信息
     * @Date 23:16 2019-02-10
     * @Param [gameType]
     * @return java.util.List<pers.xqy.demo.entity.Game>
     **/
    @Transactional
    @Override
    public List<Game> listByType(String gameType) {
        return gameDao.listByType(gameTypeService.findIdByName(gameType));
    }

    /**
     * @Author henryxzx
     * @Description //TODO 根据游戏发行商名称返回游戏信息
     * @Date 09:56 2019-02-11
     * @Param [gamePublisher]
     * @return java.util.List<pers.xqy.demo.entity.Game>
     **/
    @Transactional
    @Override
    public List<Game> listByPublisher(String gamePublisher) {
        return gameDao.listByPublisher(gamePublisherService.findIdByName(gamePublisher));
    }

    /**
     * @Author henryxzx
     * @Description //TODO 根据游戏发行时间降序排序
     * @Date 09:57 2019-02-11
     * @Param [start]
     * @return java.util.List<pers.xqy.demo.entity.Game>
     **/
    @Transactional
    @Override
    public List<Game> listByPublishTime(int start) {
        int p = (start-1)*10;
        List<Game> listGame = gameDao.listByPublishTime(p);
        return getGames(listGame);
    }

    
    /**
     * @Author henryxzx
     * @Description //TODO 根据游戏分数降序排序
     * @Date 10:02 2019-02-11
     * @Param [start]
     * @return java.util.List<pers.xqy.demo.entity.Game>
     **/
    @Transactional
    @Override
    public List<Game> listByGameScore(int start) {
        int p = (start-1)*10;
        List<Game> listGame = gameDao.listByGameScore(p);
        return getGames(listGame);
    }

    /**
     * @Author henryxzx
     * @Description //TODO 游戏评论数+1
     * @Date 14:03 2019-02-16
     * @Param [gameId]
     * @return boolean
     **/
    @Transactional
    @Override
    public boolean addCommentsNum(int gameId) {
        if (gameDao.addCommentsNum(gameId) > 0){
            return true;
        }else{
            return false;
        }
    }

    /**
     * @Author henryxzx
     * @Description //TODO 游戏评论数-1
     * @Date 14:09 2019-02-16
     * @Param [gameId]
     * @return boolean
     **/
    @Transactional
    @Override
    public boolean reduceCommentsNum(int gameId) {
        if (gameDao.reduceCommentsNum(gameId) > 0){
            return true;
        }else{
            return false;
        }
    }
}
