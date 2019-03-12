package pers.xqy.demo.dao;

import com.github.pagehelper.Page;
import pers.xqy.demo.entity.NewsLogs;

/**
 * @program: demo
 * @description: 游戏推荐引擎用户记录表
 * @author: henryxzx
 * @create: 2019-03-07 10:18
 **/
public interface NewsLogsDao {

    public Page<NewsLogs> listAll();

    public Integer insert(NewsLogs newsLogs);

}
