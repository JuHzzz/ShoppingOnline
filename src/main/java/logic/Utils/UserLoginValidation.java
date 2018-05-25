package logic.Utils;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserLoginValidation {

    public static boolean checkIsExists(ResultSet resultSet){

        String sum = null;
        try {
            while(resultSet.next()){
                sum = resultSet.getString(1);
            }
            if(sum != null&& !"0".equals(sum)){
                return true; //存在此id
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return false;
    }
}
