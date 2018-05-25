package logic.Utils;


import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class C3P0Inner {



    private static ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
    static {

        try {
            comboPooledDataSource.setDriverClass("com.mysql.jdbc.Driver");//设置连接池连接数据库所需的驱动
            comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost:3306/shoppingonline?serverTimezone=GMT");//设置连接数据库的URL
            comboPooledDataSource.setUser("root");//设置链接数据库的用户名
            comboPooledDataSource.setPassword("123456");//设置链接数据库的密码
            comboPooledDataSource.setMaxPoolSize(40);//设置连接池的最大连接数
            comboPooledDataSource.setMinPoolSize(2); //设置连接池的最小连接数
            comboPooledDataSource.setInitialPoolSize(10);//设置连接池的初始连接数
            comboPooledDataSource.setMaxStatements(100);//设置连接池缓存Statement的最大数
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //获取与指定数据库的链接
    public static ComboPooledDataSource getInstance(){
        return comboPooledDataSource;
    }

    //获取一个链接
    public static Connection getConnection(){
        Connection connection = null;
        try {
            connection = comboPooledDataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    //释放资源
    public static void releaseResource(ResultSet resultSet, PreparedStatement preparedStatement,Connection connection){
        if (resultSet!=null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (preparedStatement!=null){
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (connection!=null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
