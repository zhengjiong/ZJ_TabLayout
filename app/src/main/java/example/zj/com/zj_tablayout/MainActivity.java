package example.zj.com.zj_tablayout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import example.zj.com.zj_tablayout.tab.AutoHideTabLayoutDemo1;
import example.zj.com.zj_tablayout.tab.AutoHideTabLayoutDemo2;
import example.zj.com.zj_tablayout.tab.AutoHideTabLayoutDemo3;
import example.zj.com.zj_tablayout.tab.AutoHideTabLayoutDemo4;
import example.zj.com.zj_tablayout.tab.AutoHideTabLayoutDemo5;
import example.zj.com.zj_tablayout.tab.SimpleTabLayoutDemo;

/**
 * TabLayout Demo
 *
 * @author zhengjiong
 * @date 2015年06月09日10:44:57
 */
public class MainActivity extends AppCompatActivity {

    private ListView mListView;
    private String[] mItems = new String[]{
            "Simple TabLayout",
            "上滑隐藏Toolbar,下滑显示Toolbar",
            "上滑全部隐藏,下滑全部显示",
            "上滑全部隐藏,下滑到顶部时显示Toolbar",
            "上滑只隐藏Toolbar,下滑到顶部显示Toolbar(没有成功)",
            "仿饿了么外卖首页"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView = (ListView) findViewById(R.id.listview);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                mItems
        );

        mListView.setAdapter(arrayAdapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        startActivity(new Intent(MainActivity.this, SimpleTabLayoutDemo.class));
                        break;
                    case 1:
                        startActivity(new Intent(MainActivity.this, AutoHideTabLayoutDemo1.class));
                        break;
                    case 2:
                        startActivity(new Intent(MainActivity.this, AutoHideTabLayoutDemo2.class));
                        break;
                    case 3:
                        startActivity(new Intent(MainActivity.this, AutoHideTabLayoutDemo3.class));
                        break;
                    case 4:
                        startActivity(new Intent(MainActivity.this, AutoHideTabLayoutDemo4.class));
                        break;
                    case 5:
                        startActivity(new Intent(MainActivity.this, AutoHideTabLayoutDemo5.class));
                        break;
                }
            }
        });
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
