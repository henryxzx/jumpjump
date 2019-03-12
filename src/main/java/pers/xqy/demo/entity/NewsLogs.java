package pers.xqy.demo.entity;

import java.sql.Timestamp;

/**
 * @program: demo
 * @description: 游戏推荐引擎游戏记录
 * @author: henryxzx
 * @create: 2019-03-06 12:50
 **/
public class NewsLogs {
    //记录Id
    private Integer id;
    //用户Id
    private Integer userId;
    //游戏Id
    private Integer newsId;
    //查看时间(数据库设置自动更新)
    private Timestamp viewTime;
    //喜好程度0 查看 1 推荐
    private Integer preferDegree;

    private User user;

    private Game game;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getNewsId() {
        return newsId;
    }

    public void setNewsId(Integer newsId) {
        this.newsId = newsId;
    }

    public Timestamp getViewTime() {
        return viewTime;
    }

    public void setViewTime(Timestamp viewTime) {
        this.viewTime = viewTime;
    }

    public Integer getPreferDegree() {
        return preferDegree;
    }

    public void setPreferDegree(Integer preferDegree) {
        this.preferDegree = preferDegree;
    }
}
