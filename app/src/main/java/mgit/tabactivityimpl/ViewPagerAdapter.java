package mgit.tabactivityimpl;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by bachu_000 on 24-05-2016.
 */
public class ViewPagerAdapter extends FragmentPagerAdapter {

    ArrayList<Fragment> fragments=new ArrayList<>();//to hold  the fragment objects
    ArrayList<String> tabTitles=new ArrayList<>();

   public ViewPagerAdapter(FragmentManager fm){
       super(fm);
   }
    //this method is to add fragments
    public void addFragments(Fragment fragments,String tabTitles){
        this.fragments.add(fragments);//adding fragments object to arraylist
        this.tabTitles.add(tabTitles);//adding tabtitles to tabTitles arraylist
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);//getting the fragment obj from fragments arraylist
    }

    @Override
    public int getCount() {
        return fragments.size();//it will return how many objects are there inside the array list
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles.get(position);//getting tabTitles from above declared tabTitles ArrayList
    }
}
