package pers.xqy.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pers.xqy.demo.dao.AdminDao;
import pers.xqy.demo.entity.Admin;
import pers.xqy.demo.entity.RotationChart;
import pers.xqy.demo.service.AdminService;

import java.util.List;

/**
 * @program: demo
 * @description: 管理员Service层Impl
 * @author: henryxzx
 * @create: 2019-03-13 20:14
 **/
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminDao adminDao;

    @Transactional
    @Override
    public List<Admin> listAll() {
        return adminDao.listAll();
    }

    @Transactional
    @Override
    public List<RotationChart> listAllRotationChart() {
        return adminDao.listAllRotationChart();
    }

    @Transactional
    @Override
    public boolean insertRotationChart(RotationChart rotationChart) {
        if (rotationChart.getUrl() != null) {
            try {
                int effectedNum = adminDao.insertRotationChart(rotationChart);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("插入轮播图失败");
                }
            } catch (Exception e) {
                throw new RuntimeException("插入轮播图失败" + e.getMessage());
            }
        }else{
            throw new RuntimeException("轮播图信息不能为空");
        }
    }

    @Transactional
    @Override
    public boolean deleteRotationChart(int id) {
        if (id > 0) {
            try {
                int effectedNum = adminDao.deleteRotationChart(id);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("删除轮播图失败");
                }
            } catch (Exception e) {
                throw new RuntimeException("删除轮播图失败" + e.getMessage());
            }
        }else{
            throw new RuntimeException("Id不能为空");
        }
    }
}
