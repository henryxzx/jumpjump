package pers.xqy.demo.service;

import com.github.pagehelper.Page;
import pers.xqy.demo.entity.Comments;

/**
 * @program: demo
 * @description: 游戏评测的Service层
 * @author: henryxzx
 * @create: 2019-02-11 11:04
 **/
public interface CommentsService {

    /**
     * @Author henryxzx
     * @Description //TODO 根据游戏Id列出评论
     * @Date 13:55 2019-01-19
     * @Param [gameId]
     * @return java.util.List<pers.xqy.demo.entity.Comments>
     **/
    public Page<Comments> listByGameId(int gameId);


    /**
     * @Author henryxzx
     * @Description //TODO 根据用户Id找到评论
     * @Date 14:12 2019-01-19
     * @Param [uId]
     * @return java.util.List<pers.xqy.demo.entity.Comments>
     **/
    public Page<Comments> findByUId(int uId);


    /**
     * @Author henryxzx
     * @Description //TODO 插入评论
     * @Date 14:14 2019-01-19
     * @Param [comments]
     * @return java.lang
     **/
    public boolean insert(Comments comments);

    /**
     * @Author henryxzx
     * @Description //TODO 根据评论Id删除评论
     * @Date 14:22 2019-01-19
     * @Param [commentsId]
     * @return java.lang
     **/
    public boolean delete(int commentsId);


}
