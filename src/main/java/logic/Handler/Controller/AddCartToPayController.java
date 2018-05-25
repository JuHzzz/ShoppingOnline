package logic.Handler.Controller;

import logic.Dao.OrderFormOperation;
import logic.Dao.ProductOperation;
import logic.Handler.Interceptors.AddCartToPayInterceptor;
import logic.POJOS.OrderForm;
import logic.POJOS.Product;
import logic.Utils.AddCardToPayValidation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class AddCartToPayController {

    private HttpSession session = null;
    private AddCartToPayInterceptor addCartToPayInterceptor = new AddCartToPayInterceptor();
    private ProductOperation productOperation = new ProductOperation();
    private OrderFormOperation orderFormOperation = new OrderFormOperation();
    private HttpSession httpSession;
    private AddCardToPayValidation addCardToPayValidation = new AddCardToPayValidation();

    //下单操作
    @RequestMapping("/addCart.form")
    public String addCart(Product product, HttpServletRequest httpServletRequest){
           session =  httpServletRequest.getSession();
        //数据校验 preHandle
        boolean isSuccess = addCartToPayInterceptor.preHandle(product);
        System.out.println("数据校验是否成功："+isSuccess);
        //商品库存是否充足
        System.out.println("数据校验成功后："+product);
        boolean isEnough = addCardToPayValidation.checkIsEnough(product,productOperation);

        if (isSuccess == true && isEnough == true){
                //加入Session中
                session.setAttribute("product" , product);
                System.out.println("数据校验之后："+product);
                return "forward:account.jsp";
        }
        System.out.println("下单失败");
        return "redirect:index.html";
    }

    //订单确认操作
    @RequestMapping("/updateOperation.form")
    public String updateOperation(OrderForm orderForm , HttpServletRequest httpServletRequest){
        System.out.println(orderForm);
        httpSession = httpServletRequest.getSession();

        //收货地址不能为空（Ajax）
        //修改数据库
            productOperation.updateElement(orderForm);
            orderFormOperation.createNewElement(orderForm);
            System.out.println("下单成功！");
            httpSession.removeAttribute("product");
        return "redirect:index.html";
    }

}
