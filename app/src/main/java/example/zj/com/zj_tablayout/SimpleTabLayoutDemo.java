package example.zj.com.zj_tablayout;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import example.zj.com.zj_tablayout.fragment.SimpleFragment;

/**
 * TabLayout基本用法
 *
 * create by zhengjiong
 * Date: 2015-06-09
 * Time: 12:08
 */
public class SimpleTabLayoutDemo extends AppCompatActivity{
    private Toolbar mToolbar;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;

    private List<String> mTitles = Arrays.asList("tab1", "tab2", "tab3");
    private List<Fragment> mFragment = new ArrayList<>();
    private MyFragmentPagerAdapter mPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simple_tablayout_layout_demo);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mTabLayout = (TabLayout) findViewById(R.id.tablayout);
        mViewPager = (ViewPager) findViewById(R.id.viewpager);

        initToolbar();
        initViewPager();
        initTabLayout();
    }

    private void initViewPager() {
        mFragment.add(SimpleFragment.newInstance("item1"));
        mFragment.add(SimpleFragment.newInstance("item2"));
        mFragment.add(SimpleFragment.newInstance("item3"));

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

        mTabLayout.setupWithViewPager(mViewPager);
        mTabLayout.setTabsFromPagerAdapter(mPagerAdapter);

        //style中colorAccent设置Tablayout的indicator
    }
    private void initToolbar() {
        mToolbar.setTitle("SimpleTabLayout Demo");
        setSupportActionBar(mToolbar);

        getSupportActionBar().setHomeAsUpIndicator(R.mipmap.ic_menu);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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
