package logic.Dao;

import logic.Utils.C3P0Inner;
import logic.Utils.C3P0InnerStatement;
import logic.Utils.RegisterInformationValidation;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author JuHzzz
 * @version 1.0.0
 * Date: 2018/05/21
 */
//用户信息表的CRUD
    @Component
public class UserInformationOperation implements DBOperation{


    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null ;
    //新增用户
    public void createNewElement(Object object) {
        String sql = "INSERT INTO tb_user_information VALUES(?,?,?,?,?)";
        connection = C3P0Inner.getConnection();
        try {
            preparedStatement = C3P0InnerStatement.setStatement(connection,sql);
            preparedStatement.setString(1,((RegisterInformationValidation) object).getUserID());
            preparedStatement.setString(2,((RegisterInformationValidation) object).getUserAccount());
            preparedStatement.setString(3,((RegisterInformationValidation) object).getUserPhone());
            preparedStatement.setString(4,((RegisterInformationValidation) object).getUserName());
            preparedStatement.setString(5,((RegisterInformationValidation) object).getUserSex());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {

          C3P0Inner.releaseResource(resultSet,preparedStatement,connection);
        }

    }

    //查询用户
    public ResultSet retrieveElement(Object object) {

        return resultSet;
    }

    //更新用户
    public void updateElement(Object object) {

    }

    //删除用户
    public void deleteElement(Object object) {

    }
}
