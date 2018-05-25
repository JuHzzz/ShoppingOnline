package logic.Dao;

import logic.POJOS.UserAccountInformation;
import logic.Utils.C3P0Inner;
import logic.Utils.C3P0InnerStatement;
import logic.Utils.RegisterInformationValidation;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@Service
public class UserAccountInformationOperation implements DBOperation {
   private Connection connection = null;
   private PreparedStatement preparedStatement = null;
   private ResultSet resultSet = null ;

   //创建新元素
    public void createNewElement(Object object) {
        connection = C3P0Inner.getConnection();
        String sql = "INSERT INTO Tb_UserAccount_Information VALUES(?,?,?,?)";
        try {
            preparedStatement = C3P0InnerStatement.setStatement(connection,sql);
            preparedStatement.setString(1,((RegisterInformationValidation) object).getUserAccount());
            preparedStatement.setString(2,((RegisterInformationValidation) object).getUserPassword());
            preparedStatement.setString(3,((RegisterInformationValidation) object).getUserID());
            preparedStatement.setString(4,((RegisterInformationValidation) object).getUserPhone());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {

            C3P0Inner.releaseResource(resultSet,preparedStatement,connection);
        }

    }

    //查找元素
    public ResultSet retrieveElement(Object object) {

        return resultSet;
    }

    //更新元素
    public void updateElement(Object object) {

    }

    //删除元素
    public void deleteElement(Object object) {

    }
}
