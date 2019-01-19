package pers.xqy.demo.dao;

import pers.xqy.demo.entity.Comments;

import java.util.List;

/**
 * @program: java_project
 * @description: 评论Dao层
 * @author: henryxzx
 * @create: 2019-01-18 14:39
 **/
public interface CommentsDao {

    /**
     * @Author henryxzx
     * @Description //TODO 根据游戏Id列出评论
     * @Date 13:55 2019-01-19
     * @Param [gameId]
     * @return java.util.List<pers.xqy.demo.entity.Comments>
     **/
    public List<Comments> listByGameId(int gameId);


    /**
     * @Author henryxzx
     * @Description //TODO 根据用户Id找到评论
     * @Date 14:12 2019-01-19
     * @Param [uId]
     * @return java.util.List<pers.xqy.demo.entity.Comments>
     **/
    public List<Comments> findByUId(int uId);


    /**
     * @Author henryxzx
     * @Description //TODO 插入评论
     * @Date 14:14 2019-01-19
     * @Param [comments]
     * @return java.lang.Integer
     **/
    public Integer insert(Comments comments);

    /**
     * @Author henryxzx
     * @Description //TODO 根据评论Id删除评论
     * @Date 14:22 2019-01-19
     * @Param [commentsId]
     * @return java.lang.Integer
     **/
    public Integer delete(int commentsId);


}
