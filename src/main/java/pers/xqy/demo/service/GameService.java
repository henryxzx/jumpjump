package pers.xqy.demo.service;

import com.github.pagehelper.Page;
import pers.xqy.demo.entity.Game;

public interface GameService {
    //主页的信息分页列出
    public Page<Game> findAllLimit();
    //查找游戏名称
    public Game findByName(String gameName);
    //根据游戏Id查找游戏
    public Game findById(int gameId);
    //根据类型显示游戏
    public Page<Game> listByType(String gameType);
    //根据发行商显示游戏
//    public Page<Game> listByPublisher(String gamePublisher);
    //根据发行时间显示游戏
    public Page<Game> listByPublishTime();
    //根据游戏分数显示游戏
    public Page<Game> listByGameScore();
    //根据游戏Id添加评论+1
    public boolean addCommentsNum(int gameId);
    //根据游戏Id减少评论-1
    public boolean reduceCommentsNum(int gameId);
    //根据热度列出游戏信息
    public Page<Game> listByHot();
    //插入新遊戲
    public boolean insert(Game game);
    //删除游戏
    public boolean delete(int gameId);
    //修改游戏信息
    public boolean update(Game game);


}
