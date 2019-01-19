package pers.xqy.demo.entity;

import java.sql.Date;

public class Game {
    //主键 游戏Id
    private Integer gameId;
    //游戏名称
    private String gameName;
    //游戏评测数目
    private Integer gameCommentsNum;
    //游戏详情
    private String gameContent;
    //游戏类型
    private Integer gameTypeId;
    //游戏发行商
    private Integer gamePublisherId;
    //游戏发行时间
    private Date gamePublishTime;
    //游戏评分
    private Integer gameScore;
    //游戏封面
    private String gameImage;

    public Date getGamePublishTime() {
        return gamePublishTime;
    }

    public void setGamePublishTime(Date gamePublishTime) {
        this.gamePublishTime = gamePublishTime;
    }

    public String getGameImage() {
        return gameImage;
    }

    public void setGameImage(String gameImage) {
        this.gameImage = gameImage;
    }

    public Integer getGameId() {
        return gameId;
    }

    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public Integer getGameCommentsNum() {
        return gameCommentsNum;
    }

    public void setGameCommentsNum(Integer gameCommentsNum) {
        this.gameCommentsNum = gameCommentsNum;
    }

    public String getGameContent() {
        return gameContent;
    }

    public void setGameContent(String gameContent) {
        this.gameContent = gameContent;
    }

    public Integer getGameTypeId() {
        return gameTypeId;
    }

    public void setGameTypeId(Integer gameTypeId) {
        this.gameTypeId = gameTypeId;
    }

    public Integer getGamePublisherId() {
        return gamePublisherId;
    }

    public void setGamePublisherId(Integer gamePublisherId) {
        this.gamePublisherId = gamePublisherId;
    }

    public Integer getGameScore() {
        return gameScore;
    }

    public void setGameScore(Integer gameScore) {
        this.gameScore = gameScore;
    }
}
