package messaging;

/**
 * Created by Administrator on 2016/9/2.
 */
public class messages {
    String username;
    String text;
    String time;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setTime(String time) {
        this.time = time;
    }


    public String getUsername() {
        return username;
    }

    public String getText() {
        return text;
    }

    public String getTime() {
        return time;
    }

    public messages(String username, String text, String time){
        this.username = username;
        this.text = text;
        this.time = time;
    }
}
