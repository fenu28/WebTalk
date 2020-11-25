package com.example.android.webtalktrial;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

public class AddWebinar extends AppCompatActivity {
    private EditText webinarName;
    private EditText webinarHost;
    private EditText webinarTopic;
    private EditText webinarInfo;
    private EditText webinarRegistrationURL;
    private EditText webinarStreamURL;
    private EditText webinarAddedBy;
    private TextView webinarDate;
    private TextView webinarTime;
    private Button addButton;
    private BottomNavigationView mBottomNavigationView;
    private DatabaseReference webinarDatabase;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    private TimePickerDialog.OnTimeSetListener mTimeSetListener;
    private String date;
    private String time;
    private String am_pm;
    private ActionBar mActionBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_webinar);

        webinarName = (EditText)findViewById(R.id.webinarName);
        webinarHost = (EditText)findViewById(R.id.webinarHost);
        webinarTopic = (EditText)findViewById(R.id.webinarTopic);
        webinarDate = (TextView) findViewById(R.id.webinarDate);
        webinarTime = (TextView) findViewById(R.id.webinarTime);
        webinarInfo = (EditText)findViewById(R.id.webinarInfo);
        webinarRegistrationURL = (EditText)findViewById(R.id.webinarRegistrationURL);
        webinarStreamURL = (EditText)findViewById(R.id.webinarStreamURL);
        webinarAddedBy = (EditText)findViewById(R.id.webinarAddedBy);
        addButton = (Button)findViewById(R.id.addButton);
        webinarDatabase = FirebaseDatabase.getInstance().getReference("webinar");
        mBottomNavigationView = findViewById(R.id.bottom_navigation);
        Menu menu = mBottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(2);
        menuItem.setChecked(true);

        mBottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId())
                {
                    case R.id.add_webinar:
                        break;
                    case R.id.home:
                    {
                        Intent intent = new Intent(AddWebinar.this,MainActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                        break;
                    }
                    case R.id.search:
                    {
                        Intent intent = new Intent(AddWebinar.this,SearchWebinar.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                        break;
                    }
                    case R.id.featured:
                    {
                        Intent intent = new Intent(AddWebinar.this,FeaturedWebinar.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                        break;
                    }
                    case R.id.about:
                    {
                        Intent intent = new Intent(AddWebinar.this,SettingsActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                        break;
                    }
                }
                return false;
            }
        });
        mTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                if(hourOfDay == 0)
                {
                    am_pm = "AM";
                    hourOfDay = 12;
                }
                else if(hourOfDay >=12) {
                    am_pm = "PM";
                    if(hourOfDay!=12)
                        hourOfDay -= 12;
                }
                else
                    am_pm = "AM";
                if(minute<10)
                    time = hourOfDay+":0"+minute+" "+am_pm+" (IST)";
                else
                    time = hourOfDay+":"+minute+" "+am_pm+" (IST)";
                webinarTime.setText(time);
            }
        };
        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month + 1;
                switch(month)
                {
                    case 1:
                        date = "January "+dayOfMonth+", "+year;
                        webinarDate.setText(date);
                        break;
                    case 2:
                        date = "February "+dayOfMonth+", "+year;
                        webinarDate.setText(date);
                        break;
                    case 3:
                        date = "March "+dayOfMonth+", "+year;
                        webinarDate.setText(date);
                        break;
                    case 4:
                        date = "April "+dayOfMonth+", "+year;
                        webinarDate.setText(date);
                        break;
                    case 5:
                        date = "May "+dayOfMonth+", "+year;
                        webinarDate.setText(date);
                        break;
                    case 6:
                        date = "June "+dayOfMonth+", "+year;
                        webinarDate.setText(date);
                        break;
                    case 7:
                        date = "July "+dayOfMonth+", "+year;
                        webinarDate.setText(date);
                        break;
                    case 8:
                        date = "August "+dayOfMonth+", "+year;
                        webinarDate.setText(date);
                        break;
                    case 9:
                        date = "September "+dayOfMonth+", "+year;
                        webinarDate.setText(date);
                        break;
                    case 10:
                        date = "October "+dayOfMonth+", "+year;
                        webinarDate.setText(date);
                        break;
                    case 11:
                        date = "November "+dayOfMonth+", "+year;
                        webinarDate.setText(date);
                        break;
                    case 12:
                        date = "December "+dayOfMonth+", "+year;
                        webinarDate.setText(date);
                        break;
                }
            }
        };

        webinarDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog dialog = new DatePickerDialog(AddWebinar.this,android.R.style.Theme_Holo_Light_Dialog_MinWidth,mDateSetListener,year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        webinarTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                int hour = cal.get(Calendar.HOUR);
                int min = cal.get(Calendar.MINUTE);
                TimePickerDialog dialog = new TimePickerDialog(AddWebinar.this,mTimeSetListener,hour,min,false);
                dialog.show();
            }
        });
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addWebinar();
            }
        });
    }
    public void addWebinar()
    {
        String name = webinarName.getText().toString();
        String host = webinarHost.getText().toString();
        String topic = webinarTopic.getText().toString();
        String date = webinarDate.getText().toString();
        String time = webinarTime.getText().toString();
        String info = webinarInfo.getText().toString();
        String addedBy = webinarAddedBy.getText().toString();
        String regURL = webinarRegistrationURL.getText().toString();
        String streamURL = webinarStreamURL.getText().toString();
        if(TextUtils.isEmpty(name) || TextUtils.isEmpty(host) || TextUtils.isEmpty(topic) || TextUtils.isEmpty(date)
                || TextUtils.isEmpty(time) || TextUtils.isEmpty(info) || TextUtils.isEmpty(regURL) || TextUtils.isEmpty(streamURL)
                || TextUtils.isEmpty(addedBy))
        {
            Toast.makeText(this,"Enter all the values",Toast.LENGTH_SHORT).show();
        }
        else
        {
            String id = webinarDatabase.push().getKey();
            Webinar webinar = new Webinar(name,host,topic,date,time,id,info,addedBy,"Pending for Review",false);
            webinarDatabase.child(id).setValue(webinar);
            Toast.makeText(this,"Webinar added to database",Toast.LENGTH_SHORT).show();
        }
    }
}
