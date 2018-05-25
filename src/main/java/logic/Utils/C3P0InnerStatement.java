package logic.Utils;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class C3P0InnerStatement {

    //返回一个发送SQL语句的Statement
    public static PreparedStatement setStatement(Connection connection,String sql){
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return preparedStatement;
    }

}
