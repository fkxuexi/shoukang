package top.fkxuexi.modules.activity.dao;

import common.entity.ActivityPrize;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityPrizeDAO {

    /**
     *  通过id获取活动奖品
     * @param id 活动奖品的id
     * @return 返回活动的奖品
     */
    ActivityPrize get(@Param("id") Integer id);

    /**
     * 插入活动的奖品
     * @param ActivityPrize
     * @return 返回是否插入成功,如果 返回值为1 则插入成功
     */
    int insert(ActivityPrize ActivityPrize);

    /**
     * 通过设置的条件返回活动奖品的列表
     * @param ActivityPrize
     * @return 返回对应条件的活动的奖品的列表
     */
    List<ActivityPrize> list(ActivityPrize ActivityPrize);

    /**
     * 更新活动的奖品
     * @param ActivityPrize
     * @return 返回是否更新成功,如果 返回1则更新成功
     */
    int update(ActivityPrize ActivityPrize);

    /**
     * 删除 活动的奖品,删除之前必须要看是否有活动引用,如果有则强制不可删除
     * @param id
     * @return
     */
    int delete(@Param("id") Integer id);


}

