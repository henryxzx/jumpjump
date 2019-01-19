package pers.xqy.demo.dao;

import pers.xqy.demo.entity.Game;

import java.util.List;

public interface GameDao {
    /**
     * @Author henryxzx
     * @Description //TODO 主页的信息分页列出 10条一页
     * @Date 16:04 2019-01-18
     * @Param [start]
     * @return java.util.List<pers.xqy.demo.entity.Game>
     **/
    public List<Game> findAllLimit(int start);
    
    /**
     * @Author henryxzx
     * @Description //TODO 根据游戏Id返回游戏所有信息
     * @Date 16:13 2019-01-18
     * @Param [gameId]
     * @return pers.xqy.demo.entity.Game
     **/
    public Game findById(int gameId);
    
    /**
     * @Author henryxzx
     * @Description //TODO 查找游戏名称 返回一条信息
     * @Date 16:04 2019-01-18
     * @Param [gameName]
     * @return pers.xqy.demo.entity.Game
     **/
    public Game findByName(String gameName);

    /**
     * @Author henryxzx
     * @Description //TODO 根据类型显示游戏
     * @Date 16:05 2019-01-18
     * @Param [gameType]
     * @return java.util.List<pers.xqy.demo.entity.Game>
     **/
    public List<Game> listByType(String gameType);

    /**
     * @Author henryxzx
     * @Description //TODO 根据发行商显示游戏
     * @Date 16:05 2019-01-18
     * @Param [gamePublisher]
     * @return java.util.List<pers.xqy.demo.entity.Game>
     **/
    public List<Game> listByPublisher(String gamePublisher);

    /**
     * @Author henryxzx
     * @Description //TODO 根据发行时间显示游戏
     * @Date 16:07 2019-01-18
     * @Param [start]
     * @return java.util.List<pers.xqy.demo.entity.Game>
     **/
    public List<Game> listByPublishTime(int start);

    /**
     * @Author henryxzx
     * @Description //TODO 根据评分显示游戏
     * @Date 16:10 2019-01-18
     * @Param [start]
     * @return java.util.List<pers.xqy.demo.entity.Game>
     **/
    public List<Game> listByGameScore(int start);


    


}
