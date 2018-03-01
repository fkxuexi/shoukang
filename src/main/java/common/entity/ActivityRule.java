package common.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
* @Auth 
* 活动规则
*/
public class ActivityRule{
	
	private Integer id;  // 注释：活动规则 自增主键   
	private Integer points;  // 注释：参与活动的积分的限制   
	private Integer level;  // 注释：参与活动会员等级的限制   
	private BigDecimal consumeMoney;  // 注释：参与活动消费金额限制
	/**
	注释：组合条件,1:point,2:level,3:consume_money,
	12 则为12两个条件组合,13 则为13两个条件组合,
	23 则为23两个条件组合,123 则三个条件并列组合,如果为1,2,3 则只使用一个条件
	*/
    private Integer andOr;
	private Date createTime;  // 注释：创建时间   
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
	
	public void setAndOr(Integer andOr){
		this.andOr = andOr;
	}
	
	public Integer getAndOr(){
		return andOr;
	}
	
	public void setCreateTime(Date createTime){
		this.createTime = createTime;
	}
	
	public Date getCreateTime(){
		return createTime;
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
				+ " , andOr = " + andOr
				+ " , createTime = " + createTime
				+ " , descri = " + descri
				+ "]";
	}
}

