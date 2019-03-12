package pers.xqy.demo.service;

import com.github.pagehelper.Page;
import pers.xqy.demo.entity.Recommendations;

/**
 * @program: demo
 * @description: 游戏引擎个人推荐Service层
 * @author: henryxzx
 * @create: 2019-03-08 14:03
 **/
public interface RecommendationsService {

    public Page<Recommendations> listById(int userId);
}
