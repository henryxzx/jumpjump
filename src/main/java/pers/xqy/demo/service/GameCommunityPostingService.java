package pers.xqy.demo.service;

import pers.xqy.demo.entity.GameCommunityPosting;

import java.util.List;

/**
 * @program: demo
 * @description: 游戏社区帖子Service层
 * @author: henryxzx
 * @create: 2019-02-24 15:16
 **/
public interface GameCommunityPostingService {

    /**
     * @Author henryxzx
     * @Description //TODO 根据游戏社区Id列出所有帖子
     * @Date 16:02 2019-02-24
     * @Param [gameCommuntiyId]
     * @return java.util.List<pers.xqy.demo.entity.GameCommunityPosting>
     **/
    public List<GameCommunityPosting> listAllById(int gameCommuntiyId);

    /**
     * @Author henryxzx
     * @Description //TODO 插入新的帖子
     * @Date 16:03 2019-02-24
     * @Param [gameCommunityPosting]
     * @return boolean
     **/
    public boolean insert(GameCommunityPosting gameCommunityPosting);

    /**
     * @Author henryxzx
     * @Description //TODO 根据帖子Id删除帖子
     * @Date 16:04 2019-02-24
     * @Param [gameCommunityPostingId]
     * @return boolean
     **/
    public boolean delete(int gameCommunityPostingId);

    
    /**
     * @Author henryxzx
     * @Description //TODO 评论数+1
     * @Date 16:04 2019-02-24
     * @Param [gameCommunityPostingId]
     * @return boolean
     **/
    public boolean addEvaluateNum(int gameCommunityPostingId);

    
    /**
     * @Author henryxzx
     * @Description //TODO 评论数-1
     * @Date 16:04 2019-02-24
     * @Param [gameCommunityPostingId]
     * @return boolean
     **/
    public boolean reduceEvaluateNum(int gameCommunityPostingId);

    /**
     * @Author henryxzx
     * @Description //TODO 根据游戏帖子Id返回帖子信息
     * @Date 16:06 2019-02-24
     * @Param [gameCommunityPostingId]
     * @return pers.xqy.demo.entity.GameCommunityPosting
     **/
    public GameCommunityPosting findById(int gameCommunityPostingId);
}
