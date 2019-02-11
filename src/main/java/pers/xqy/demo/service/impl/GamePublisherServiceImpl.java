package pers.xqy.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pers.xqy.demo.dao.GamePublisherDao;
import pers.xqy.demo.entity.GamePublisher;
import pers.xqy.demo.service.GamePublisherService;

import java.util.List;

/**
 * @program: demo
 * @description: 游戏发行商Service层Impl
 * @author: henryxzx
 * @create: 2019-02-10 20:24
 **/
@Service
public class GamePublisherServiceImpl implements GamePublisherService {
    @Autowired
    private GamePublisherDao gamePublisherDao;
    
    /**
     * @Author henryxzx
     * @Description //TODO 列出所有游戏厂商信息
     * @Date 20:36 2019-02-10
     * @Param []
     * @return java.util.List<pers.xqy.demo.entity.GamePublisher>
     **/
    @Transactional
    @Override
    public List<GamePublisher> listAll() {
        return gamePublisherDao.listAll();
    }
    
    /**
     * @Author henryxzx
     * @Description //TODO 根据Idf返回游戏厂商信息
     * @Date 20:37 2019-02-10
     * @Param [gamePublisherId]
     * @return pers.xqy.demo.entity.GamePublisher
     **/
    @Transactional
    @Override
    public GamePublisher findById(int gamePublisherId) {
        return gamePublisherDao.findById(gamePublisherId);
    }

    /**
     * @Author henryxzx
     * @Description //TODO 根据名称找出ID
     * @Date 23:22 2019-02-10
     * @Param [gameTypeName]
     * @return java.lang.Integer
     **/
    @Transactional
    @Override
    public Integer findIdByName(String gamePublisherName) {
        return gamePublisherDao.findIdByName(gamePublisherName).getGamePublisherId();
    }
}


