package com.hua.decorator;


/**
 * Created by 10113513 on 2016/06/02.
 */
public class AppManager implements Phone{
    private Phone phone;


    public AppManager(Phone phone) {
        this.phone = phone;
    }


    @Override
    public void showSelf() {
        System.out.println("这是App管理系统");
        if (phone != null) {
            phone.showSelf();
        }
    }

    public static void main(String[] a) {
        Phone infoBar = new InfoBar();
        Phone megApp = new MessageApp(infoBar);
        Phone calApp = new CalendarApp(megApp);
        calApp.showSelf();


    }

}
