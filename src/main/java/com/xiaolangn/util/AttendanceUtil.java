package com.xiaolangn.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import common.Logger;

/**
 * 获取考勤机器连接
 *
 * @author Irwin.Ai
 *
 */
public class AttendanceUtil {
    private static Logger logger = Logger.getLogger(AttendanceUtil.class);
    private static Connection connection;

    public static Connection getConnection(){
        if(connection == null){
            try {
                Class.forName("org.objectweb.rmijdbc.Driver").newInstance();
                String url = "jdbc:rmi://192.168.1.121/jdbc:odbc:testdb";
                Connection c = DriverManager.getConnection(url, "Admin", "");
                return c;
            } catch (Exception e) {
                logger.error(e);
            }
        }
        return connection;
    }

    public static void closeConnection(){
        if(connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                logger.error(e);
            }
        }
    }
}
