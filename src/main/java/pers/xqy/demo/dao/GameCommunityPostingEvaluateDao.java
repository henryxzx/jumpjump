package pers.xqy.demo.dao;

import com.github.pagehelper.Page;
import pers.xqy.demo.entity.GameCommunityPostingEvaluate;

/**
 * @program: java_project
 * @description: 游戏社区帖子评论Dao层
 * @author: henryxzx
 * @create: 2019-02-10 16:49
 **/
public interface GameCommunityPostingEvaluateDao {

    /**
     * @Author henryxzx
     * @Description //TODO 根据游戏帖子Id列出所有评论信息
     * @Date 16:52 2019-02-24
     * @Param [gameCommunityPostingId]
     * @return java.util.List<pers.xqy.demo.entity.GameCommunityPostingEvaluate>
     **/
    public Page<GameCommunityPostingEvaluate> listAllById(int gameCommunityPostingId);

    /**
     * @Author henryxzx
     * @Description //TODO 根据帖子评论Id返回评论信息
     * @Date 16:52 2019-02-24
     * @Param [gameCommunityPostingEvaluateId]
     * @return pers.xqy.demo.entity.GameCommunityPostingEvaluate
     **/
    public GameCommunityPostingEvaluate findById(int gameCommunityPostingEvaluateId);

    
    /**
     * @Author henryxzx
     * @Description //TODO 插入评论
     * @Date 16:53 2019-02-24
     * @Param [gameCommunityPostingEvaluate]
     * @return java.lang.Integer
     **/
    public Integer insert(GameCommunityPostingEvaluate gameCommunityPostingEvaluate);

    /**
     * @Author henryxzx
     * @Description //TODO 删除评论
     * @Date 16:53 2019-02-24
     * @Param [gameCommunityPostingEvaluateId]
     * @return java.lang.Integer
     **/
    public Integer delete(int gameCommunityPostingEvaluateId);

    /**
     * @Author henryxzx
     * @Description //TODO 根据用户Id返回评论信息
     * @Date 16:55 2019-02-24
     * @Param [uId]
     * @return java.util.List<pers.xqy.demo.entity.GameCommunityPostingEvaluate>
     **/
    public Page<GameCommunityPostingEvaluate> listByUId(int uId);


}
