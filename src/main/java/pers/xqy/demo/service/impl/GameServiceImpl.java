package pers.xqy.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pers.xqy.demo.dao.GameDao;
import pers.xqy.demo.entity.Game;
import pers.xqy.demo.service.GameService;

import java.util.List;

@Service
public class GameServiceImpl implements GameService {
    @Autowired
    private GameDao gameDao;

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
        return gameDao.findAllLimit(start);
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
        return gameDao.findByName(gameName);
    }

    @Override
    public List<Game> listByType(String gameType) {
        return null;
    }

    @Override
    public List<Game> listByPublisher(String gamePublisher) {
        return null;
    }

}
