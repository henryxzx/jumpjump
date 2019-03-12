package pers.xqy.demo.service.impl;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pers.xqy.demo.dao.GameDao;
import pers.xqy.demo.dao.GameTypeDao;
import pers.xqy.demo.entity.Game;
import pers.xqy.demo.service.GamePublisherService;
import pers.xqy.demo.service.GameService;
import pers.xqy.demo.service.GameTypeService;

@Service
public class GameServiceImpl implements GameService {

    @Autowired
    private GameDao gameDao;
    @Autowired
    private GameTypeDao gameTypeDao;
//    @Autowired
//    private GamePublisherDao gamePublisherDao;

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
    private Page<Game> getGames(Page<Game> listGame) {
        for (int i = 0; i < listGame.size(); i++){
//            listGame.get(i).setGamePublisher(gamePublisherDao.findById(listGame.get(i).getGamePublisherId()));
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
    public Page<Game> findAllLimit(){
        Page<Game> listGame = gameDao.findAllLimit();
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
//        game.setGamePublisher(gamePublisherService.findById(game.getGamePublisherId()));
        game.setGameType(gameTypeService.findById(game.getGameTypeId()));
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
        Game game = gameDao.findById(gameId);
//        game.setGamePublisher(gamePublisherDao.findById(game.getGamePublisherId()));
        game.setGameType(gameTypeDao.findById(game.getGameTypeId()));
        return game;
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
    public Page<Game> listByType(String gameType) {
        Page<Game> listGame = gameDao.listByType(gameTypeService.findIdByName(gameType));
        return getGames(listGame);
    }

    /**
     * @Author henryxzx
     * @Description //TODO 根据游戏发行商名称返回游戏信息
     * @Date 09:56 2019-02-11
     * @Param [gamePublisher]
     * @return java.util.List<pers.xqy.demo.entity.Game>
     **/
//    @Transactional
//    @Override
//    public Page<Game> listByPublisher(String gamePublisher) {
//        Page<Game> listGame =  gameDao.listByPublisher(gamePublisherService.findIdByName(gamePublisher));
//        return getGames(listGame);
//    }

    /**
     * @Author henryxzx
     * @Description //TODO 根据游戏发行时间降序排序
     * @Date 09:57 2019-02-11
     * @Param [start]
     * @return java.util.List<pers.xqy.demo.entity.Game>
     **/
    @Transactional
    @Override
    public Page<Game> listByPublishTime() {
        Page<Game> listGame = gameDao.listByPublishTime();
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
    public Page<Game> listByGameScore() {
//        int p = (start-1)*10;
        Page<Game> listGame = gameDao.listByGameScore();
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

    /**
     * @Author henryxzx
     * @Description //TODO 根据热度列出游戏
     * @Date 17:06 2019-02-24
     * @Param [start]
     * @return java.util.List<pers.xqy.demo.entity.Game>
     **/
    @Transactional
    @Override
    public Page<Game> listByHot() {
        return gameDao.listByHot();
    }

    /**
     * @Author henryxzx
     * @Description //TODO 添加新游戏
     * @Date 14:50 2019-03-10
     * @Param [game]
     * @return boolean
     **/
    @Transactional
    @Override
    public boolean insert(Game game) {
        if (game.getGameName() != null && game.getGameContent() != null) {
            try {
                int effectedNum = gameDao.insert(game);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("插入信息失败");
                }
            } catch (Exception e) {
                throw new RuntimeException("插入信息失败" + e.getMessage());
            }
        }else{
            throw new RuntimeException("游戏信息不能为空");
        }
    }

    /**
     * @Author henryxzx
     * @Description //TODO 删除游戏
     * @Date 14:52 2019-03-10
     * @Param [gameId]
     * @return boolean
     **/
    @Transactional
    @Override
    public boolean delete(int gameId) {
        if (gameId > 0) {
            try {
                int effectedNum = gameDao.delete(gameId);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("删除信息失败");
                }
            } catch (Exception e) {
                throw new RuntimeException("删除信息失败" + e.getMessage());
            }
        }else{
            throw new RuntimeException("Id不能为空");
        }
    }

    /**
     * @Author henryxzx
     * @Description //TODO 更新游戏信息
     * @Date 14:52 2019-03-10
     * @Param [gameId]
     * @return boolean
     **/
    @Transactional
    @Override
    public boolean update(Game game) {
        if (game.getGameId() > 0) {
            try {
                int effectedNum = gameDao.update(game);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("删除信息失败");
                }
            } catch (Exception e) {
                throw new RuntimeException("删除信息失败" + e.getMessage());
            }
        }else{
            throw new RuntimeException("Id不能为空");
        }
    }
}
