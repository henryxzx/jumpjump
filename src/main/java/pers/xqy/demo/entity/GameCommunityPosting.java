package pers.xqy.demo.entity;

import java.sql.Date;

/**
 * @program: java_project
 * @description: 游戏社区帖子
 * @author: henryxzx
 * @create: 2019-02-09 17:35
 **/
public class GameCommunityPosting {
    //游戏社区帖子Id
    private Integer gameCommunityPostingId;
    //游戏社区帖子标题
    private String gameCommunityPostingTitle;
    //游戏社区帖子内容
    private String gameCommunityPostingContent;
    //游戏社区帖子发帖人Id
    private Integer gameCommunityPostingUid;
    //游戏社区帖子发帖人
    private User user;
    //游戏社区帖子发贴时间
    private Date gameCommunityPostingTime;
    //游戏社区帖子对应游戏社区Id
    private Integer gameCommuntiyPostingGameCommuntiyId;
    //游戏社区帖子评论数
    private Integer gameCommunityPostingEvaluateNum;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getGameCommunityPostingEvaluateNum() {
        return gameCommunityPostingEvaluateNum;
    }

    public void setGameCommunityPostingEvaluateNum(Integer gameCommunityPostingEvaluateNum) {
        this.gameCommunityPostingEvaluateNum = gameCommunityPostingEvaluateNum;
    }

    public Integer getGameCommunityPostingId() {
        return gameCommunityPostingId;
    }

    public void setGameCommunityPostingId(Integer gameCommunityPostingId) {
        this.gameCommunityPostingId = gameCommunityPostingId;
    }

    public String getGameCommunityPostingTitle() {
        return gameCommunityPostingTitle;
    }

    public void setGameCommunityPostingTitle(String gameCommunityPostingTitle) {
        this.gameCommunityPostingTitle = gameCommunityPostingTitle;
    }

    public String getGameCommunityPostingContent() {
        return gameCommunityPostingContent;
    }

    public void setGameCommunityPostingContent(String gameCommunityPostingContent) {
        this.gameCommunityPostingContent = gameCommunityPostingContent;
    }

    public Integer getGameCommunityPostingUid() {
        return gameCommunityPostingUid;
    }

    public void setGameCommunityPostingUid(Integer gameCommunityPostingUid) {
        this.gameCommunityPostingUid = gameCommunityPostingUid;
    }

    public Date getGameCommunityPostingTime() {
        return gameCommunityPostingTime;
    }

    public void setGameCommunityPostingTime(Date gameCommunityPostingTime) {
        this.gameCommunityPostingTime = gameCommunityPostingTime;
    }

    public Integer getGameCommuntiyPostingGameCommuntiyId() {
        return gameCommuntiyPostingGameCommuntiyId;
    }

    public void setGameCommuntiyPostingGameCommuntiyId(Integer gameCommuntiyPostingGameCommuntiyId) {
        this.gameCommuntiyPostingGameCommuntiyId = gameCommuntiyPostingGameCommuntiyId;
    }
}
