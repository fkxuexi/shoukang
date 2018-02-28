package top.fkxuexi.activity.dao;

import activity.top.fkxuexi.activity.entity.ActivityDetail;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ActivityDetailDAO {

	/**
	 * 通过id获取活动
	 * @param id
	 * @return 返回活动
	 */
	ActivityDetail get(@Param("id") Integer id);


	/**
	 * 插入新的活动
	 * @param ActivityDetail
	 * @return 返回1则成功
	 */
	int insert(ActivityDetail ActivityDetail);

	/**
	 * 依据设置的条件获取活动列表
	 * @param ActivityDetail
	 * @return 返回活动列表
	 */
	List<ActivityDetail> list(ActivityDetail ActivityDetail);

	/**
	 * 更新活动
	 * @param ActivityDetail
	 * @return 如果返回1 则成功
	 */
	int update(ActivityDetail ActivityDetail);

	/**
	 *  通过id删除活动
	 * @param id
	 * @return 返回1则成功
	 */
	int delete(@Param("id") Integer id);


}

