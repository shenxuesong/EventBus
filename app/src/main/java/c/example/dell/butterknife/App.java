package c.example.dell.butterknife;

import android.app.Application;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by Dell on 2017/11/29.
 */

public class App extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        EventBus.builder().addIndex(new MyEventBusIndex()).installDefaultEventBus();
    }
}
