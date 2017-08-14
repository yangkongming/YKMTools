package www.pdx.life.ykmtools.activity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import www.pdx.life.ykmtools.R;
import www.pdx.life.ykmtools.adapter.ListAdapter;
import www.pdx.life.ykmtools.base.BaseActivity;
import www.pdx.life.ykmtools.bean.MessageBean;

/**
 * 万能适配器
 */
public class YKMAdapterActivity extends BaseActivity {


    @BindView(R.id.lv_list)
    ListView lvList;

    private ListAdapter listAdapter;

    private List<MessageBean> msgArray;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ykmadapter);
        initShow();
    }

    private void initShow() {
        initData();
        listAdapter = new ListAdapter(this, R.layout.list_item, msgArray);
        lvList.setAdapter(listAdapter);
    }

    //装载数据
    private void initData() {
        msgArray = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            MessageBean bean = new MessageBean("Android 自定义标题栏", "今天来看一下如何通过组合多个控件实现自定义标题栏众所周知，标题栏是应用中必不可少的控件，为了避免多次重写，将其封装起来，供每个布局调用即可。这里我们采用经典的左中右布局，也可以根据项目需要自行调整，比如在右侧再加一个控件，或者将标题偏左都可以注：其中应用到了上一篇文章中的ButtonM控件，大家可以", 0, 273);
            msgArray.add(bean);
        }
    }
}
