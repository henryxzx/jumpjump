package pers.xqy.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pers.xqy.demo.dao.GameCommunityDao;
import pers.xqy.demo.entity.GameCommunity;
import pers.xqy.demo.service.GameCommunityService;

import java.util.List;

/**
 * @program: demo
 * @description: 游戏社区Service层Impl
 * @author: henryxzx
 * @create: 2019-02-16 17:29
 **/
@Service
public class GameCommunityServiceImpl implements GameCommunityService {

    @Autowired
    private GameCommunityDao gameCommunityDao;

    @Transactional
    @Override
    public List<GameCommunity> listAll() {
        return gameCommunityDao.listAll();
    }

    @Transactional
    @Override
    public GameCommunity findById(int gameCommunityId) {
        return gameCommunityDao.findById(gameCommunityId);
    }

    @Transactional
    @Override
    public GameCommunity findByGameId(int gameId) {
        return gameCommunityDao.findByGameId(gameId);
    }

    @Transactional
    @Override
    public boolean insert(GameCommunity gameCommunity) {
        if (gameCommunity.getGameCommunityImage() != null && gameCommunity.getGameId() != null) {
            try {
                int effectedNum = gameCommunityDao.insert(gameCommunity);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("插入信息失败");
                }
            } catch (Exception e) {
                throw new RuntimeException("插入信息失败" + e.getMessage());
            }
        }else{
            throw new RuntimeException("游戏社区信息不能为空");
        }
    }
}
