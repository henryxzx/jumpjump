package pers.xqy.demo.dao;

import pers.xqy.demo.entity.Admin;

import java.util.List;

/**
 * @program: java_project
 * @description: 管理员Dao层
 * @author: henryxzx
 * @create: 2019-01-18 14:38
 **/
public interface AdminDao {
    /**
     * @Author henryxzx
     * @Description //TODO 列出所有管理员信息
     * @Date 15:18 2019-01-19
     * @Param []
     * @return java.util.List<pers.xqy.demo.entity.Admin>
     **/
    public List<Admin> listAll();


}
