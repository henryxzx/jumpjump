package pers.xqy.demo.dao;

import com.github.pagehelper.Page;
import pers.xqy.demo.entity.GameCommunityPosting;

/**
 * @program: java_project
 * @description: 游戏社区帖子Dao层
 * @author: henryxzx
 * @create: 2019-02-10 16:49
 **/
public interface GameCommunityPostingDao {
    /**
     * @Author henryxzx
     * @Description //TODO 列出所有游戏帖子
     * @Date 19:09 2019-02-18
     * @Param [gameCommuntiyId]
     * @return java.util.List<pers.xqy.demo.entity.GameCommunityPosting>
     **/
    public Page<GameCommunityPosting> listAllById(int gameCommuntiyId);

    /**
     * @Author henryxzx
     * @Description //TODO 添加新的帖子
     * @Date 19:19 2019-02-18
     * @Param [gameCommunityPosting]
     * @return java.lang.Integer
     **/
    public Integer insert(GameCommunityPosting gameCommunityPostingId);

    /**
     * @Author henryxzx
     * @Description //TODO 根据游戏社区帖子Id删帖
     * @Date 19:25 2019-02-18
     * @Param [gameCommunityPostingId]
     * @return java.lang.Integer
     **/
    public Integer delete(int gameCommunityPostingId);

    /**
     * @Author henryxzx
     * @Description //TODO 评论数+1
     * @Date 16:51 2019-02-24
     * @Param [gameCommunityPostingId]
     * @return java.lang.Integer
     **/
    public Integer addEvaluateNum(int gameCommunityPostingId);

    /**
     * @Author henryxzx
     * @Description //TODO 评论数-1
     * @Date 16:51 2019-02-24
     * @Param [gameCommunityPostingId]
     * @return java.lang.Integer
     **/
    public Integer reduceEvaluateNum(int gameCommunityPostingId);

    /**
     * @Author henryxzx
     * @Description //TODO 根据社区帖子Id返回帖子信息
     * @Date 16:53 2019-02-24
     * @Param [gameCommunityPostingId]
     * @return pers.xqy.demo.entity.GameCommunityPosting
     **/
    public GameCommunityPosting findById(int gameCommunityPostingId);

}
