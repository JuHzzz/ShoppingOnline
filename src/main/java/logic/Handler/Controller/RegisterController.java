package logic.Handler.Controller;

import logic.Dao.UserAccountInformationOperation;
import logic.Dao.UserInformationOperation;
import logic.POJOS.UserAccountInformation;
import logic.POJOS.UserInformation;
import logic.Utils.RegisterInformationValidation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("register")
public class RegisterController {

    private RegisterInformationValidation registerInformationValidation = new RegisterInformationValidation();
    private UserInformationOperation userInformationOperation = new UserInformationOperation();
    private UserAccountInformationOperation userAccountInformationOperation = new UserAccountInformationOperation();
    //注册页面第一级页面

    @RequestMapping(value = "/registerController_1.form",method = RequestMethod.POST)
    public String checkUserInformation(UserInformation userInformation){
        System.out.println(userInformation);
        if(registerInformationValidation.validate_firstRegister(userInformation)==true){
            return "register_2";
        }else {
            return "login";
        }
    }

    //注册页面第二级页面
    @RequestMapping("/registerController_2.form")
    public String checkUserAccountInformation(UserAccountInformation userAccountInformation){
        System.out.println(userAccountInformation);
        if (registerInformationValidation.validate_secondRegister(userAccountInformation)==true){

            userInformationOperation.createNewElement(registerInformationValidation);
            userAccountInformationOperation.createNewElement(registerInformationValidation);
            return "index";
        }
        return "login";
    }

}
