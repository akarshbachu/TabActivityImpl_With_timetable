package mgit.tabactivityimpl;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    TabLayout tabLayout;
    ViewPager viewPager;
    ViewPagerAdapter viewPagerAdapter;
    DatabaseHelper mydb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mydb=new DatabaseHelper(this);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/
                Intent i=new Intent(MainActivity.this,AddDetails.class);
                startActivity(i);

            }
        });
        //setting toolbar inplace of action bar
        toolbar=(Toolbar)findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        tabLayout=(TabLayout)findViewById(R.id.tabLayout);//its is the tab bar
        viewPager=(ViewPager)findViewById(R.id.viewPager);//the area below tha tab bar i.e content section
        viewPagerAdapter=new ViewPagerAdapter(getSupportFragmentManager());
        //adding each fragment to pager adapter
        //to add new fragment just do as below
        viewPagerAdapter.addFragments(new Mon(),"Mon");//parameters 1.instance of frag class 2.title for tab
        viewPagerAdapter.addFragments(new Tue(),"Tue");
        viewPagerAdapter.addFragments(new Wed(),"Wed");
        viewPagerAdapter.addFragments(new Thu(),"Thu");
        viewPagerAdapter.addFragments(new Thu(),"Thu");
        viewPagerAdapter.addFragments(new Thu(),"Thu");
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

    }
}
