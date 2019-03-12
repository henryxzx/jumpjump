package pers.xqy.demo.dao;

import com.github.pagehelper.Page;
import pers.xqy.demo.entity.Game;

public interface GameDao {
    /**
     * @Author henryxzx
     * @Description //TODO 主页的信息分页列出 10条一页
     * @Date 16:04 2019-01-18
     * @Param [start]
     * @return java.util.List<pers.xqy.demo.entity.Game>
     **/
    public Page<Game> findAllLimit();
    
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
     * @Param [gameTypeId]
     * @return java.util.List<pers.xqy.demo.entity.Game>
     **/
    public Page<Game> listByType(int gameTypeId);

    /**
     * @Author henryxzx
     * @Description //TODO 根据发行商显示游戏
     * @Date 16:05 2019-01-18
     * @Param [gamePublisherId]
     * @return java.util.List<pers.xqy.demo.entity.Game>
     **/
    public Page<Game> listByPublisher(int gamePublisherId);

    /**
     * @Author henryxzx
     * @Description //TODO 根据发行时间显示游戏
     * @Date 16:07 2019-01-18
     * @Param [start]
     * @return java.util.List<pers.xqy.demo.entity.Game>
     **/
    public Page<Game> listByPublishTime();

    /**
     * @Author henryxzx
     * @Description //TODO 根据评分显示游戏
     * @Date 16:10 2019-01-18
     * @Param [start]
     * @return java.util.List<pers.xqy.demo.entity.Game>
     **/
    public Page<Game> listByGameScore();

    /**
     * @Author henryxzx
     * @Description //TODO 根据游戏Id添加游戏评论数
     * @Date 17:36 2019-02-13
     * @Param [gameId]
     * @return boolean
     **/
    public Integer addCommentsNum(int gameId);

    
    /**
     * @Author henryxzx
     * @Description //TODO 根据游戏Id减少游戏评论数
     * @Date 17:45 2019-02-13
     * @Param [gameId]
     * @return java.lang.Integer
     **/
    public Integer reduceCommentsNum(int gameId);


    /**
     * @Author henryxzx
     * @Description //TODO 根据游戏热度显示游戏（按照评论和评分
     * @Date 14:51 2019-02-24
     * @Param [start]
     * @return java.util.List<pers.xqy.demo.entity.Game>
     **/
    public Page<Game> listByHot();

    /**
     * @Author henryxzx
     * @Description //TODO 添加新游戏
     * @Date 14:18 2019-03-10
     * @Param [game]
     * @return java.lang.Integer
     **/
    public Integer insert(Game game);

    /**
     * @Author henryxzx
     * @Description //TODO 删除游戏
     * @Date 14:19 2019-03-10
     * @Param [gameId]
     * @return java.lang.Integer
     **/
    public Integer delete(int gameId);

    /**
     * @Author henryxzx
     * @Description //TODO 修改游戏信息
     * @Date 14:20 2019-03-10
     * @Param [gameId]
     * @return java.lang.Integer
     **/
    public Integer update(Game game);


}
