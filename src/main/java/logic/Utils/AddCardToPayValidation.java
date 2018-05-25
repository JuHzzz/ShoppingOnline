package logic.Utils;

import logic.Dao.ProductOperation;
import logic.POJOS.Product;

public class AddCardToPayValidation {

    //验证商品库存是否充足
    public boolean checkIsEnough(Product product,ProductOperation productOperation){
      //获得商品库存数量
        int productCount = productOperation.retrieveProductCount(product.getProductID());
        boolean isEnough = true;
        //比较库存储量和购买数量
        if(productCount < Integer.parseInt(product.getProductNum())){
            isEnough = false;
        }
        return isEnough;
    }
}
