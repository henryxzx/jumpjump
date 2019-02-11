package pers.xqy.demo.entity;

/**
 * @program: java_project
 * @description: 游戏发行商
 * @author: henryxzx
 * @create: 2019-01-19 16:55
 **/
public class GamePublisher {
    //游戏发行商Id
    private Integer gamePublisherId;
    //游戏发行商名称
    private String gamePublisherName;
    //游戏发行商图片
    private String gamePublisherImage;
    //游戏发行商发行游戏数量
    private Integer gamePublisherNum;

    public Integer getGamePublisherId() {
        return gamePublisherId;
    }

    public void setGamePublisherId(Integer gamePublisherId) {
        this.gamePublisherId = gamePublisherId;
    }

    public String getGamePublisherName() {
        return gamePublisherName;
    }

    public void setGamePublisherName(String gamePublisherName) {
        this.gamePublisherName = gamePublisherName;
    }

    public String getGamePublisherImage() {
        return gamePublisherImage;
    }

    public void setGamePublisherImage(String gamePublisherImage) {
        this.gamePublisherImage = gamePublisherImage;
    }

    public Integer getGamePublisherNum() {
        return gamePublisherNum;
    }

    public void setGamePublisherNum(Integer gamePublisherNum) {
        this.gamePublisherNum = gamePublisherNum;
    }
}
