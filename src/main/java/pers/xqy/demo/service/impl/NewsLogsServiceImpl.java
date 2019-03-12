package pers.xqy.demo.service.impl;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pers.xqy.demo.dao.GameDao;
import pers.xqy.demo.dao.NewsLogsDao;
import pers.xqy.demo.dao.UserDao;
import pers.xqy.demo.entity.NewsLogs;
import pers.xqy.demo.service.NewsLogsService;

/**
 * @program: demo
 * @description: 游戏推荐引擎用户记录表Service层Impl
 * @author: henryxzx
 * @create: 2019-03-07 10:44
 **/
@Service
public class NewsLogsServiceImpl implements NewsLogsService {

    @Autowired
    private NewsLogsDao newsLogsDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private GameDao gameDao;

    private Page<NewsLogs> getGames(Page<NewsLogs> listGame) {
        for (int i = 0; i < listGame.size(); i++){
            listGame.get(i).setUser(userDao.findUserByUId(listGame.get(i).getUserId()));
            listGame.get(i).setGame(gameDao.findById(listGame.get(i).getNewsId()));
        }
        return listGame;
    }
    @Transactional
    @Override
    public Page<NewsLogs> listAll() {
        Page<NewsLogs> listGame = newsLogsDao.listAll();
        return getGames(listGame);

    }

    @Transactional
    @Override
    public boolean insert(NewsLogs newsLogs) {
        try {
            int effectedNum = newsLogsDao.insert(newsLogs);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("插入信息失败");
                }
            } catch (Exception e) {
                throw new RuntimeException("插入信息失败" + e.getMessage());
            }
        }
}
