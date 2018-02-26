package activity.top.fkxuexi.activity.entity;

import java.math.BigDecimal;

/**
* @Auth 
* 活动规则
*/
public class ActivityRule{
	
	private Integer id;  // 注释：活动规则 自增主键   
	private Integer points;  // 注释：参与活动的积分的限制   
	private Integer level;  // 注释：参与活动会员等级的限制   
	private BigDecimal consumeMoney;  // 注释：参与活动消费金额限制   
	private String descri;  // 注释：简短的说明   

	public void setId(Integer id){
		this.id = id;
	}
	
	public Integer getId(){
		return id;
	}
	
	public void setPoints(Integer points){
		this.points = points;
	}
	
	public Integer getPoints(){
		return points;
	}
	
	public void setLevel(Integer level){
		this.level = level;
	}
	
	public Integer getLevel(){
		return level;
	}
	
	public void setConsumeMoney(BigDecimal consumeMoney){
		this.consumeMoney = consumeMoney;
	}
	
	public BigDecimal getConsumeMoney(){
		return consumeMoney;
	}
	
	public void setDescri(String descri){
		this.descri = descri;
	}
	
	public String getDescri(){
		return descri;
	}
	

	@Override
	public String toString(){
		return "ActivityRule["  	
				+ "id = " + id
				+ " , points = " + points
				+ " , level = " + level
				+ " , consumeMoney = " + consumeMoney
				+ " , descri = " + descri
				+ "]";
	}
}

