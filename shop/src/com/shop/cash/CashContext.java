package com.shop.cash;

import java.util.Scanner;

public class CashContext {	
	
	private ACash cash;
	
	/**
	 * 根据场景不同选取不同的实例
	 * @param cash
	 */
	public void setBehavior(ACash cash) {
		this.cash = cash;
	}
	
	/**
	 * 根据不同的场景选取不同的策略
	 * @param money
	 * @return
	 */
	public double getResult(double money) {
		return cash.acceptCash(money);
	}
	
	
	@SuppressWarnings({ "resource", "unused" })
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		Scanner scanner = new Scanner(System.in);
		double money = 0d;
		int CashType = 0;
		double totle = 0d; // 总额
		
//		String packageName = "com.shop.cash.";
//		Cash cash = null;
		
		CashContext cc = new CashContext();
		
		System.out.print("请输入商品金额：");
		money = scanner.nextDouble();
		System.out.println("请选择收费方式（1、正常收费.2、打折8折.3、满200返100）：");
		CashType = scanner.nextInt();
		/*
		switch (CashType) {
		case 1:
			cash= (Cash) Class.forName(packageName+"CashNormal").newInstance(); 
			break;
		case 2:
			cash = (Cash) Class.forName(packageName+"CashRebate").newInstance(); 
			break;
		case 3:
			cash = (Cash) Class.forName(packageName+"CashReturn").newInstance(); 
			break;
		}*/
		
		switch (CashType) {
		case 1:
			cc.setBehavior(new CashNormal());
			break;
		case 2:
			cc.setBehavior(new CashRebate("0.8"));
			break;
		case 3:
			cc.setBehavior(new CashReturn("300", "100"));
			break;
		}
		
		// 获取总金额
		totle = cc.getResult(money);
		System.out.println("商品中金额是："+cc.getResult(money));
		
	}
	
}
