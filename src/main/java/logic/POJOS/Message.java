package logic.POJOS;

public class Message {

    private String userAccount;
    private String time;

    @Override
    public String toString() {
        return "Message{" +
                "userAccount='" + userAccount + '\'' +
                ", time='" + time + '\'' +
                '}';
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }
}
