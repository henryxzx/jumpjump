package pers.xqy.demo.entity;

/**
 * @program: java_project
 * @description:
 * @author: henryxzx
 * @create: 2019-02-09 17:30
 **/
public class GameCommunity {
    //游戏社区Id
    private Integer gameCommunityId;
    //游戏社区对应游戏的Id
    private String gameId;
    //游戏社区图片
    private String gameCommunityImage;
    //游戏社区帖子数
    private Integer gameCommunityPostingNum;

    public Integer getGameCommunityPostingNum() {
        return gameCommunityPostingNum;
    }

    public void setGameCommunityPostingNum(Integer gameCommunityPostingNum) {
        this.gameCommunityPostingNum = gameCommunityPostingNum;
    }

    public Integer getGameCommunityId() {
        return gameCommunityId;
    }

    public void setGameCommunityId(Integer gameCommunityId) {
        this.gameCommunityId = gameCommunityId;
    }

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public String getGameCommunityImage() {
        return gameCommunityImage;
    }

    public void setGameCommunityImage(String gameCommunityImage) {
        this.gameCommunityImage = gameCommunityImage;
    }
}
