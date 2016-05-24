package mgit.tabactivityimpl;


import android.app.AlertDialog;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


/**
 * A simple {@link Fragment} subclass.
 */
public class Mon extends Fragment {

    DatabaseHelper mydb;
    ListView lv,attLv;
    ArrayList<String> strArr;
    ArrayAdapter<String> adapter,adapter2;
    Button display;
    View view;
    public Mon() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_mon, container, false);
        mydb=new DatabaseHelper(getContext());
       display=(Button)view.findViewById(R.id.disp);
        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lv=(ListView)view.findViewById(R.id.listView);
                strArr=new ArrayList<String>();

        /*Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();
        //this will return Day in Three letter format like Mon,Tue,Wed....with first letter caps
        String s=new SimpleDateFormat("EE", Locale.ENGLISH).format(date.getTime());*/
                Cursor res=mydb.getAllData("mon");//passing day as argument

                if(res.getCount()==0){
                    showMessage("Error","no data inserted");

                }

                while(res.moveToNext()){

                    strArr.add(res.getString(2) + "\n"+ res.getString(3));

                    //adapter.notifyDataSetChanged();
                }
                adapter=new ArrayAdapter<String>(getContext(),android.R.layout.simple_list_item_1,strArr);
                lv.setAdapter(adapter);
            }
        });
        return inflater.inflate(R.layout.fragment_mon, container, false);
    }
    public void showMessage(String title,String message){
        AlertDialog.Builder builder=new AlertDialog.Builder(getContext());
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }

}
