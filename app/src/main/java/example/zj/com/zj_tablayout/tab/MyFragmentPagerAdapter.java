package example.zj.com.zj_tablayout.tab;
/**
 * Created by zhengjiong on 15/6/9.
 */

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * create by zhengjiong
 * Date: 2015-06-09
 * Time: 14:24
 */
public class MyFragmentPagerAdapter extends FragmentPagerAdapter {

    private List<String> mTitle = new ArrayList<>();
    private List<Fragment> mFragments = new ArrayList<>();

    public MyFragmentPagerAdapter(FragmentManager fragmentManager, List<String> titles, List<Fragment> fragments) {
        super(fragmentManager);

        this.mTitle = titles;
        this.mFragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitle.get(position);
    }
}
