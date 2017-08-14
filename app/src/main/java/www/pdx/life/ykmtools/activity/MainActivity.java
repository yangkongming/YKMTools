package www.pdx.life.ykmtools.activity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import www.pdx.life.ykmtools.R;
import www.pdx.life.ykmtools.base.BaseFragmentActivity;

public class MainActivity extends BaseFragmentActivity implements View.OnClickListener {


    @BindView(R.id.adapter)
    Button adapter;
    @BindView(R.id.qq_main)
    Button qqMain;
    @BindView(R.id.wechat_main)
    Button weChatMain;
    @BindView(R.id.advice_banner)
    Button banner;
    @BindView(R.id.sweet_dialog)
    Button dialog;
    @BindView(R.id.welcome_viewpager)
    Button welcome;
    @BindView(R.id.welcome_viewpager1)
    Button welcome1;
    @BindView(R.id.my_Toast)
    Button toast;
    @BindView(R.id.my_greenDAO)
    Button green;
    @BindView(R.id.my_glide)
    Button glide;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initClick();
    }

    public void initClick() {
        adapter.setOnClickListener(this);
        qqMain.setOnClickListener(this);
        weChatMain.setOnClickListener(this);
        banner.setOnClickListener(this);
        dialog.setOnClickListener(this);
        welcome.setOnClickListener(this);
        welcome1.setOnClickListener(this);
        toast.setOnClickListener(this);
        green.setOnClickListener(this);
        glide.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.adapter:
                startActivity(new Intent(this, YKMAdapterActivity.class));
                break;
            case R.id.qq_main:
                startActivity(new Intent(this, QQMainActivity.class));
                break;
            case R.id.wechat_main:
                startActivity(new Intent(this, WeChatMainActivity.class));
                break;
            case R.id.advice_banner:
                startActivity(new Intent(this, AdviceBarActivity.class));
                break;
            case R.id.sweet_dialog:

                break;
            case R.id.welcome_viewpager:
                startActivity(new Intent(this, WelcomeActivity.class));
                break;
            case R.id.welcome_viewpager1:
                startActivity(new Intent(this, Welcome1Activity.class));
                break;
            case R.id.my_Toast:
                startActivity(new Intent(this, ToastActivity.class));
                break;
            case R.id.my_greenDAO:
                startActivity(new Intent(this, GreenDAOActivity.class));
                break;
            case R.id.my_glide:
                startActivity(new Intent(this, GlideActivity.class));
                break;
        }
    }
}
