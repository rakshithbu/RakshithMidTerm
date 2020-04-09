package com.example.rakshithmidterm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener, AdapterView.OnItemSelectedListener, CompoundButton.OnCheckedChangeListener, View.OnClickListener{

    RadioGroup rg;
    String checkedButtonId = "";
    TextView fee,hours, welcome,totalFee,totalHours;
    Spinner sp;
    String [] courses ={"Java","Swift","IOS","Android","Database"};
    int [] courseHours ={6,5,5,7,4};
    int [] coursefees = {1300, 1500, 1350, 1400, 1000};
    int totalCourseFees = 0;
    int totalCourseHours = 0;
    int pos =0;
    Button add;
    CheckBox ch1,ch2;
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
        totalFee = findViewById(R.id.totalFee);
        totalHours = findViewById(R.id.totalHours);
        welcome.setText("welcome  "+ login_activity.name.getText());
        sp=findViewById(R.id.spCourse);
        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,courses);
        aa.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        sp.setAdapter(aa);
        sp.setOnItemSelectedListener(this);
        add = findViewById(R.id.add);
        add.setOnClickListener(this);
        ch1=findViewById(R.id.accomodation);
        ch2=findViewById(R.id.medical);
        ch1.setOnCheckedChangeListener(this);
        ch2.setOnCheckedChangeListener(this);
    }


    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

        switch (group.getCheckedRadioButtonId()){
            case R.id.radioGrad:checkedButtonId="Grad";break;
            case R.id.radioNotGrad:checkedButtonId="NotGrad";break;
        }

        System.out.println(checkedButtonId);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        fee.setText(String.valueOf(coursefees[position]));
        hours.setText(String.valueOf(courseHours[position]));

        pos = position;


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

        if(buttonView.getText().toString().equalsIgnoreCase("Accomodation")){
            if(isChecked){
                totalCourseFees = totalCourseFees + 1000;
            }else{
                totalCourseFees = totalCourseFees - 1000;
            }
            totalFee.setText(String.valueOf(totalCourseFees));
        }

        if(buttonView.getText().toString().equalsIgnoreCase("Medical insurance")){
            if(isChecked){
                totalCourseFees = totalCourseFees + 700;
            }else{
                totalCourseFees = totalCourseFees - 700;
            }
            totalFee.setText(String.valueOf(totalCourseFees));
        }
        System.out.println(buttonView.getText());
        System.out.println(isChecked);
    }

    @Override
    public void onClick(View view) {
        if(checkedButtonId.equalsIgnoreCase("Grad")){
            System.out.println(courseHours[pos]);
            int tempHours = totalCourseHours +  courseHours[pos];
            if(tempHours >21){
                Toast.makeText(getApplicationContext(), "Cannot have total hours more than 21 for graduate", Toast.LENGTH_LONG).show();
            }else{
                totalCourseFees = totalCourseFees+ coursefees[pos];
                totalCourseHours = totalCourseHours + courseHours[pos];
            }
            totalHours.setText(String.valueOf(totalCourseHours));
            totalFee.setText(String.valueOf(totalCourseFees));

        }else if(checkedButtonId.equalsIgnoreCase("NotGrad")){

            int tempHours = totalCourseHours +  courseHours[pos];
                if(tempHours >19){
                Toast.makeText(getApplicationContext(), "Cannot have total hours more than 19 for undergraduate", Toast.LENGTH_LONG).show();
            }else{
                    totalCourseFees = totalCourseFees+ coursefees[pos];
                    totalCourseHours = totalCourseHours + courseHours[pos];
                }

            totalHours.setText(String.valueOf(totalCourseHours));
            totalFee.setText(String.valueOf(totalCourseFees));
        }else{
            Toast.makeText(getApplicationContext(), "Please select graduate or not graduate", Toast.LENGTH_LONG).show();
        }

    }
}
