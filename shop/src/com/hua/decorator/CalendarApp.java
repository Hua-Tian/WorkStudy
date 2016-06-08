package com.hua.decorator;

/**
 * Created by 10113513 on 2016/06/02.
 */
public class CalendarApp extends AppManager {


    /**
     * 用于管理对象
     *
     * @param phone
     */
    public CalendarApp(Phone phone) {
        super(phone);
    }

    @Override
    public void showSelf() {
        super.showSelf();
        System.out.println("这是日历管理系统");
    }
}
