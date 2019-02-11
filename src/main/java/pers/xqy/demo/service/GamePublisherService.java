package pers.xqy.demo.service;

import pers.xqy.demo.entity.GamePublisher;

import java.util.List;

/**
 * @program: demo
 * @description: 游戏发行商Service层
 * @author: henryxzx
 * @create: 2019-02-10 20:13
 **/
public interface GamePublisherService {
    
    /**
     * @Author henryxzx
     * @Description //TODO 列出所有游戏发行商
     * @Date 20:15 2019-02-10
     * @Param []
     * @return java.util.List<pers.xqy.demo.entity.GamePublisher>
     **/
    public List<GamePublisher> listAll();
    
    /**
     * @Author henryxzx
     * @Description //TODO 根据发行商Id找出发行商
     * @Date 20:16 2019-02-10
     * @Param [gamePublisherId]
     * @return pers.xqy.demo.entity.GamePublisher
     **/
    public GamePublisher findById(int gamePublisherId);

    /**
     * @Author henryxzx
     * @Description //TODO 根据名称找出Id
     * @Date 23:21 2019-02-10
     * @Param [gameTypeName]
     * @return java.lang.Integer
     **/
    public Integer findIdByName(String gamePublisherName);

}
