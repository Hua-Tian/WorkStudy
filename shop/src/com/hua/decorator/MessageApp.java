package com.hua.decorator;

/**
 * Created by 10113513 on 2016/06/02.
 */
public class MessageApp extends AppManager {


    /**
     * 用于管理对象
     *
     * @param phone
     */
    public MessageApp(Phone phone) {
        super(phone);
    }

    @Override
    public void showSelf() {
        super.showSelf();
        System.out.println("这里是短信系统...");
    }

}
