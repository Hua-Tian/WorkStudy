package com.shop.cash;

public class CashReturn extends ACash{
	private double moneyCondition = 0d;// 返利条件
	private double moneyReturn = 0d;// 返利金额
	
	/**
	 * @param mc 返利条件
	 * @param mr 返利金额
	 */
	public CashReturn(String mc,String mr) {
		// TODO Auto-generated constructor stub
		this.moneyCondition = Double.parseDouble(mc);
		this.moneyReturn = Double.parseDouble(mr);
	}
	
	@Override
	public double acceptCash(double money) {
		// TODO Auto-generated method stub
		if(money >= moneyCondition){
			return money - Math.floor(money/moneyCondition)*moneyReturn;
		}else{
			return money;
		}
	}
	
}
