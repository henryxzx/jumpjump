package pers.xqy.demo.entity;

/**
 * @program: java_project
 * @description: 用户关注社区
 * @author: henryxzx
 * @create: 2019-02-09 19:15
 **/
public class UserFocus {
    //关注Id
    private Integer focusId;
    //用户Id
    private Integer userId;
    //被关注的社区Id
    private Integer gameCommunityId;

    public Integer getFocusId() {
        return focusId;
    }

    public void setFocusId(Integer focusId) {
        this.focusId = focusId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getGameCommunityId() {
        return gameCommunityId;
    }

    public void setGameCommunityId(Integer gameCommunityId) {
        this.gameCommunityId = gameCommunityId;
    }
}
