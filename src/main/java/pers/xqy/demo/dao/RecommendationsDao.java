package pers.xqy.demo.dao;

import com.github.pagehelper.Page;
import pers.xqy.demo.entity.Recommendations;

/**
 * @program: demo
 * @description: 游戏推荐引擎游戏推荐结果
 * @author: henryxzx
 * @create: 2019-03-07 10:33
 **/
public interface RecommendationsDao {

    public Page<Recommendations> listById(int userId);

}
