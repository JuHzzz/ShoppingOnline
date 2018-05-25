package logic.Dao;

import logic.POJOS.OrderForm;
import logic.Utils.C3P0Inner;
import logic.Utils.C3P0InnerStatement;
import logic.Utils.RegisterInformationValidation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class OrderFormOperation implements DBOperation {


    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null ;

    public void createNewElement(Object object) {
        connection = C3P0Inner.getConnection();
        String sql = "INSERT INTO Tb_OrderForm VALUES(?,?,?,?,?,?)";
        try {
            preparedStatement = C3P0InnerStatement.setStatement(connection,sql);
            preparedStatement.setString(1,((OrderForm) object).getOrderForm_ID());
            preparedStatement.setString(2,((OrderForm) object).getOrderForm_ProductInformation());
            preparedStatement.setInt(3,((OrderForm) object).getOrderForm_ProductNum());
            preparedStatement.setString(4,((OrderForm) object).getOrderForm_DeliveryAddress());
            preparedStatement.setString(5,((OrderForm) object).getOrderForm_BuyerMessage());
            preparedStatement.setFloat(6,((OrderForm) object).getOrderForm_Total());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {

            C3P0Inner.releaseResource(resultSet,preparedStatement,connection);
        }
    }

    public Object retrieveElement(Object object) {
        return null;
    }

    public void updateElement(Object object) {

    }

    public void deleteElement(Object object) {

    }
}
