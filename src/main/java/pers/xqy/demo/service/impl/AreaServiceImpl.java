package pers.xqy.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pers.xqy.demo.dao.AreaDao;
import pers.xqy.demo.entity.Area;
import pers.xqy.demo.service.AreaService;

import java.util.Date;
import java.util.List;

@Service
public class AreaServiceImpl implements AreaService {

    @Autowired
    private AreaDao areaDao;

    @Override
    public List<Area> getAreaList() {
        return areaDao.queryArea();
    }

    @Override
    public Area getAreaById(int areaId) {
        return areaDao.queryAreaById(areaId);
    }
    @Transactional
    @Override
    public boolean addArea(Area area) {
        if (area.getAreaName() != null && !"".equals(area.getAreaName())) {
            area.setCreateTime(new Date());
            area.setLastEditTime(new Date());
            try {
                int effectedNum = areaDao.insertArea(area);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("插入信息失败");
                }
            } catch (Exception e) {
                throw new RuntimeException("插入信息失败" + e.getMessage());
            }
        }else{
            throw new RuntimeException("区域信息不能为空");
        }
    }
    @Transactional
    @Override
    public boolean modifyArea(Area area) {
        if (area.getAreaId() != null && area.getAreaId() > 0) {
            area.setLastEditTime(new Date());
            try {
                int effectedNum = areaDao.updateArea(area);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("更新信息失败");
                }
            } catch (Exception e) {
                throw new RuntimeException("更新信息失败" + e.getMessage());
            }
        }else{
            throw new RuntimeException("区域信息不能为空");
        }
    }

    @Transactional
    @Override
    public boolean deleteArea(int areaId) {
        if (areaId > 0) {
            try {
                int effectedNum = areaDao.deleteArea(areaId);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("删除信息失败");
                }
            } catch (Exception e) {
                throw new RuntimeException("删除信息失败" + e.getMessage());
            }
        }else{
            throw new RuntimeException("Id不能为空");
        }
    }
}
