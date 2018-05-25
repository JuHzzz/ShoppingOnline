package logic.Handler.Interceptors;

import logic.Dao.ProductOperation;
import logic.POJOS.Product;
import java.util.Map;

public class AddCartToPayInterceptor {


    private Map<String ,String> map = null;
    private ProductOperation productOperation = new ProductOperation();

    public boolean preHandle(Product product){
        map = product.getMap();
        System.out.println("数据校验之前："+product);
        //数据校验是否为空
        for (Map.Entry<String ,String> entry : map.entrySet()) {
            if (entry.getValue() == null || "".equals(entry.getValue())){
                return false;
            }
        }
        //不为空，获取并设置ProductID
        product.setProductID(productOperation.retrieveElement(product));
        return true;
    }

}
