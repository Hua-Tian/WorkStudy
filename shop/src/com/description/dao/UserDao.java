package com.description.dao;

import com.description.defined.Column;
import com.description.defined.Table;
import com.description.model.User;
import com.hua.decorator.AppManager;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by 10113513 on 2016/06/03.
 */
public class UserDao {


    /**
     * 通过注解和反射来拼接SQL语句
     * @param obj
     * @return sql
     */
    public static String query(Object obj) {
        StringBuffer sb = new StringBuffer();

        Class tb = obj.getClass();
        // 获取Table
        boolean isExists = tb.isAnnotationPresent(Table.class);
        if (!isExists) {
            return null;
        }
        // 获取表名
        Table t = (Table)tb.getAnnotation(Table.class);
        String tbName = t.value();
        sb.append("select * from ").append(tbName).append(" where 1=1 ");

        // 获取字段
        Field[] fArray =  tb.getDeclaredFields();
        for (Field f : fArray) {
            boolean fIsExists = f.isAnnotationPresent(Column.class);
            if(!fIsExists){
                continue;
            }
            Column col = f.getAnnotation(Column.class);
            String colName = col.value();
            String filedName = f.getName();
            Object filedValue = null;
            // 获取get方法
            String getMethodName = "get"+filedName.substring(0,1).toUpperCase()+filedName.substring(1);
            try {
                Method getMethod = tb.getMethod(getMethodName);
                filedValue = getMethod.invoke(obj);

            } catch (Exception e) {
                e.printStackTrace();
            }
            // 判断字段是否为空 或者是否是值是0的int类型
            if (filedValue == null || (filedValue instanceof Integer && (Integer)filedValue == 0)){
                continue;
            }else if (filedValue instanceof String){
                sb.append(" and ").append(colName).append(" = '").append(filedValue).append("'");
            }else if (filedValue instanceof  Integer){
                sb.append(" and ").append(colName).append(" = ").append(filedValue);
            }else if (false){

            }
        }
        return sb.toString();
    }

    /**
     * 单元测试
     * @param i
     * @param j
     * @return
     */
    public static int add(int i,int j) {
        return i+j;
    }

    public static void main(String[] args) {
        User user1 = new User();
        user1.setUserId(1);
        user1.setUserName("刘宝华");
        String sql1 = query(user1);
        System.out.println(sql1);

        User user2 = new User();
        user2.setUserName("华天");
        String sql2 = query(user2);
        System.out.println(sql2);

    }

}
