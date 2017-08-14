package www.pdx.life.ykmtools.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;
/**
 * Created by wenxin on 2015/12/18.
 * 邮箱：kongming.yang@pdxchg.com
 */

/**
 * fragment的适配器
 */
public class WeChatFragmentPageAdapter extends FragmentPagerAdapter {

	private List<Fragment> fragmentsList;
	public WeChatFragmentPageAdapter(FragmentManager fm) {super(fm);}
	public WeChatFragmentPageAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        this.fragmentsList = fragments;
    }
	
	@Override
	public Fragment getItem(int index) {
		return fragmentsList.get(index);
	}

	@Override
	public int getCount() {
		return fragmentsList == null ? 0 : fragmentsList.size() ;
	}

	@Override
	public int getItemPosition(Object object) {
		return super.getItemPosition(object);
	}

}
