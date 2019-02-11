package pers.xqy.demo.entity;

/**
 * @program: java_project
 * @description: 游戏类型
 * @author: henryxzx
 * @create: 2019-01-19 16:36
 **/
public class GameType {
    //游戏类型Id
    private Integer gameTypeId;
    //游戏类型名称
    private String gameTypeName;
    //游戏类型下游戏的个数
    private Integer gameTypeNum;

    public Integer getGameTypeId() {
        return gameTypeId;
    }

    public void setGameTypeId(Integer gameTypeId) {
        this.gameTypeId = gameTypeId;
    }

    public String getGameTypeName() {
        return gameTypeName;
    }

    public void setGameTypeName(String gameTypeName) {
        this.gameTypeName = gameTypeName;
    }

    public Integer getGameTypeNum() {
        return gameTypeNum;
    }

    public void setGameTypeNum(Integer gameTypeNum) {
        this.gameTypeNum = gameTypeNum;
    }
}
