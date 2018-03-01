package top.fkxuexi.modules.activity.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import common.entity.ActivityDetail;
import common.entity.ActivityPrize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.fkxuexi.modules.activity.dao.ActivityPrizeDAO;

import java.util.List;

/**
 * @version v1.0.0
 * @Author fkxuexi
 * @Date 2018/3/1 21:49
 * @QQ群 570980002
 * @Description :
 */
@Service
@Transactional
public class ActivityPrizeService {

    @Autowired
    private ActivityPrizeDAO prizeDAO;
    @Autowired
    private ActivityDetailService detailService;


    /**
     * 获取活动奖品
     *
     * @param id
     * @return
     */
    @Transactional(readOnly = true)
    public ActivityPrize get(Integer id) {
        return prizeDAO.get(id);
    }

    /**
     * 获取活动奖品列表
     *
     * @param prize
     * @return
     */
    @Transactional(readOnly = true)
    public List<ActivityPrize> list(ActivityPrize prize) {
        return prizeDAO.list(prize);
    }

    /**
     * 获取分页数据
     *
     * @param index 当前页码
     * @param size
     * @param prize
     * @return
     */
    @Transactional(readOnly = true)
    public PageInfo<ActivityPrize> page(Integer index, Integer size, ActivityPrize prize) {
        PageHelper.startPage(index, size);
        List<ActivityPrize> list = prizeDAO.list(prize);
        PageInfo<ActivityPrize> page = new PageInfo<ActivityPrize>(list);
        return page;
    }

    /**
     * 插入活动奖品
     *
     * @param prize
     * @return
     */
    public boolean insert(ActivityPrize prize) {
        return prizeDAO.insert(prize) == 1;
    }

    public boolean delete(Integer id) {
        ActivityDetail detail = new ActivityDetail();
        detail.setActivityPrizeId(id);
        if (detailService.isQuote(detail)){
            return false;
        }
        return prizeDAO.delete(id) == 1;
    }


}
