package logic.POJOS;

import com.sun.istack.internal.NotNull;
import org.springframework.stereotype.Component;
/**
 * @author JuHzzz
 * @version 1.0.0
 * Date: 2018/05/21
 */

@Component
public class UserInformation {
    @NotNull
    private String userName;        //用户姓名
    @NotNull
    private String userID;          //用户身份证号
    @NotNull
    private String userPhone;       //用户手机号
    @NotNull
    private String userSex;         //用户性别

    @Override
    public String toString() {
        return "UserInformation{" +
                "userName='" + userName + '\'' +
                ", userID='" + userID + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", userSex='" + userSex + '\'' +
                '}';
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

}
