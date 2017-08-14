package www.pdx.life.ykmtools.base;


import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;


public  abstract  class BaseFragment extends Fragment {


    public View setLayout(int layoutResID, LayoutInflater inflater, ViewGroup container) {
        View view= inflater.inflate(layoutResID, container, false);
        ButterKnife.bind(this, view);
        return view;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
