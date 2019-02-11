package pers.xqy.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pers.xqy.demo.dao.GameTypeDao;
import pers.xqy.demo.entity.GameType;
import pers.xqy.demo.service.GameTypeService;

import java.util.List;

/**
 * @program: demo
 * @description: 游戏类型Service层Impl
 * @author: henryxzx
 * @create: 2019-02-10 20:25
 **/
@Service
public class GameTypeServiceImpl implements GameTypeService {
    @Autowired
    private GameTypeDao gameTypeDao;

    /**
     * @Author henryxzx
     * @Description //TODO 列出所有游戏类型信息
     * @Date 20:38 2019-02-10
     * @Param []
     * @return java.util.List<pers.xqy.demo.entity.GameType>
     **/
    @Transactional
    @Override
    public List<GameType> listAll() {
        return gameTypeDao.listAll();
    }


    /**
     * @Author henryxzx
     * @Description //TODO 根据Id列出游戏信息
     * @Date 20:38 2019-02-10
     * @Param [gameTypeId]
     * @return pers.xqy.demo.entity.GameType
     **/
    @Transactional
    @Override
    public GameType findById(int gameTypeId) {
        return gameTypeDao.findById(gameTypeId);
    }

    @Transactional
    @Override
    public Integer findIdByName(String gameTypeName) {
        return gameTypeDao.findIdByName(gameTypeName).getGameTypeId();
    }
}
