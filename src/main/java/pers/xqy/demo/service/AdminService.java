package pers.xqy.demo.service;

import pers.xqy.demo.entity.Admin;
import pers.xqy.demo.entity.RotationChart;

import java.util.List;

/**
 * @program: demo
 * @description: 管理员Service层
 * @author: henryxzx
 * @create: 2019-03-13 20:13
 **/
public interface AdminService {
    public List<Admin> listAll();

    public List<RotationChart> listAllRotationChart();

    public boolean insertRotationChart(RotationChart rotationChart);

    public boolean deleteRotationChart(int id);
}
