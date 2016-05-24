package mgit.tabactivityimpl;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddDetails extends AppCompatActivity {
    EditText day,hour,subj;
    Button ok,cancel;
    DatabaseHelper mydb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_details);
        mydb=new DatabaseHelper(this);
        day=(EditText)findViewById(R.id.day);
        hour=(EditText)findViewById(R.id.hour);
        subj=(EditText)findViewById(R.id.subj);
        ok=(Button)findViewById(R.id.ok);
        cancel=(Button)findViewById(R.id.cancel);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(day.getText().toString().matches("")){
                    Toast.makeText(AddDetails.this,"Data not Inserted",Toast.LENGTH_LONG).show();
                }
                else {
                    boolean isInserted = mydb.insertData(day.getText().toString(), subj.getText().toString(), hour.getText().toString());
                    day.setText("");
                    subj.setText("");
                    hour.setText("");
                    if (isInserted == true) {
                        Toast.makeText(AddDetails.this, "Data Inserted", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(AddDetails.this, "Data not Inserted", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(AddDetails.this,MainActivity.class);
                startActivity(i);
            }
        });
    }
}
