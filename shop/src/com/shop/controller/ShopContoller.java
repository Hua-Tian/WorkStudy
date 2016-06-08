package com.shop.controller;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.ext.interceptor.NoUrlPara;
import com.shop.cash.CashContext;
import com.shop.cash.CashNormal;
import com.shop.cash.CashRebate;
import com.shop.cash.CashReturn;
import com.shop.model.Cash;

public class ShopContoller extends Controller{
	
	@Before(NoUrlPara.class)
	public void index() {
		renderText("hello world");
	}
	
	/**
	 * 获取商品销售方式
	 */
	public void getCash() {
		Cash cash = getModel(Cash.class);
		setAttr("cashs", cash.getCash());
		renderJson();
	}
	
	/**
	 * 计算商品价格
	 */
	public void calculate() {
		double price = getParaToInt("price");   // 单价
		double amount = getParaToInt("amount"); // 数量
		String costType = getPara("costType");// 收费方式
//		String reg = ".*,.*";
		CashContext context = new CashContext();
		
		// 计费方式
		if(costType.contains(",")){
			String[] costSet = costType.split(",");
			context.setBehavior(new CashReturn(costSet[0], costSet[1]));
		}else if(Double.parseDouble(costType) < 1){
			context.setBehavior(new CashRebate(costType));
		}else if (Integer.parseInt(costType) == 1) {
			context.setBehavior(new CashNormal());
		}
		setAttr("total", context.getResult(price*amount));
		
		renderJson();
	}
	
	public static void main(String[] args) {
		String reg = ".*,.*";
		String string ="300,100";
		System.out.println(string.matches(reg));
		String a[] = string.split(",");
		System.out.println(a[0]);
	}
}
