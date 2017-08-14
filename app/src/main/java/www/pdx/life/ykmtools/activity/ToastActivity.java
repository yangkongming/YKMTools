package www.pdx.life.ykmtools.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import butterknife.BindView;
import es.dmoral.toasty.Toasty;
import www.pdx.life.ykmtools.R;
import www.pdx.life.ykmtools.base.BaseActivity;

/**
 * Toast工具类
 */
public class ToastActivity extends BaseActivity implements View.OnClickListener {

    @BindView(R.id.button1)
    Button btn1;
    @BindView(R.id.button2)
    Button btn2;
    @BindView(R.id.button3)
    Button btn3;
    @BindView(R.id.button4)
    Button btn4;
    @BindView(R.id.button5)
    Button btn5;
    @BindView(R.id.button6)
    Button btn6;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);
        initClick();
    }

    public void initClick() {
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:
                Toasty.error(this, "This is an error toast.", Toast.LENGTH_SHORT, true).show();
                break;
            case R.id.button2:
                Toasty.success(this, "Success!", Toast.LENGTH_SHORT, true).show();
                break;
            case R.id.button3:
                Toasty.info(this, "Here is some info for you.", Toast.LENGTH_SHORT, true).show();
                break;
            case R.id.button4:
                Toasty.warning(this, "Beware of the dog.", Toast.LENGTH_SHORT, true).show();
                break;
            case R.id.button5:
                Toasty.normal(this, "Normal toast w/o icon").show();
                break;
            case R.id.button6:
                Toasty.normal(this, "Normal toast w/ icon", R.mipmap.btn_nor_baby).show();
                break;
        }
    }
}
