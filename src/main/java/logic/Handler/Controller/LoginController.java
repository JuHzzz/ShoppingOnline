package logic.Handler.Controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import logic.Dao.UserLoginOperation;
import logic.POJOS.Person;
import logic.POJOS.UserAccountInformation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
public class LoginController {

    private UserLoginOperation userLoginOperation = new UserLoginOperation();

    @RequestMapping(value = "/test.form",method = RequestMethod.POST,consumes = "application/json")
    @ResponseBody
    public Person testMethod(@RequestBody Person person){
        System.out.println("Hello2");
        System.out.println(person);
        return person;
    }


    //用户登录请求处理
    @RequestMapping("/loginInformationCheck.form")
    public String loginInformationCheck(UserAccountInformation userAccountInformation){

       System.out.println(userAccountInformation);

       boolean isExists = userLoginOperation.retrieveElement(userAccountInformation) ;

        if (isExists == true){
            return "index";
        }
        return "login";
    }


}
