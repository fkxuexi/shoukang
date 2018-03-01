package top.fkxuexi.modules.activity.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import common.entity.ActivityDetail;
import common.entity.ActivityRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.fkxuexi.modules.activity.dao.ActivityRuleDAO;

import java.util.List;

/**
 * @version v1.0.0
 * @Author fkxuexi
 * @Date 2018/3/1 20:31
 * @QQ群 570980002
 * @Description :
 */
@Service
@Transactional
public class ActivityRuleService {

    @Autowired
    private ActivityRuleDAO activityRuleDAO;
    @Autowired
    private ActivityDetailService detailService;


    /**
     * 通过id获取活动规则
     * @param id
     * @return 返回活动规则
     */
    @Transactional(readOnly = true)
    public ActivityRule get(Integer id) {
        return activityRuleDAO.get(id);
    }

    /**
     * 插入活动的规则
     * @param activityRule
     * @return 是否插入成功
     */
    public boolean insert(ActivityRule activityRule){
        return activityRuleDAO.insert(activityRule)==1;
    }

    /**
     *  通过设置的规则获取活动规则列表
     * @param activityRule
     * @return 返回对应的条件的活动规则列表
     */
    @Transactional(readOnly = true)
    public List<ActivityRule> list(ActivityRule activityRule){
        return activityRuleDAO.list(activityRule);
    }

    /**
     *  返回活动规则的分页
     * @param index 当前页码
     * @param size 页面大小
     * @param activityRule 条件
     * @return 返回pageInfo
     */
    @Transactional(readOnly = true)
    public PageInfo<ActivityRule> page(Integer index,Integer size,ActivityRule activityRule){
        PageHelper.startPage(index,size);
        List<ActivityRule> list = activityRuleDAO.list(activityRule);
        PageInfo<ActivityRule> page = new PageInfo<ActivityRule>(list);
        return page;
    }

    /**
     * 更新活动规则
     * @param activityRule
     * @return 返回是否更新成功
     */
    public boolean update(ActivityRule activityRule){
        return activityRuleDAO.update(activityRule) == 1;
    }

    /**
     *  删除活动规则,但需要检测是否被活动所引用
     * @param id
     * @return 返回是否删除成功
     */
    public boolean delete(Integer id){
        ActivityDetail detail = new ActivityDetail();
        detail.setActivityRuleId(id);
        if (detailService.isQuote(detail)){
            return false;
        }
        return activityRuleDAO.delete(id) == 1;
    }

}
