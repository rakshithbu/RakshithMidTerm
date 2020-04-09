package com.example.rakshithmidterm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener, AdapterView.OnItemSelectedListener, CompoundButton.OnCheckedChangeListener{

    RadioGroup rg;
    String checkedButtonId = "";
    TextView fee,hours, welcome;
    Spinner sp;
    String [] courses ={"Java","Swift","IOS","Android","Database"};
    int [] courseHours ={6,5,5,7,4};
    int [] coursefees = {1300, 1500, 1350, 1400, 1000};
    int totalCourseFees = 0;
    int totalCourseHours = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_login_activity);
        setContentView(R.layout.activity_main);
        rg=findViewById(R.id.radioSelect);
        rg.setOnCheckedChangeListener(this);
        fee=findViewById(R.id.fee);
        hours=findViewById(R.id.hours);
        welcome = findViewById(R.id.welcome);
       // welcome.setText("welcome "+ login.name.getText())
        sp=findViewById(R.id.spCourse);
        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,courses);
        aa.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        sp.setAdapter(aa);
        sp.setOnItemSelectedListener(this);
    }


    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        group.getCheckedRadioButtonId();

        switch (group.getCheckedRadioButtonId()){
            case R.id.radioGrad:checkedButtonId="Grad";break;
            case R.id.radioNotGrad:checkedButtonId="NotGrad";break;
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        fee.setText(String.valueOf(coursefees[position]));
        hours.setText(String.valueOf(courseHours[position]));


        totalCourseFees = totalCourseFees+ coursefees[position];
        totalCourseHours = totalCourseHours + courseHours[position];
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

    }
}
