package pers.xqy.demo.service;

import pers.xqy.demo.entity.Recommend;

import java.util.List;

/**
 * @program: demo
 * @description: 推荐信息Service层
 * @author: henryxzx
 * @create: 2019-02-11 13:03
 **/
public interface RecommendService {
    //列出所有推荐信息
    public List<Recommend> listAllRecommend();
    //更新推荐信息状态
    public boolean updateStatus(int recommendId);
    //添加推荐信息
    public boolean insert(Recommend recommend);
    //删除推荐信息
    public boolean delete(int recommendId);

}
