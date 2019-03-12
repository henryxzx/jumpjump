package pers.xqy.demo.service.impl;

import com.github.pagehelper.Page;
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

    /**
     * @Author henryxzx
     * @Description //TODO 列出所有推荐信息
     * @Date 14:08 2019-02-16
     * @Param []
     * @return java.util.List<pers.xqy.demo.entity.Recommend>
     **/
    @Transactional
    @Override
    public Page<Recommend> listAllRecommend() {
        return recommendDao.listAllRecommend();
    }

    
    /**
     * @Author henryxzx
     * @Description //TODO 更新推荐信息状态（审核功能）
     * @Date 14:08 2019-02-16
     * @Param [recommendId]
     * @return boolean
     **/
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

    /**
     * @Author henryxzx
     * @Description //TODO 插入新的推荐信息
     * @Date 14:09 2019-02-16
     * @Param [recommend]
     * @return boolean
     **/
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

    
    /**
     * @Author henryxzx
     * @Description //TODO 删除推荐信息（审核不通过）
     * @Date 14:10 2019-02-16
     * @Param [recommendId]
     * @return boolean
     **/
    @Transactional
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

    /**
     * @Author henryxzx
     * @Description //TODO 列出所有未审核的游戏推荐信息
     * @Date 16:34 2019-02-16
     * @Param []
     * @return java.util.List<pers.xqy.demo.entity.Recommend>
     **/
    @Transactional
    @Override
    public List<Recommend> listUnauditedRecommend() {
        return recommendDao.listUnauditedRecommend();
    }

}
