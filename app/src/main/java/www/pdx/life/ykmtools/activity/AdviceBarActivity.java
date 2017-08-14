package www.pdx.life.ykmtools.activity;

import android.app.Activity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import www.pdx.life.ykmtools.R;
import www.pdx.life.ykmtools.viewUtils.advice.FlyBanner;

/**
 * 广告轮播图
 */
public class AdviceBarActivity extends Activity {

    private FlyBanner mBannerLocal;
    private List<Integer> images = new ArrayList<>();
    private List<String> imageUrls = new ArrayList<>();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advice_bar);
        mBannerLocal = (FlyBanner) findViewById(R.id.baby_baar);
        mBannerLocal.setOnItemClickListener(new FlyBanner.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                // TODO: 2016/7/19 点击每一项触发的事件
            }
        });

    }


    @Override
    public void onResume() {
        super.onResume();
        initFlyBanner();  //启动轮播图
    }

    @Override
    protected void onPause() {
        super.onPause();
        mBannerLocal.stopAutoPlay();
    }

    /**
     * 图片轮播
     */
    private void initFlyBanner() {
        images.clear();
        images.add(R.drawable.pdx2);
        images.add(R.drawable.pdx1);
        images.add(R.drawable.pdx4);
        images.add(R.drawable.pdx3);
        mBannerLocal.setImages(images);
    }


    private void initsetFlayBanner() {
        imageUrls.clear();
        imageUrls.add("http://pic6.huitu.com/res/20130116/84481_20130116142820494200_1.jpg");
        imageUrls.add("http://img02.tooopen.com/images/20140504/sy_60294738471.jpg");
        imageUrls.add("http://imgsrc.baidu.com/forum/pic/item/e5ff0081cb237db138012f73.jpg");
        imageUrls.add("http://img3.imgtn.bdimg.com/it/u=1303680113,133301350&fm=23&gp=0.jpg");
        mBannerLocal.setImagesUrl(imageUrls);
    }
}
