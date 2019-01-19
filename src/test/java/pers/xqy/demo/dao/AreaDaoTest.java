package pers.xqy.demo.dao;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pers.xqy.demo.entity.Area;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AreaDaoTest {
    @Autowired
    private AreaDao areaDao;

    @Test
    public void testAQueryArea() {
        List<Area> areaList = areaDao.queryArea();
        assertEquals(2, areaList.size());
    }

    @Test
    public void testBQueryAreaById() {
        Area area = areaDao.queryAreaById(1);
        assertEquals("东苑", area.getAreaName());

    }

    @Test
    @Ignore
    public void testCInsertArea() {
        Area area = new Area();
        area.setAreaName("南苑");
        area.setPriority(1);
        int effectedNum = areaDao.insertArea(area);
        assertEquals(1, effectedNum);
    }

    @Test
    @Ignore
    public void updateArea() {
        Area area = new Area();
        area.setAreaName("西园");
        area.setAreaId(3);
        area.setLastEditTime(new Date());
        int effectedNum = areaDao.updateArea(area);
        assertEquals(1, effectedNum);
    }

    @Test
//    @Ignore
    public void deleteArea() {
        int effectedNum = areaDao.deleteArea(3);
        assertEquals(1, effectedNum);
    }
}