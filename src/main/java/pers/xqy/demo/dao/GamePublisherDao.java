package pers.xqy.demo.dao;

import pers.xqy.demo.entity.GamePublisher;

import java.util.List;

/**
 * @program: java_project
 * @description: 游戏发行商Dao层
 * @author: henryxzx
 * @create: 2019-01-19 17:05
 **/
public interface GamePublisherDao {
    /**
     * @Author henryxzx
     * @Description //TODO 列出所有游戏发行商
     * @Date 20:03 2019-01-19
     * @Param []
     * @return pers.xqy.demo.entity.GamePublisher
     **/
    public List<GamePublisher> listAll();

    /**
     * @Author henryxzx
     * @Description //TODO 根据Id查找游戏发行商
     * @Date 20:07 2019-01-19
     * @Param [gamePublisherId]
     * @return pers.xqy.demo.entity.GamePublisher
     **/
    public GamePublisher findById(int gamePublisherId);

    /**
     * @Author henryxzx
     * @Description //TODO 根据名称查找游戏发行商Id
     * @Date 23:25 2019-02-10
     * @Param [gamePublisherName]
     * @return pers.xqy.demo.entity.GamePublisher
     **/
    public GamePublisher findIdByName(String gamePublisherName);

}
