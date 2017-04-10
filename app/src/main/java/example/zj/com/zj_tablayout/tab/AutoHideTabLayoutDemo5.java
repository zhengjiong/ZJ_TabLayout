package example.zj.com.zj_tablayout.tab;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import example.zj.com.zj_tablayout.R;
import example.zj.com.zj_tablayout.fragment.TwoRecyclerViewFragment;

/**
 * Title: AutoHideTabLayoutDemo5
 * Description: 仿饿了么外卖首页
 * Copyright:Copyright(c)2016
 * CreateTime:17/4/7  14:34
 * @author 郑炯
 * @version 1.0
 */

public class AutoHideTabLayoutDemo5 extends AppCompatActivity{
    //private Toolbar mToolbar;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;

    private List<String> mTitles = Arrays.asList("tab1", "tab2", "tab3", "tab4", "tab5");
    private List<Fragment> mFragment = new ArrayList<>();
    private MyFragmentPagerAdapter mPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tablayout_demo5_layout);

        AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.appbarlayout);
        //mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mTabLayout = (TabLayout) findViewById(R.id.tablayout);
        mViewPager = (ViewPager) findViewById(R.id.viewpager);


        initToolbar();
        initViewPager();
        initTabLayout();
    }

    private void initViewPager() {
        mFragment.add(TwoRecyclerViewFragment.newInstance());
        mFragment.add(TwoRecyclerViewFragment.newInstance());
        mFragment.add(TwoRecyclerViewFragment.newInstance());
        mFragment.add(TwoRecyclerViewFragment.newInstance());
        mFragment.add(TwoRecyclerViewFragment.newInstance());

        mPagerAdapter = new MyFragmentPagerAdapter(
                getSupportFragmentManager(),
                mTitles,
                mFragment
        );

        mViewPager.setAdapter(mPagerAdapter);
    }

    private void initTabLayout() {
        mTabLayout.addTab(mTabLayout.newTab().setText(mTitles.get(0)), true);
        mTabLayout.addTab(mTabLayout.newTab().setText(mTitles.get(1)));
        mTabLayout.addTab(mTabLayout.newTab().setText(mTitles.get(2)));
        mTabLayout.addTab(mTabLayout.newTab().setText(mTitles.get(3)));
        mTabLayout.addTab(mTabLayout.newTab().setText(mTitles.get(4)));

        mTabLayout.setupWithViewPager(mViewPager);
        mTabLayout.setTabsFromPagerAdapter(mPagerAdapter);
    }

    private void initToolbar() {
        //mToolbar.setTitle("");
        //setSupportActionBar(mToolbar);

        //getSupportActionBar().setHomeAsUpIndicator(R.mipmap.ic_menu);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
