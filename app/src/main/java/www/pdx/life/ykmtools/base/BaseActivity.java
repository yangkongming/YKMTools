package www.pdx.life.ykmtools.base;

import android.app.Activity;
import android.view.View;

import butterknife.ButterKnife;

public abstract class BaseActivity extends Activity {


    public void setContentView(View view) {
        super.setContentView(view);
        ButterKnife.bind(this);
    }

    public void setContentView(int layoutResID) {
        View view = View.inflate(this, layoutResID,null);
        this.setContentView(view);
    }

}
