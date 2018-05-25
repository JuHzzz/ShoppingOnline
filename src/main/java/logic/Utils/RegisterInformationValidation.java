package logic.Utils;

import logic.POJOS.UserAccountInformation;
import logic.POJOS.UserInformation;

public class RegisterInformationValidation {



    private String userName;        //用户姓名
    private String userID;          //用户身份证号
    private String userPhone;       //用户手机号
    private String userSex;         //用户性别

    private String userAccount;     //用户账号
    private String userPassword;    //用户密码
    private String userRePassword;  //用户确认密码


    public String getUserName() {
        return userName;
    }

    public String getUserID() {
        return userID;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public String getUserSex() {
        return userSex;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public String getUserPassword() {
        return userPassword;
    }


    //注册页面第一级页面验证
    public boolean validate_firstRegister(UserInformation userInformation){

          userName = userInformation.getUserName();        //用户姓名
          userID = userInformation.getUserID();          //用户身份证号
          userPhone = userInformation.getUserPhone();       //用户手机号
          userSex = userInformation.getUserSex();         //用户性别

        boolean result = false;

        if (userName != null && userID != null && userPhone != null && userSex != null){

            if (UserIDValidation.checkIdcard(userID)==true&&
                    UserNameValidation.checkName(userName)==true&&
                    UserPhoneValidation.checkPhone(userPhone)==true){
                result = true;

            }
        }



        return result;
    }

    public boolean validate_secondRegister(UserAccountInformation userAccountInformation){
                userAccount = userAccountInformation.getUserAccount();
                userPassword = userAccountInformation.getUserPassword();
                userRePassword = userAccountInformation.getUserRePassword();
                boolean result = false;

                if (userAccount != null && userPassword != null && userRePassword != null){
                    if (UserAccountValidation.checkUserAccount(userAccount)==true&&
                            UserPasswordValidation.checkPassword(userPassword,userRePassword)==true){

                        result = true;
                    }
                }

                return result;

    }

}
