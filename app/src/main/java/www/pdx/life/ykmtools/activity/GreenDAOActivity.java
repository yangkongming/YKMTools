package www.pdx.life.ykmtools.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import www.pdx.life.ykmandroidtools.db.DaoSession;
import www.pdx.life.ykmandroidtools.db.UserDao;
import www.pdx.life.ykmtools.bean.User;
import www.pdx.life.ykmtools.R;
import www.pdx.life.ykmtools.base.BaseActivity;
import www.pdx.life.ykmtools.manager.GreenDaoManager;


/**
 * GreenDao使用例子
 */
public class GreenDAOActivity extends BaseActivity implements View.OnClickListener {

    @BindView(R.id.add)
    Button addBean;
    @BindView(R.id.query)
    Button queryBean;
    @BindView(R.id.delete)
    Button deleteBean;
    @BindView(R.id.update)
    Button updateBean;
    @BindView(R.id.test_greendao)
    TextView showText;

    DaoSession mDaoSession;
    UserDao mUserDao;
    User mUser;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_green_dao);
        initClick();
        mDaoSession=GreenDaoManager.getDaoSession();
        mUserDao = mDaoSession.getUserDao();
        mUser = new User();
    }

    public void initClick() {
        addBean.setOnClickListener(this);
        queryBean.setOnClickListener(this);
        deleteBean.setOnClickListener(this);
        updateBean.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.add:
                mUser = new User((long) 1, "杨空明");
                mUserDao.insert(mUser);
                showText.setText(mUser.getId() + mUser.getName());
                break;
            case R.id.delete:
                mUserDao.deleteByKey((long) 1);
                break;
            case R.id.query:
                mUser = mUserDao.queryBuilder().where(UserDao.Properties.Id.eq(1)).unique();
                if (null != mUser) {
                    showText.setText(mUser.getId() + mUser.getName());
                }
                break;
            case R.id.update:
                mUser = new User((long) 1, "黄国强");
                mUserDao.update(mUser);
                if (null != mUser) {
                    showText.setText(mUser.getId() + mUser.getName());
                }
                break;
        }

    }

}
