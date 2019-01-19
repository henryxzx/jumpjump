package pers.xqy.demo.entity;

public class Recommend {
    //推荐Id
    private Integer recommendId;
    //游戏Id
    private Integer gameId;
    //用户Id
    private Integer userId;
    //推荐信息
    private String recommendContent;
    //推荐图片
    private String recommendImage;
    //审核状态 默认为0 审核未通过
    private Integer status;

    public Integer getRecommendId() {
        return recommendId;
    }

    public void setRecommendId(Integer recommendId) {
        this.recommendId = recommendId;
    }

    public Integer getGameId() {
        return gameId;
    }

    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getRecommendContent() {
        return recommendContent;
    }

    public void setRecommendContent(String recommendContent) {
        this.recommendContent = recommendContent;
    }

    public String getRecommendImage() {
        return recommendImage;
    }

    public void setRecommendImage(String recommendImage) {
        this.recommendImage = recommendImage;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
