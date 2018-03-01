package top.fkxuexi.modules.activity.dao;

import common.entity.ActivitySetting;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivitySettingDAO {

	/**
	 * 通过id获取活动的设置
	 * @param id
	 * @return 返回获得设置
	 */
	ActivitySetting get(@Param("id") Integer id);

    /**
     * 插入活动设置
     * @param ActivitySetting
     * @return 成功返回1
     */
	int insert(ActivitySetting ActivitySetting);

    /**
     * 依据设置的条件,获取活动设置列表
     * @param ActivitySetting
     * @return 返回对应条件的活动设置列表
     */
	List<ActivitySetting> list(ActivitySetting ActivitySetting);

    /**
     * 更新活动设置
     * @param ActivitySetting
     * @return 返回1 则成功
     */
	int update(ActivitySetting ActivitySetting);

    /**
     * 通过id删除活动设置,如果有活动引用则不可删除
     * @param id
     * @return 返回 1 则成功
     */
	int delete(@Param("id") Integer id);


}

