package com.hua.decorator;

/**
 * Created by 10113513 on 2016/06/02.
 */
public class InfoBar implements Phone{

    @Override
    public void showSelf() {
        System.out.println("这是信息栏...");

    }
}
