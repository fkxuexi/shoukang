package common.entity;

import java.math.BigDecimal;

/**
* @Auth 
* 活动细节
*/
public class ActivityDetail{
	
	private Integer id;  // 注释：活动细节 自增主键   
	private Integer activityRuleId;  // 注释：活动规则id
	private Integer activityPrizeId;  // 注释：活动奖品id
	private Integer activitySettingId;  // 注释：活动设置id   
	private BigDecimal budget;  // 注释：此次活动的预算   
	private BigDecimal usedBudget;  // 注释：此次活动已使用的预算   
	private Integer activityTimes;  // 注释：活动参加的次数   
	private Integer activityUseTimes;  // 注释：已经参加的活动次数   
	private Integer isOn;  // 注释：是否开启   
	private Integer state;  // 注释：活动状态 1 正常,2 达到预算   

	public void setId(Integer id){
		this.id = id;
	}
	
	public Integer getId(){
		return id;
	}
	
	public void setActivityRuleId(Integer activityRuleId){
		this.activityRuleId = activityRuleId;
	}
	
	public Integer getActivityRuleId(){
		return activityRuleId;
	}
	
	public void setActivityPrizeId(Integer activityPrizeId){
		this.activityPrizeId = activityPrizeId;
	}
	
	public Integer getActivityPrizeTypeId(){
		return activityPrizeId;
	}
	
	public void setActivitySettingId(Integer activitySettingId){
		this.activitySettingId = activitySettingId;
	}
	
	public Integer getActivitySettingId(){
		return activitySettingId;
	}
	
	public void setBudget(BigDecimal budget){
		this.budget = budget;
	}
	
	public BigDecimal getBudget(){
		return budget;
	}
	
	public void setUsedBudget(BigDecimal usedBudget){
		this.usedBudget = usedBudget;
	}
	
	public BigDecimal getUsedBudget(){
		return usedBudget;
	}
	
	public void setActivityTimes(Integer activityTimes){
		this.activityTimes = activityTimes;
	}
	
	public Integer getActivityTimes(){
		return activityTimes;
	}
	
	public void setActivityUseTimes(Integer activityUseTimes){
		this.activityUseTimes = activityUseTimes;
	}
	
	public Integer getActivityUseTimes(){
		return activityUseTimes;
	}
	
	public void setIsOn(Integer isOn){
		this.isOn = isOn;
	}
	
	public Integer getIsOn(){
		return isOn;
	}
	
	public void setState(Integer state){
		this.state = state;
	}
	
	public Integer getState(){
		return state;
	}
	

	@Override
	public String toString(){
		return "ActivityDetail["  	
				+ "id = " + id
				+ " , activityRuleId = " + activityRuleId
				+ " , activityPrizeTypeId = " + activityPrizeId
				+ " , activitySettingId = " + activitySettingId
				+ " , budget = " + budget
				+ " , usedBudget = " + usedBudget
				+ " , activityTimes = " + activityTimes
				+ " , activityUseTimes = " + activityUseTimes
				+ " , isOn = " + isOn
				+ " , state = " + state
				+ "]";
	}
}

