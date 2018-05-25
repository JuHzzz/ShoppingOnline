package logic.Dao;

import logic.POJOS.UserAccountInformation;
import logic.Utils.C3P0Inner;
import logic.Utils.C3P0InnerStatement;
import logic.Utils.UserLoginValidation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserLoginOperation implements DBOperation{

    private Connection connection = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null ;


    public void createNewElement(Object object){}

    public Boolean retrieveElement(Object object) {
        connection = C3P0Inner.getConnection();
        boolean isExists = false;
        String sql = "SELECT count(*) from Tb_UserAccount_Information where userAccount = ? and userPassword = ?";
        try {
            preparedStatement = C3P0InnerStatement.setStatement(connection,sql);
            preparedStatement.setString(1,((UserAccountInformation) object).getUserAccount());
            preparedStatement.setString(2,((UserAccountInformation) object).getUserPassword());
            resultSet = preparedStatement.executeQuery();
            isExists = UserLoginValidation.checkIsExists(resultSet);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
          C3P0Inner.releaseResource(resultSet,preparedStatement,connection);
        }

        return isExists;
    }

    public void updateElement(Object object) {

    }

    public void deleteElement(Object object) {

    }
}
