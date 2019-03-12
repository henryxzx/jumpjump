package pers.xqy.demo.service;

import com.github.pagehelper.Page;
import pers.xqy.demo.entity.GameCommunityPostingEvaluate;

import java.util.List;

/**
 * @program: demo
 * @description: 游戏社区帖子评论Service层
 * @author: henryxzx
 * @create: 2019-02-24 16:08
 **/
public interface GameCommunityPostingEvaluateService {
    /**
     * @Author henryxzx
     * @Description //TODO 根据游戏社区帖子Id列出所有评论信息
     * @Date 16:26 2019-02-24
     * @Param [gameCommunityPosting]
     * @return java.util.List<pers.xqy.demo.entity.GameCommunityPostingEvaluate>
     **/
    public Page<GameCommunityPostingEvaluate> listAllById(int gameCommunityPostingId);

    
    /**
     * @Author henryxzx
     * @Description //TODO 根据游戏社区帖子评论Id显示评论信息
     * @Date 16:27 2019-02-24
     * @Param [gameCommunityPostingEvaluateId]
     * @return pers.xqy.demo.entity.GameCommunityPostingEvaluate
     **/
    public GameCommunityPostingEvaluate findById(int gameCommunityPostingEvaluateId);

    
    /**
     * @Author henryxzx
     * @Description //TODO 插入评论
     * @Date 16:27 2019-02-24
     * @Param [gameCommunityPostingEvaluate]
     * @return java.lang.Integer
     **/
    public boolean insert(GameCommunityPostingEvaluate gameCommunityPostingEvaluate);

    
    /**
     * @Author henryxzx
     * @Description //TODO 根据评论Id删除评论
     * @Date 16:27 2019-02-24
     * @Param [gameCommunityPostingEvaluateId]
     * @return java.lang.Integer
     **/
    public boolean delete(int gameCommunityPostingEvaluateId);

    
    /**
     * @Author henryxzx
     * @Description //TODO 根据用户Id列出所有评论信息
     * @Date 16:27 2019-02-24
     * @Param [uId]
     * @return java.util.List<pers.xqy.demo.entity.GameCommunityPostingEvaluate>
     **/
    public List<GameCommunityPostingEvaluate> listByUId(int uId);

}
