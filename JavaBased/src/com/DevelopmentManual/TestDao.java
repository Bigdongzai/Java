package com.DevelopmentManual;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 作者: xhd
 * 创建时间: 2019/8/28 10:40
 * 版本: V1.0
 */
public class TestDao {
    private static ThreadLocal<Connection> conThreadLocal = new ThreadLocal<Connection>() {
        @Override
        protected Connection initialValue() {
            Connection conn = null;
            try {
                conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/test", "username",
                        "password");
            } catch (Exception e) {
                e.printStackTrace();
            }
            return conn;
        }
    };

    public static Connection getConnection() {

        return conThreadLocal.get();
    }

    public void addTopic() throws SQLException {
        Statement stat = getConnection().createStatement();
    }
}
