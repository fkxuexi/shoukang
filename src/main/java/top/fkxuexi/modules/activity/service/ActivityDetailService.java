package top.fkxuexi.modules.activity.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import common.entity.ActivityDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.fkxuexi.modules.activity.dao.ActivityDetailDAO;

import java.util.List;

/**
 * @version v1.0.0
 * @Author fkxuexi
 * @Date 2018/3/1 21:10
 * @QQ群 570980002
 * @Description :
 */

@Service
@Transactional
public class ActivityDetailService {

    @Autowired
    private ActivityDetailDAO detailDAO;

    /**
     * 依据条件查询,是否引用有 settind的id rule的id  prize的id
     * @param detail
     * @return
     */
    @Transactional(readOnly = true)
    public boolean isQuote(ActivityDetail detail){
        List<ActivityDetail> list = detailDAO.isQuote(detail);
        return list != null && list.size() >0;
    }

    /** 获取活动详情
     * @param id
     * @return
     */
    @Transactional(readOnly = true)
    public ActivityDetail get(Integer id){
        return detailDAO.get(id);
    }

    /**
     * 获取活动详情
     * @param detail
     * @return
     */
    @Transactional(readOnly = true)
    public List<ActivityDetail> list(ActivityDetail detail){
        return detailDAO.list(detail);
    }

    /**
     * 获取活动的分页数据
     * @param index
     * @param size
     * @param detail
     * @return
     */
    @Transactional(readOnly = true)
    public PageInfo<ActivityDetail> page(Integer index,Integer size,ActivityDetail detail){
        PageHelper.startPage(index,size);
        List<ActivityDetail> list = detailDAO.list(detail);
        PageInfo<ActivityDetail> page = new PageInfo<ActivityDetail>(list);
        return page;
    }

    /**
     * 插入活动详情
     * @param detail
     * @return
     */
    public boolean insert(ActivityDetail detail){
        return detailDAO.insert(detail) == 1;
    }

    /**
     * 更新活动详情
     * @param detail
     * @return
     */
    public boolean update(ActivityDetail detail){
        return detailDAO.update(detail) == 1;
    }

    /**
     * 删除活动详情
     * @param id
     * @return
     */
    public boolean delete(Integer id){
        return detailDAO.delete(id) == 1;
    }
}
