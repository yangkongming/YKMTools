package www.pdx.life.ykmtools.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import www.pdx.life.ykmtools.R;
import www.pdx.life.ykmtools.adapter.WeChatFragmentPageAdapter;
import www.pdx.life.ykmtools.fragement.HomeFragment;
import www.pdx.life.ykmtools.fragement.MyFragment;
import www.pdx.life.ykmtools.viewUtils.weChat.GradientIconView;
import www.pdx.life.ykmtools.viewUtils.weChat.GradientTextView;


/**
 * 微信主导框架
 */
public class WeChatMainActivity extends FragmentActivity implements View.OnClickListener {

    private ViewPager mViewPager;
    private List<Fragment> mTabs = new ArrayList<>();
    private List<GradientIconView> mTabIconIndicator = new ArrayList<>();
    private List<GradientTextView> mTabTextIndicator = new ArrayList<>();
    private GradientIconView mChatsIconView;
    private GradientIconView mContactsIconView;
    private GradientIconView mDiscoverIconView;
    private GradientIconView mAboutMeIconView;

    private GradientTextView mTvChats;
    private GradientTextView mTvContacts;
    private GradientTextView mTvDiscover;
    private GradientTextView mTvAboutMe;
    private WeChatFragmentPageAdapter mAdapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_we_chat);
        initView();
    }

    private void initView() {
        mViewPager = (ViewPager) findViewById(R.id.main_viewpager);
        mViewPager.setOffscreenPageLimit(4);
        mChatsIconView = (GradientIconView) findViewById(R.id.main_baby);
        mChatsIconView.setOnClickListener(this);
        mTabIconIndicator.add(mChatsIconView);
        mChatsIconView.setIconAlpha(1.0f);

        mContactsIconView = (GradientIconView) findViewById(R.id.main_share);
        mContactsIconView.setOnClickListener(this);
        mTabIconIndicator.add(mContactsIconView);

        mDiscoverIconView = (GradientIconView) findViewById(R.id.main_contact);
        mDiscoverIconView.setOnClickListener(this);
        mTabIconIndicator.add(mDiscoverIconView);

        mAboutMeIconView = (GradientIconView) findViewById(R.id.main_me);
        mAboutMeIconView.setOnClickListener(this);
        mTabIconIndicator.add(mAboutMeIconView);

        mTvChats = (GradientTextView) findViewById(R.id.main_baby_text);
        mTvChats.setOnClickListener(this);
        mTabTextIndicator.add(mTvChats);
        mTvChats.setTextViewAlpha(1.0f);

        mTvContacts = (GradientTextView) findViewById(R.id.main_share_text);
        mTvContacts.setOnClickListener(this);
        mTabTextIndicator.add(mTvContacts);

        mTvDiscover = (GradientTextView) findViewById(R.id.main_contact_text);
        mTvDiscover.setOnClickListener(this);
        mTabTextIndicator.add(mTvDiscover);

        mTvAboutMe = (GradientTextView) findViewById(R.id.main_me_text);
        mTvAboutMe.setOnClickListener(this);
        mTabTextIndicator.add(mTvAboutMe);

        initFragments();
    }

    private void initFragments() {
        mTabs.add(new HomeFragment());
        mTabs.add(new MyFragment());
        mTabs.add(new HomeFragment());
        mTabs.add(new MyFragment());
        mAdapter = new WeChatFragmentPageAdapter(getSupportFragmentManager(), mTabs);

        mViewPager.setAdapter(mAdapter);
        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if (positionOffset > 0) {
                    GradientIconView iconLeft = mTabIconIndicator.get(position);
                    GradientIconView iconRight = mTabIconIndicator.get(position + 1);

                    GradientTextView textLeft = mTabTextIndicator.get(position);
                    GradientTextView textRight = mTabTextIndicator.get(position + 1);

                    iconLeft.setIconAlpha(1 - positionOffset);
                    textLeft.setTextViewAlpha(1 - positionOffset);
                    iconRight.setIconAlpha(positionOffset);
                    textRight.setTextViewAlpha(positionOffset);
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    /**
     * 重置其他的Tab
     */
    private void resetOtherTabs() {
        resetOtherTabIcons();
        resetOtherTabText();
    }

    /**
     * 重置其他的Tab icon
     */
    private void resetOtherTabIcons() {
        for (int i = 0; i < mTabIconIndicator.size(); i++) {
            mTabIconIndicator.get(i).setIconAlpha(0);
        }
    }

    /**
     * 重置其他的Tab text
     */
    private void resetOtherTabText() {
        for (int i = 0; i < mTabTextIndicator.size(); i++) {
            mTabTextIndicator.get(i).setTextViewAlpha(0);
        }
    }

    @Override
    public void onClick(View v) {
        resetOtherTabs();
        switch (v.getId()) {
            case R.id.main_baby:
            case R.id.main_baby_text:
                mTabIconIndicator.get(0).setIconAlpha(1.0f);
                mTabTextIndicator.get(0).setTextViewAlpha(1.0f);
                mViewPager.setCurrentItem(0, false);
                break;
            case R.id.main_share:
            case R.id.main_share_text:
                mTabIconIndicator.get(1).setIconAlpha(1.0f);
                mTabTextIndicator.get(1).setTextViewAlpha(1.0f);
                mViewPager.setCurrentItem(1, false);
                break;
            case R.id.main_contact:
            case R.id.main_contact_text:
                mTabIconIndicator.get(2).setIconAlpha(1.0f);
                mTabTextIndicator.get(2).setTextViewAlpha(1.0f);
                mViewPager.setCurrentItem(2, false);
                break;
            case R.id.main_me:
            case R.id.main_me_text:
                mTabIconIndicator.get(3).setIconAlpha(1.0f);
                mTabTextIndicator.get(3).setTextViewAlpha(1.0f);
                mViewPager.setCurrentItem(3, false);
                break;
        }
    }
}
