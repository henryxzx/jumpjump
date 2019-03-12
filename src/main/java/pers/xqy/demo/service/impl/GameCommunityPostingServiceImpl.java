package pers.xqy.demo.service.impl;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pers.xqy.demo.dao.GameCommunityPostingDao;
import pers.xqy.demo.entity.GameCommunityPosting;
import pers.xqy.demo.service.GameCommunityPostingService;
import pers.xqy.demo.service.UserService;

import java.util.Date;

/**
 * @program: demo
 * @description: 游戏社区帖子Service层Impl
 * @author: henryxzx
 * @create: 2019-02-24 15:19
 **/
@Service
public class GameCommunityPostingServiceImpl implements GameCommunityPostingService {

    @Autowired
    public GameCommunityPostingDao gameCommunityPostingDao;
    @Autowired
    public UserService userService;

    @Transactional
    @Override
    public Page<GameCommunityPosting> listAllById(int gameCommuntiyId) {
        Page<GameCommunityPosting> list = gameCommunityPostingDao.listAllById(gameCommuntiyId);
        for (int i = 0; i < list.size();i++){
            list.get(i).setUser(userService.findUserByUId(list.get(i).getGameCommunityPostingUid()));
        }
        return list;
    }

    @Transactional
    @Override
    public boolean insert(GameCommunityPosting gameCommunityPosting) {
        gameCommunityPosting.setGameCommunityPostingTime(new java.sql.Date(new Date().getTime()));
        if (gameCommunityPostingDao.insert(gameCommunityPosting) > 0) {
            return true;
        }else {
            return false;
        }
    }

    @Transactional
    @Override
    public boolean delete(int gameCommunityPostingId) {
        if (gameCommunityPostingDao.delete(gameCommunityPostingId) > 0) {
            return true;
        }else {
            return false;
        }
    }

    @Transactional
    @Override
    public boolean addEvaluateNum(int gameCommunityPostingId) {
        if (gameCommunityPostingDao.addEvaluateNum(gameCommunityPostingId) > 0) {
            return true;
        }else {
            return false;
        }
    }

    @Transactional
    @Override
    public boolean reduceEvaluateNum(int gameCommunityPostingId) {
        if (gameCommunityPostingDao.reduceEvaluateNum(gameCommunityPostingId) > 0) {
            return true;
        }else {
            return false;
        }
    }

    @Transactional
    @Override
    public GameCommunityPosting findById(int gameCommunityPostingId) {
        GameCommunityPosting gameCommunityPosting = gameCommunityPostingDao.findById(gameCommunityPostingId);
        gameCommunityPosting.setUser(userService.findUserByUId(gameCommunityPosting.getGameCommunityPostingUid()));
        return gameCommunityPosting;
    }
}
