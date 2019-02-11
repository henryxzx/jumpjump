package pers.xqy.demo.dao;

import pers.xqy.demo.entity.Recommend;

import java.util.List;

/**
 * @program: java_project
 * @description: 推荐信息Dao层
 * @author: henryxzx
 * @create: 2019-01-18 14:39
 **/
public interface RecommendDao {

    /**
     * @Author henryxzx
     * @Description //TODO 列出所有的推荐
     * @Date 14:52 2019-01-19
     * @Param []
     * @return java.util.List<pers.xqy.demo.entity.Recommend>
     **/
    public List<Recommend> listAllRecommend();


    /**
     * @Author henryxzx
     * @Description //TODO 更新审核状态
     * @Date 15:16 2019-01-19
     * @Param [recommendId]
     * @return java.lang.Integer
     **/
    public Integer updateStatus(int recommendId);

    /**
     * @Author henryxzx
     * @Description //TODO 添加新的推荐
     * @Date 13:28 2019-02-11
     * @Param [recommend]
     * @return java.lang.Integer
     **/
    public Integer insert(Recommend recommend);
    
    /**
     * @Author henryxzx
     * @Description //TODO 删除推荐
     * @Date 13:32 2019-02-11
     * @Param [recommendId]
     * @return java.lang.Integer
     **/
    public Integer delete(int recommendId);

}
