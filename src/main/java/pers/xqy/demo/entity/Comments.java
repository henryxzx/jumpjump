package pers.xqy.demo.entity;

import java.sql.Date;

public class Comments {
    //评论Id
    private Integer commentsId;
    //用户Id
    private Integer uId;
    //用户实体类
    private User user;
    //游戏Id
    private Integer gameId;
    //评论主体
    private String commentsContent;
    //评论时间
    private Date commentsTime;
    //是否推荐
    private Integer isRecommend;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getCommentsId() {
        return commentsId;
    }

    public void setCommentsId(Integer commentsId) {
        this.commentsId = commentsId;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public Integer getGameId() {
        return gameId;
    }

    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }

    public String getCommentsContent() {
        return commentsContent;
    }

    public void setCommentsContent(String commentsContent) {
        this.commentsContent = commentsContent;
    }

    public Date getCommentsTime() {
        return commentsTime;
    }

    public void setCommentsTime(Date commentTime) {
        this.commentsTime = commentTime;
    }

    public Integer getIsRecommend() {
        return isRecommend;
    }

    public void setIsRecommend(Integer isRecommend) {
        this.isRecommend = isRecommend;
    }
}
