package pers.xqy.demo.service;

import com.github.pagehelper.Page;
import pers.xqy.demo.entity.NewsLogs;

/**
 * @program: demo
 * @description: 游戏推荐引擎用户记录表Service层
 * @author: henryxzx
 * @create: 2019-03-07 10:41
 **/
public interface NewsLogsService {

    public Page<NewsLogs> listAll();

    public boolean insert(NewsLogs newsLogs);
}
