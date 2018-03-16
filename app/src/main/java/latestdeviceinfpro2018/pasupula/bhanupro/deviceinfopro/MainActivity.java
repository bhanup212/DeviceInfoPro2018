package latestdeviceinfpro2018.pasupula.bhanupro.deviceinfopro;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    protected FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar = findViewById(R.id.tool_bar);
        setSupportActionBar(mToolbar);

        mViewPager = findViewById(R.id.view_pager);
        setUpViewPager(mViewPager);

        mTabLayout = findViewById(R.id.tab_layout);
        mTabLayout.setupWithViewPager(mViewPager);
        mTabLayout.setTabTextColors(R.color.white,R.color.colorAccent);

        mTabLayout.getTabAt(0).setIcon(R.drawable.smartphone);
        mTabLayout.getTabAt(1).setIcon(R.drawable.developer_mode);
        mTabLayout.getTabAt(2).setIcon(R.drawable.device_information);

        fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Rate this app",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://play.google.com/store/apps/developer?id=latestdeviceinfpro2018.pasupula.bhanupro.deviceinfopro"));
                startActivity(intent);
                //PackageManager p = getPackageManager();
                //ComponentName name = new ComponentName("com.whatsapp","com.whatsapp.LauncherActivity");
                //p.setComponentEnabledSetting(name,PackageManager.COMPONENT_ENABLED_STATE_DISABLED,PackageManager.DONT_KILL_APP);
                //Toast.makeText(getApplicationContext(),"whatspp hideed succ",Toast.LENGTH_SHORT).show();
            }
        });


    }
    public void setUpViewPager(ViewPager viewPager){
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new DeviceFragment(),"Device Info");
        adapter.addFragment(new HardwareFragment(),"Hardware Info");
        adapter.addFragment(new RootFragment(),"Root Info");
        viewPager.setAdapter(adapter);
    }


    class ViewPagerAdapter extends FragmentPagerAdapter{
        int[] icon = {
                R.drawable.smartphone
        };
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmetnTitleList = new ArrayList<>();
        //private final List<Integer> mFragmentIcon = new ArrayList<>();
        //private final List<Integer> mFragmentIcon = new ArrayList<Integer>(icon.length);




        public ViewPagerAdapter(FragmentManager fm){
            super(fm);
        }
        public Fragment getItem(int position){
            return mFragmentList.get(position);
        }
        public int getCount(){
            return mFragmentList.size();
        }
        public void addFragment(Fragment fragment,String title){
            mFragmentList.add(fragment);
            mFragmetnTitleList.add(title);
            //mFragmentIcon.add(icon);
        }
        public CharSequence getPageTitle(int position){
            return mFragmetnTitleList.get(position);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu,menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (R.id.share_menu == item.getItemId()){
            Toast.makeText(getApplicationContext(),"Share this app with your friends",Toast.LENGTH_LONG).show();
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse("https://play.google.com/store/apps/developer?id=Pasupula"));
            startActivity(i);
        }else if (R.id.more_apps == item.getItemId()){
            Toast.makeText(getApplicationContext(),"More apps from pasupula",Toast.LENGTH_LONG).show();
            try{
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("market://developer?id=Pasupula"));
                startActivity(i);
            }catch (Exception e){
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://play.google.com/store/apps/developer?id=Pasupula"));
                startActivity(intent);
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
