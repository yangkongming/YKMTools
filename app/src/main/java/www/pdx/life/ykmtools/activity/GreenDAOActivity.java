package www.pdx.life.ykmtools.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import www.pdx.life.ykmtools.R;
import www.pdx.life.ykmtools.base.BaseActivity;
import www.pdx.life.ykmtools.bean.Student;
import www.pdx.life.ykmtools.bean.User;
import www.pdx.life.ykmtools.db.StudentDao;
import www.pdx.life.ykmtools.db.UserDao;

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

    UserDao mUserDao;
    User mUser;
    StudentDao mStudentDao;
    Student mStudent;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_green_dao);
        initClick();
        mUserDao = MyApplication.getInstances().getDaoSession().getUserDao();
        mStudentDao = MyApplication.getInstances().getDaoSession().getStudentDao();
        mUser = new User();
        mStudent = new Student();
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
                mStudent = new Student((long) 1, "杨空明");
                mStudentDao.insert(mStudent);
                break;
            case R.id.delete:
                mStudentDao.deleteByKey((long) 1);
                break;
            case R.id.query:
                mStudent = mStudentDao.queryBuilder().where(StudentDao.Properties.Id.eq(1)).unique();
                break;
            case R.id.update:
                mStudent = new Student((long) 1, "黄国强");
                mStudentDao.update(mStudent);
                break;
        }
    }

}
