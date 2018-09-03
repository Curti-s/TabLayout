package matthews.curtis.tablayoutexample;

import android.support.design.widget.TabItem;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ContentFrameLayout;
import android.support.v7.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    android.support.v7.widget.Toolbar mToolbar;
    TabLayout mTabLayout;
    ViewPager mViewPager;
    TabItem chatTabItem, statusTabItem, callTabItem;
    PageAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // set toolbar title
        mToolbar = findViewById(R.id.toolbar);
        mToolbar.setTitle(getResources().getString(R.string.app_name));
        setSupportActionBar(mToolbar);

        mTabLayout =  findViewById(R.id.tablayout);
        chatTabItem = findViewById(R.id.tabChats);
        statusTabItem =  findViewById(R.id.tabStatus);
        callTabItem =  findViewById(R.id.tabChats);
        mViewPager =  findViewById(R.id.viewpager);

        adapter = new PageAdapter(getSupportFragmentManager(), mTabLayout.getTabCount());
        mViewPager.setAdapter(adapter);

        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mViewPager.setCurrentItem(tab.getPosition());
                if(tab.getPosition() == 1) {
                    mToolbar.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.colorAccent));
                    mTabLayout.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.colorAccent));
                }
                else if(tab.getPosition() == 2) {
                    mToolbar.setBackgroundColor(ContextCompat.getColor(MainActivity.this,R.color.darker_grey));
                    mTabLayout.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.darker_grey));
                }
                else {
                    mTabLayout.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.colorPrimary));
                    mToolbar.setBackgroundColor(ContextCompat.getColor(MainActivity.this,R.color.colorPrimary));
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}
