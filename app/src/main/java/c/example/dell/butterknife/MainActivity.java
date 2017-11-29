package c.example.dell.butterknife;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import butterknife.BindView;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.tv)
    TextView tv;
    /**
     * 你好!
     */
    private TextView mTv;
    private Button bu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       //EventBus.getDefault().register(this);
        initView();





      bu.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              startActivity(new Intent(MainActivity.this,Main2Activity.class));
          }
      });
      //黏性事件
      EventBus.getDefault().postSticky(new MessageEvent(mTv.getText().toString()));
    }

    @Override
    public void setContentView(View view) {
        super.setContentView(view);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
      //  EventBus.getDefault().unregister(this);
    }

    private void initView() {
        mTv = (TextView) findViewById(R.id.tv);
        bu = (Button) findViewById(R.id.bu);

    }
   /* @Subscribe
    public void onMessageEvent(MessageEvent event){
        String title = event.getTitle();
        Log.i("TAG",title);
       mTv.setText(title);
    }
*/
}
