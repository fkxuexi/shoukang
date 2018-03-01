package common.entity;

import java.math.BigDecimal;

/**
* @Auth 
* 活动奖品
*/
public class ActivityPrize{
	
	private Integer id;  // 注释：活动奖品类型 自增主键   
	private BigDecimal discount;  // 注释：折扣
	private BigDecimal rebackMoney;  // 注释：返现券
	private BigDecimal reduceMoney;  // 注释：减免   
	private Integer giveGoodsId;  // 注释：赠送商品的id   
	private Integer giveScore;  // 注释：赠送积分
    /**
     *注释：1:discount,2:reback_money,3:reduce_money,4:give_goods_id,5:give_score,
     * 这个奖品的设置也可以并列,
     */
	private Integer prizeType;

	public void setId(Integer id){
		this.id = id;
	}
	
	public Integer getId(){
		return id;
	}
	
	public void setDiscount(BigDecimal discount){
		this.discount = discount;
	}
	
	public BigDecimal getDiscount(){
		return discount;
	}
	
	public void setRebackMoney(BigDecimal rebackMoney){
		this.rebackMoney = rebackMoney;
	}
	
	public BigDecimal getRebackMoney(){
		return rebackMoney;
	}
	
	public void setReduceMoney(BigDecimal reduceMoney){
		this.reduceMoney = reduceMoney;
	}
	
	public BigDecimal getReduceMoney(){
		return reduceMoney;
	}
	
	public void setGiveGoodsId(Integer giveGoodsId){
		this.giveGoodsId = giveGoodsId;
	}
	
	public Integer getGiveGoodsId(){
		return giveGoodsId;
	}
	
	public void setGiveScore(Integer giveScore){
		this.giveScore = giveScore;
	}
	
	public Integer getGiveScore(){
		return giveScore;
	}
	
	public void setPrizeType(Integer prizeType){
		this.prizeType = prizeType;
	}
	
	public Integer getPrizeType(){
		return prizeType;
	}
	

	@Override
	public String toString(){
		return "ActivityPrize["  	
				+ "id = " + id
				+ " , discount = " + discount
				+ " , rebackMoney = " + rebackMoney
				+ " , reduceMoney = " + reduceMoney
				+ " , giveGoodsId = " + giveGoodsId
				+ " , giveScore = " + giveScore
				+ " , prizeType = " + prizeType
				+ "]";
	}
}

