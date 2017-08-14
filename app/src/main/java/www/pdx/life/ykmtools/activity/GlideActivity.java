package www.pdx.life.ykmtools.activity;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import www.pdx.life.ykmtools.R;
import www.pdx.life.ykmtools.base.BaseActivity;

/**
 * Glide使用例子
 */
public class GlideActivity extends BaseActivity {

    @BindView(R.id.glide_img)
    ImageView mImg;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glide);

        Glide.with(GlideActivity.this)
                .load("http://img.my.csdn.net/uploads/201407/26/1406383299_1976.jpg")
                .centerCrop()
                .placeholder(R.mipmap.ic_launcher)
                .crossFade()
                .into(mImg);
    }
}
