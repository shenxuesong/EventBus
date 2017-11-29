package c.example.dell.butterknife;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import static org.greenrobot.eventbus.ThreadMode.MAIN;

public class Main2Activity extends AppCompatActivity {

    private TextView mText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
         EventBus.getDefault().register(this);
        String s = mText.getText().toString().trim();
        Log.i("Tag",s);
 //       EventBus.getDefault().post(new MessageEvent(s));
    }
    private void initView() {
        mText = (TextView) findViewById(R.id.text);
    }
    //订阅黏性事件
    @Subscribe(threadMode = MAIN,sticky = true)
    public void getEvet(MessageEvent e){
        mText.setText(e.getTitle());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    EventBus.getDefault().unregister(this);
    }
}
