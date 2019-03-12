package pers.xqy.demo.entity;

import java.sql.Timestamp;

/**
 * @program: demo
 * @description: 游戏推荐引擎用户
 * @author: henryxzx
 * @create: 2019-03-06 12:53
 **/
public class Users {
    //用户Id
    private String Id;
    //用户喜好关键词列表 json
    private String pref_list;
    //最后登陆时间
    private Timestamp latestLogTime;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getPref_list() {
        return pref_list;
    }

    public void setPref_list(String pref_list) {
        this.pref_list = pref_list;
    }

    public Timestamp getLatestLogTime() {
        return latestLogTime;
    }

    public void setLatestLogTime(Timestamp latestLogTime) {
        this.latestLogTime = latestLogTime;
    }
}
