package com.shop.cash;

public class CashRebate extends ACash {
	private double moneyRebate = 0d;
	
	/**
	 * @param mr 打折数
	 */
	public CashRebate(String mr) {
		// TODO Auto-generated constructor stub
		this.moneyRebate = Double.parseDouble(mr);
	}
	
	@Override
	public double acceptCash(double money) {
		// TODO Auto-generated method stub
		return money*moneyRebate;
	}

}
