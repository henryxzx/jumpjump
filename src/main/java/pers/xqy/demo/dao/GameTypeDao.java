package pers.xqy.demo.dao;

import pers.xqy.demo.entity.GameType;

import java.util.List;

/**
 * @program: java_project
 * @description: 游戏类型Dao层
 * @author: henryxzx
 * @create: 2019-01-19 17:05
 **/
public interface GameTypeDao {

    /**
     * @Author henryxzx
     * @Description //TODO 列出所有游戏类型的信息
     * @Date 20:00 2019-01-19
     * @Param []
     * @return java.util.List<pers.xqy.demo.entity.GameType>
     **/
    public List<GameType> listAll();


    /**
     * @Author henryxzx
     * @Description //TODO 根据Id返回游戏类型的信息
     * @Date 20:02 2019-01-19
            * @Param [gameTypeId]
            * @return pers.xqy.demo.entity.GameType
     **/
    public GameType findById(int gameTypeId);

    /**
     * @Author henryxzx
     * @Description //TODO 根据游戏名称返回游戏类型信息
     * @Date 22:34 2019-02-10
     * @Param [gameType]
     * @return java.lang.String
     **/
    public GameType findIdByName(String gameTypeName);
}
