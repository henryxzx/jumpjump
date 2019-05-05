package pers.xqy.demo.service.impl;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pers.xqy.demo.dao.RecommendationsDao;
import pers.xqy.demo.dao.UserDao;
import pers.xqy.demo.entity.Recommendations;
import pers.xqy.demo.service.GameService;
import pers.xqy.demo.service.RecommendationsService;

/**
 * @program: demo
 * @description: 游戏引擎个人推荐Service层Impl
 * @author: henryxzx
 * @create: 2019-03-08 14:15
 **/
@Service
public class RecommendationsServiceImpl implements RecommendationsService {
    @Autowired
    private RecommendationsDao recommendationsDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private GameService gameService;

    @Transactional
    @Override
    public Page<Recommendations> listById(int userId) {
        Page<Recommendations> list = recommendationsDao.listById(userId);
        for (int i = 0;i < list.size();i++){
            list.get(i).setUser(userDao.findUserByUId(userId));
            list.get(i).setGame(gameService.findById(list.get(i).getNewsId()));
        }
        return list;
    }
}
