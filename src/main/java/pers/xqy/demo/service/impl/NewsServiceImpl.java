package pers.xqy.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.xqy.demo.dao.NewsDao;
import pers.xqy.demo.entity.News;
import pers.xqy.demo.service.NewsService;

/**
 * @program: demo
 * @description: 游戏推荐引擎游戏类Service层Impl
 * @author: henryxzx
 * @create: 2019-03-10 15:10
 **/
@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsDao newsDao;

    @Override
    public boolean insert(News news) {
        if (news.getTitle() != null && news.getContent() != null) {
            try {
                int effectedNum = newsDao.insert(news);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("插入信息失败");
                }
            } catch (Exception e) {
                throw new RuntimeException("插入信息失败" + e.getMessage());
            }
        }else{
            throw new RuntimeException("游戏信息不能为空");
        }
    }

    @Override
    public boolean delete(int newsId) {
        if (newsId > 0) {
            try {
                int effectedNum = newsDao.delete(newsId);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("删除信息失败");
                }
            } catch (Exception e) {
                throw new RuntimeException("删除信息失败" + e.getMessage());
            }
        }else{
            throw new RuntimeException("Id不能为空");
        }
    }

    @Override
    public boolean update(News news) {
        if (news.getId() > 0) {
            try {
                int effectedNum = newsDao.update(news);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("删除信息失败");
                }
            } catch (Exception e) {
                throw new RuntimeException("删除信息失败" + e.getMessage());
            }
        }else{
            throw new RuntimeException("Id不能为空");
        }
    }
}
