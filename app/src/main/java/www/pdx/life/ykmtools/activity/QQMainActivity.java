package www.pdx.life.ykmtools.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import butterknife.BindView;
import www.pdx.life.ykmtools.R;
import www.pdx.life.ykmtools.base.BaseFragmentActivity;
import www.pdx.life.ykmtools.fragement.HomeFragment;
import www.pdx.life.ykmtools.fragement.MyFragment;


/**
 * qq主导框架
 */
public class QQMainActivity extends BaseFragmentActivity {

    private long exitTime = 0;
    public static final String fragment1Tag = "fragment1";
    public static final String fragment2Tag = "fragment2";
    public static final String fragment3Tag = "fragment3";
    private Fragment fragment1 = null;
    private Fragment fragment2 = null;
    private Fragment fragment3 = null;

    @BindView(R.id.activity_group_radioGroup)
    RadioGroup radioGroup;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qqmain);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            public void onCheckedChanged(RadioGroup group, int checkedId) {
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                if (fragment1 == null) {
                    fragment1 = fm.findFragmentByTag(fragment1Tag);
                }
                if (fragment2 == null) {
                    fragment2 = fm.findFragmentByTag(fragment2Tag);
                }
                if (fragment3 == null) {
                    fragment3 = fm.findFragmentByTag(fragment3Tag);
                }
                if (fragment1 != null) {
                    ft.hide(fragment1);
                }
                if (fragment2 != null) {
                    ft.hide(fragment2);
                }
                if (fragment3 != null) {
                    ft.hide(fragment3);
                }
                switch (checkedId) {
                    case R.id.merchant_home:
                        if (fragment1 == null) {
                            fragment1 = new HomeFragment();
                            ft.add(R.id.container, fragment1, fragment1Tag);
                        } else {
                            ft.show(fragment1);
                        }
                        break;
                    case R.id.merchant_company:
                        if (fragment2 == null) {
                            fragment2 = new MyFragment();
                            ft.add(R.id.container, fragment2, fragment2Tag);
                        } else {
                            ft.show(fragment2);
                        }
                        break;
                    case R.id.merchant_my:
                        if (fragment3 == null) {
                            fragment3 = new HomeFragment();
                            ft.add(R.id.container, fragment3,
                                    fragment3Tag);
                        } else {
                            ft.show(fragment3);
                        }
                        break;
                    default:
                        break;
                }
                ft.commit();
            }
        });
        if (savedInstanceState == null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            Fragment fragment = new HomeFragment();
            fragmentManager.beginTransaction()
                    .replace(R.id.container, fragment, fragment1Tag).commit();
        }
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        for (int i = 0; i < radioGroup.getChildCount(); i++) {
            RadioButton mTab = (RadioButton) radioGroup.getChildAt(i);

            FragmentManager fm = getSupportFragmentManager();
            Fragment fragment = fm.findFragmentByTag((String) mTab.getTag());
            FragmentTransaction ft = fm.beginTransaction();
            if (fragment != null) {
                if (!mTab.isChecked()) {
                    ft.hide(fragment);
                }
            }
            ft.commit();
        }
    }

    /**
     * 点击两次返回键退出
     *
     * @param keyCode
     * @param event
     * @return
     */
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exit();
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }

    /**
     * 退出程序
     */
    private void exit() {
        if ((System.currentTimeMillis() - exitTime) > 2000) {
            Toast.makeText(this, "", Toast.LENGTH_LONG).show();
            exitTime = System.currentTimeMillis();
        } else {
            finish();
            System.exit(0);
        }
    }
}
