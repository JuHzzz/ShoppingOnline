package logic.POJOS;

import com.sun.istack.internal.NotNull;

/**
 * @author JuHzzz
 * @version 1.0.0
 * Date: 2018/05/21
 */


public class UserAccountInformation {
    @NotNull
    private String userAccount;     //用户账号
    @NotNull
    private String userPassword;    //用户密码
    @NotNull
    private String userRePassword;  //用户确认密码

    @Override
    public String toString() {
        return "UserAccountInformation{" +
                "userAccount='" + userAccount + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userRePassword='" + userRePassword + '\'' +
                '}';
    }

    public String getUserRePassword() {
        return userRePassword;
    }

    public void setUserRePassword(String userRePassword) {
        this.userRePassword = userRePassword;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
