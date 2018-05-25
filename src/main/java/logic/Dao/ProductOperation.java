package logic.Dao;

import logic.POJOS.OrderForm;
import logic.POJOS.Product;
import logic.POJOS.UserAccountInformation;
import logic.Utils.C3P0Inner;
import logic.Utils.C3P0InnerStatement;
import logic.Utils.UserLoginValidation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ProductOperation implements DBOperation {

    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null ;

    public void createNewElement(Object object) {}

    //查询并返回所选商品的ProductID
    public String retrieveElement(Object object) {
        connection = C3P0Inner.getConnection();
        String sql = "SELECT product_ID from tb_product where product_type = ? " +
                "and product_color= ? and product_size=?";
        String productID = null;
        try {
            preparedStatement = C3P0InnerStatement.setStatement(connection,sql);
            preparedStatement.setString(1,((Product) object).getProductType());
            preparedStatement.setString(2,((Product) object).getProductColor());
            preparedStatement.setString(3,((Product) object).getProductSize());
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                productID = resultSet.getString(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            C3P0Inner.releaseResource(resultSet,preparedStatement,connection);
        }

        return productID;
    }

    public int retrieveProductCount(String productID){
        connection = C3P0Inner.getConnection();
        String sql = "SELECT product_count from tb_product where product_ID = ?";
        int productCount = 0;
        try {
            preparedStatement = C3P0InnerStatement.setStatement(connection,sql);
            preparedStatement.setString(1,productID);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                productCount = resultSet.getInt(1);
            }
            C3P0Inner.releaseResource(resultSet,preparedStatement,connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("product:"+productCount);
        return productCount;
    }

    public void updateElement(Object object) {
        connection = C3P0Inner.getConnection();
        String sql = "UPDATE tb_product set product_count = product_count-? where product_ID = ?";
        try {
            preparedStatement = C3P0InnerStatement.setStatement(connection,sql);
            preparedStatement.setInt(1,((OrderForm) object).getOrderForm_ProductNum());
            preparedStatement.setString(2,((OrderForm) object).getOrderForm_ID().substring(13));
            System.out.println("截取字符："+((OrderForm) object).getOrderForm_ID().substring(13));
            int i = preparedStatement.executeUpdate();
            System.out.println("更改行数："+i);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            C3P0Inner.releaseResource(resultSet,preparedStatement,connection);
        }

    }

    public void deleteElement(Object object) {

    }
}
