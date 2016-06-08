package com.hua.config;

import com.hua.controller.CDecorator;
import com.jfinal.config.*;
import com.jfinal.core.JFinal;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.activerecord.dialect.PostgreSqlDialect;
import com.jfinal.plugin.c3p0.C3p0Plugin;
import com.jfinal.plugin.ehcache.EhCachePlugin;
import com.shop.controller.ShopContoller;
import com.shop.model.Cash;


public class Config extends JFinalConfig{

	@Override
	public void configConstant(Constants me) {
		// TODO Auto-generated method stub
		PropKit.use("config.properties");
		me.setDevMode(true);
		me.setEncoding("utf-8");
		me.setUrlParaSeparator("&");
	}

	@Override
	public void configRoute(Routes me) {
		// TODO Auto-generated method stub
		me.add("/shop",ShopContoller.class);
		me.add("/phone", CDecorator.class);

	}

	@Override
	public void configPlugin(Plugins me) {
		// TODO Auto-generated method stub
		//数据库操作
		C3p0Plugin c3p0Plugin = new C3p0Plugin(PropKit.get("jdbcUrl"),PropKit.get("username"),PropKit.get("password"),PropKit.get("driver"));
		ActiveRecordPlugin arp = new ActiveRecordPlugin(c3p0Plugin);

		arp.setShowSql(true);
		// 映射表
//		_MappingKit.mapping(arp);
		arp.addMapping("shop_cash","cash_id",Cash.class);
		me.add(c3p0Plugin);
		me.add(arp);
//		 添加缓存插件
		me.add(new EhCachePlugin());
		// 设置方言
		arp.setDialect(new PostgreSqlDialect());
	}

	@Override
	public void configInterceptor(Interceptors me) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void configHandler(Handlers me) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args) {

		JFinal.start("WebRoot",8082,"/",5);
	}
}
