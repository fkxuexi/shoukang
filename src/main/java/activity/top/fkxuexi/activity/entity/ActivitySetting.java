package activity.top.fkxuexi.activity.entity;


/**
* @Auth 
* 活动设置
*/
public class ActivitySetting{
	
	private Integer id;  // 注释：活动设置 自增主键   
	private String startTime;  // 注释：活动开始时间   
	private String endTime;  // 注释：活动结束时间   
	private Integer userCanTakeTimes;  // 注释：每人每次活动可参与的次数,值为0则默认无限参与   
	private Integer activityTimes;  // 注释：活动 进行的总次数,例如仅限前100名参加等限制   
	private Integer isForever;  // 注释：是否为永久   

	public void setId(Integer id){
		this.id = id;
	}
	
	public Integer getId(){
		return id;
	}
	
	public void setStartTime(String startTime){
		this.startTime = startTime;
	}
	
	public String getStartTime(){
		return startTime;
	}
	
	public void setEndTime(String endTime){
		this.endTime = endTime;
	}
	
	public String getEndTime(){
		return endTime;
	}
	
	public void setUserCanTakeTimes(Integer userCanTakeTimes){
		this.userCanTakeTimes = userCanTakeTimes;
	}
	
	public Integer getUserCanTakeTimes(){
		return userCanTakeTimes;
	}
	
	public void setActivityTimes(Integer activityTimes){
		this.activityTimes = activityTimes;
	}
	
	public Integer getActivityTimes(){
		return activityTimes;
	}
	
	public void setIsForever(Integer isForever){
		this.isForever = isForever;
	}
	
	public Integer getIsForever(){
		return isForever;
	}
	

	@Override
	public String toString(){
		return "ActivitySetting["  	
				+ "id = " + id
				+ " , startTime = " + startTime
				+ " , endTime = " + endTime
				+ " , userCanTakeTimes = " + userCanTakeTimes
				+ " , activityTimes = " + activityTimes
				+ " , isForever = " + isForever
				+ "]";
	}
}

