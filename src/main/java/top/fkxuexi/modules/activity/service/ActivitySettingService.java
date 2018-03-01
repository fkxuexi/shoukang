package top.fkxuexi.modules.activity.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import common.entity.ActivityDetail;
import common.entity.ActivitySetting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.fkxuexi.modules.activity.dao.ActivitySettingDAO;

import java.util.List;

/**
 * @version v1.0.0
 * @Author fkxuexi
 * @Date 2018/3/1 20:54
 * @QQ群 570980002
 * @Description :
 */
@Service
@Transactional
public class ActivitySettingService {

    @Autowired
    private ActivitySettingDAO settingDAO;
    @Autowired
    private ActivityDetailService detailService;

    /**
     * 通过id 获取活动设置
     * @param id
     * @return
     */
    @Transactional(readOnly = true)
    public ActivitySetting get(Integer id){
        return settingDAO.get(id);
    }

    /**
     * 依据条件返回活动设置列表
     * @param setting 条件
     * @return 返回活动设置列表
     */
    @Transactional(readOnly = true)
    public List<ActivitySetting> list(ActivitySetting setting){
        return settingDAO.list(setting);
    }

    /**
     * 通过条件获取分页
     * @param index 当前页码
     * @param size 页面大小
     * @param setting 条件
     * @return 返回分页
     */
    @Transactional(readOnly = true)
    public PageInfo<ActivitySetting> page(Integer index, Integer size, ActivitySetting setting){
        PageHelper.startPage(index,size);
        List<ActivitySetting> list = settingDAO.list(setting);
        PageInfo<ActivitySetting> page = new PageInfo<ActivitySetting>(list);
        return page;
    }

    /**
     *  更新活动设置列表
     * @param setting
     * @return
     */
    public boolean update(ActivitySetting setting){
        return  settingDAO.update(setting) == 1;
    }

    /**
     * 删除活动设置,如果有被活动详情引用则不可删除
     * @param id
     * @return
     */
    public boolean delete(Integer id){
        ActivityDetail detail = new ActivityDetail();
        detail.setActivitySettingId(id);
        if (detailService.isQuote(detail)){
            return false;
        }
        return settingDAO.delete(id) == 1;
    }

}
