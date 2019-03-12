package pers.xqy.demo.entity;

import java.sql.Timestamp;

/**
 * @program: demo
 * @description: 游戏推荐引擎游戏推荐结果
 * @author: henryxzx
 * @create: 2019-03-06 12:52
 **/
public class Recommendations {
    //推荐信息id
    private Integer id;
    //推荐用户id
    private Integer userId;
    //推荐游戏Id
    private Integer newsId;
    //推荐时间
    private Timestamp deriveTime;
    //用户反馈 0 未查看 1 查看
    private Integer feedBack;
    //0:协同过滤，1:基于内容的推荐，2：热点新闻推荐
    private Integer deriveAlgorithm;

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

    public Timestamp getDeriveTime() {
        return deriveTime;
    }

    public void setDeriveTime(Timestamp deriveTime) {
        this.deriveTime = deriveTime;
    }

    public Integer getFeedBack() {
        return feedBack;
    }

    public void setFeedBack(Integer feedBack) {
        this.feedBack = feedBack;
    }

    public Integer getDeriveAlgorithm() {
        return deriveAlgorithm;
    }

    public void setDeriveAlgorithm(Integer deriveAlgorithm) {
        this.deriveAlgorithm = deriveAlgorithm;
    }
}
