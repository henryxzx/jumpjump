package pers.xqy.demo.entity;

import java.sql.Date;

/**
 * @program: java_project
 * @description: 游戏社区帖子回复评论
 * @author: henryxzx
 * @create: 2019-02-09 17:49
 **/
public class GameCommunityPostingEvaluate {
    //游戏社区帖子回复评论Id
    private Integer gameCommunityPostingEvaluateId;
    //游戏社区帖子回复评论主体
    private String gameCommunityPostingEvaluateContent;
    //游戏社区帖子回复评论人Id
    private Integer gameCommunityPostingEvaluateUid;
    //评论人
    private User user;
    //游戏社区帖子回复评论帖子Id
    private Integer gameCommunityPostingEvaluatePostingId;
    //游戏社区帖子回复评论时间
    private Date gameCommunityPostingEvaluateTime;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getGameCommunityPostingEvaluateId() {
        return gameCommunityPostingEvaluateId;
    }

    public void setGameCommunityPostingEvaluateId(Integer gameCommunityPostingEvaluateId) {
        this.gameCommunityPostingEvaluateId = gameCommunityPostingEvaluateId;
    }

    public String getGameCommunityPostingEvaluateConetent() {
        return gameCommunityPostingEvaluateContent;
    }

    public void setGameCommunityPostingEvaluateContent(String gameCommunityPostingEvaluateContent) {
        this.gameCommunityPostingEvaluateContent = gameCommunityPostingEvaluateContent;
    }

    public Integer getGameCommunityPostingEvaluateUid() {
        return gameCommunityPostingEvaluateUid;
    }

    public void setGameCommunityPostingEvaluateUid(Integer gameCommunityPostingEvaluateUid) {
        this.gameCommunityPostingEvaluateUid = gameCommunityPostingEvaluateUid;
    }

    public Integer getGameCommunityPostingEvaluatePostingId() {
        return gameCommunityPostingEvaluatePostingId;
    }

    public void setGameCommunityPostingEvaluatePostingId(Integer gameCommunityPostingEvaluatePostingId) {
        this.gameCommunityPostingEvaluatePostingId = gameCommunityPostingEvaluatePostingId;
    }

    public Date getGameCommunityPostingEvaluateTime() {
        return gameCommunityPostingEvaluateTime;
    }

    public void setGameCommunityPostingEvaluateTime(Date gameCommunityPostingEvaluateTime) {
        this.gameCommunityPostingEvaluateTime = gameCommunityPostingEvaluateTime;
    }
}
