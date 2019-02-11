package pers.xqy.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pers.xqy.demo.dao.RecommendDao;
import pers.xqy.demo.entity.Recommend;
import pers.xqy.demo.service.RecommendService;

import java.util.List;

/**
 * @program: demo
 * @description: 推荐信息Service层Impl
 * @author: henryxzx
 * @create: 2019-02-11 13:06
 **/
@Service
public class RecommendServiceImpl implements RecommendService {
    @Autowired
    private RecommendDao recommendDao;

    @Transactional
    @Override
    public List<Recommend> listAllRecommend() {
        return recommendDao.listAllRecommend();
    }

    @Transactional
    @Override
    public boolean updateStatus(int recommendId) {
        if (recommendId > 0) {
            try {
                int effectedNum = recommendDao.updateStatus(recommendId);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("更新信息失败");
                }
            } catch (Exception e) {
                throw new RuntimeException("更新信息失败" + e.getMessage());
            }
        }else{
            throw new RuntimeException("状态信息不能为空");
        }
    }

    @Transactional
    @Override
    public boolean insert(Recommend recommend) {
        if (recommend.getRecommendContent() != null) {
            try {
                int effectedNum = recommendDao.insert(recommend);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("插入信息失败");
                }
            } catch (Exception e) {
                throw new RuntimeException("插入信息失败" + e.getMessage());
            }
        }else{
            throw new RuntimeException("推荐信息不能为空");
        }

    }

    @Override
    public boolean delete(int recommendId) {
        if (recommendId > 0) {
            try {
                int effectedNum = recommendDao.delete(recommendId);
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
