package pers.xqy.demo.service.impl;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pers.xqy.demo.dao.GameCommunityPostingEvaluateDao;
import pers.xqy.demo.entity.GameCommunityPostingEvaluate;
import pers.xqy.demo.service.GameCommunityPostingEvaluateService;
import pers.xqy.demo.service.UserService;

import java.util.Date;
import java.util.List;

/**
 * @program: demo
 * @description: 游戏社区帖子评论Service层Impl
 * @author: henryxzx
 * @create: 2019-02-24 16:28
 **/
@Service
public class GameCommunityPostingEvaluateServiceImpl implements GameCommunityPostingEvaluateService {

    @Autowired
    public GameCommunityPostingEvaluateDao gameCommunityPostingEvaluateDao;
    @Autowired
    public UserService userService;

    @Transactional
    @Override
    public Page<GameCommunityPostingEvaluate> listAllById(int gameCommunityPostingId) {
        Page<GameCommunityPostingEvaluate> list = gameCommunityPostingEvaluateDao.listAllById(gameCommunityPostingId);
        for (int i = 0;i < list.size();i++){
            list.get(i).setUser(userService.findUserByUId(list.get(i).getGameCommunityPostingEvaluateUid()));
        }
        return list;
    }
    @Transactional
    @Override
    public GameCommunityPostingEvaluate findById(int gameCommunityPostingEvaluateId) {
        GameCommunityPostingEvaluate gameCommunityPostingEvaluate = gameCommunityPostingEvaluateDao.findById(gameCommunityPostingEvaluateId);
        gameCommunityPostingEvaluate.setUser(userService.findUserByUId(gameCommunityPostingEvaluate.getGameCommunityPostingEvaluateUid()));
        return gameCommunityPostingEvaluate;
    }

    @Transactional
    @Override
    public boolean insert(GameCommunityPostingEvaluate gameCommunityPostingEvaluate) {
        gameCommunityPostingEvaluate.setGameCommunityPostingEvaluateTime(new java.sql.Date(new Date().getTime()));
        if (gameCommunityPostingEvaluateDao.insert(gameCommunityPostingEvaluate) > 0){
            return true;
        }else {
            return false;
        }
    }

    @Transactional
    @Override
    public boolean delete(int gameCommunityPostingEvaluateId) {
        if(gameCommunityPostingEvaluateDao.delete(gameCommunityPostingEvaluateId) > 0){
            return true;
        }else {
            return false;
        }
    }

    @Transactional
    @Override
    public List<GameCommunityPostingEvaluate> listByUId(int uId) {
        return gameCommunityPostingEvaluateDao.listByUId(uId);
    }
}
