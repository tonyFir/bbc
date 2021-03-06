package com.cdd.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SelectDateUtil {
    Connection conn = null;
    
    // 获取数据库连接
    public Connection getConn() {
        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver"); // 加载数据库驱动
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = "jdbc:jtds:sqlserver://localhost:1433;DatabaseName=db_database21"; // 连接数据库URL
        String userName = "sa"; // 连接数据库的用户名
        String passWord = ""; // 连接数据库密码
        try {
            conn = DriverManager.getConnection(url, userName, passWord); // 获取数据库连接
            if (conn != null) {
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn; // 返回Connection对象
    }
    //按出生日期查找学生信息方法

public List getStuUseDate(String sDate) {
    List list = new ArrayList(); // 定义用于保存返回值的List集合
    conn = getConn(); // 获取数据库连接
    try {
        Statement staement = conn.createStatement();
        String sql = "select * from tb_StuInfo where sBrithday = '"+sDate+"'"; // 定义查询数据的SQL语句
        ResultSet set = staement.executeQuery(sql); // 执行查询语句返回查询结果集
        while (set.next()) { // 循环遍历查询结果集
           StuInfo stuInfo = new StuInfo();     //创建于数据表对应的JavaBean对象
           stuInfo.setId(set.getInt(1));        //设置对象属性
           stuInfo.setsName(set.getString(2));
           stuInfo.setsSex(set.getString(3));
           stuInfo.setsBrithday(set.getString(4));
           stuInfo.setsSpeciality(set.getString(5));
           stuInfo.setsAddress(set.getString(6));
           list.add(stuInfo);                   //向集合中添加对象
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return list; // 返回List集合
}
    //查询所有学生出生日期方法
    public List getStuDateList() {
        List list = new ArrayList(); // 定义用于保存返回值的List集合
        conn = getConn(); // 获取数据库连接
        try {
            Statement staement = conn.createStatement();
            String sql = "select sBrithday from tb_StuInfo "; // 定义查询数据的SQL语句
            ResultSet set = staement.executeQuery(sql); // 执行查询语句返回查询结果集
            while (set.next()) { // 循环遍历查询结果集
               String sDate = new String();
               sDate = set.getString(1);
               list.add(sDate);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list; // 返回List集合
    }
}
