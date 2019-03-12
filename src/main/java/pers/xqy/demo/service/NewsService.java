package pers.xqy.demo.service;

import pers.xqy.demo.entity.News;

/**
 * @program: demo
 * @description: 游戏推荐引擎游戏类
 * @author: henryxzx
 * @create: 2019-03-10 15:09
 **/
public interface NewsService {
    public boolean insert(News news);

    public boolean delete(int newsId);

    public boolean update(News news);

}
