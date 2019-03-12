package pers.xqy.demo.dao;

import pers.xqy.demo.entity.News;

/**
 * @program: demo
 * @description: 游戏引擎游戏类
 * @author: henryxzx
 * @create: 2019-03-10 15:00
 **/
public interface NewsDao {
    public Integer insert(News news);

    public Integer delete(int newsId);

    public Integer update(News news);
}
