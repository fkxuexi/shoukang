package top.fkxuexi.modules.activity.dao;

import org.apache.ibatis.annotations.Param;
import common.entity.ActivityRule;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @version v1.0.0
 * @Author fkxuexi
 * @Date 2018/2/26 22:13
 * @QQ群 570980002
 * @Description :
 */
@Repository
public interface ActivityRuleDAO {
    /** 通过id获取活动规则
     * @param id 活动规则的id
     * @return 返回对应的id的活动规则
     */
    ActivityRule get(@Param("id") Integer id);


    /** 通过设置的条件获取活动规则列表
     * @param activityRule 依据points .level .consume_money 来查询活动规则
     * @return 返回对应的活动规则列表
     */
    List<ActivityRule> list(ActivityRule activityRule);

    /** 插入活动规则
     * @param activityRule 插入活动规则
     * @return 返回是否插入成功 1 为成功
     */
    int insert(ActivityRule activityRule);

    /**
     * 更新活动的规则
     * @param activityRule
     * @return 返回是否更新成功,如果返回值为1 则成功
     */
    int update(ActivityRule activityRule);

    /** 通过id删除活动规则 ,删除的时候要查询是否存在活动有引用的在。要慎用
     * @param id
     * @return 返回是否插入成功 1 为成功
     */
    int delete(@Param("id")Integer id);
}
