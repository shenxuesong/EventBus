package c.example.dell.butterknife;

/**
 * Created by Dell on 2017/11/29.
 */

public class MessageEvent {
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public MessageEvent(String title) {
        this.title = title;
    }
}
