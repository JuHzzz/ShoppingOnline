package logic.Utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserAccountValidation {

    public static boolean checkUserAccount(String userAccount){
        String regex = "^[A-Za-z0-9]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(userAccount);
        return matcher.matches();
    }

}
