package com.truiton.activitytofragment;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.utils.DataHolder;
import com.utils.MyApplication;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements IFragmentToActivity {
    private final String LOG_TAG = "MainActivity";
    private PagerAdapter adapter;
    private TabLayout tabLayout;
    private IFragmentToActivity mCallback;
    MyApplication app;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        ArrayList<String> tabs = new ArrayList<>();
        tabs.add("Tab 1");
        tabs.add("Tab 2");
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        adapter = new PagerAdapter(getSupportFragmentManager(), tabs);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }




    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_refresh) {
            int position = tabLayout.getSelectedTabPosition();
            Fragment fragment = adapter.getFragment(tabLayout
                    .getSelectedTabPosition());
            if (fragment != null) {
                switch (position) {
                    case 0:
                        ((TabFragment1) fragment).onRefresh();
                        break;
                    case 1:
                        ((TabFragment2) fragment).onRefresh();
                        break;
                }
            }
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void showToast(String msg) {
        //String data = DataHolder.getInstance().getData();
        app = (MyApplication)getApplication();
        app.setData("Hello  Activity 2,from Fragment 1");
        Toast.makeText(this, "MainActivity:"+msg, Toast.LENGTH_LONG).show();
    }

    @Override
    public void communicateToFragment2() {
        TabFragment2 fragment = (TabFragment2) adapter.getFragment(1);
        if (fragment != null) {
            fragment.fragmentCommunication();
        } else {
            Log.i(LOG_TAG, "Fragment 2 is not initialized");
        }
    }
}
