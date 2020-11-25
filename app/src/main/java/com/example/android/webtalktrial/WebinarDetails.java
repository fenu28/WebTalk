package com.example.android.webtalktrial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class WebinarDetails extends AppCompatActivity {

    private TextView webinarName;
    private TextView webinarHost;
    private TextView webinarTopic;
    private TextView webinarInfo;
    private TextView webinarRegistrationURL;
    private TextView webinarStreamURL;
    private TextView webinarAddedBy;
    private TextView webinarDate;
    private TextView webinarTime;
    private Webinar webinar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webinar_details);
        Intent intent = getIntent();
        webinar = new Webinar();
        webinar = (Webinar)intent.getSerializableExtra("webinarObject");

        assert webinar != null;
        webinarName.setText(webinar.getWebinarName());
        webinarHost.setText(webinar.getWebinarHost());
        webinarTopic.setText(webinar.getWebinarTopic());
        webinarInfo.setText(webinar.getWebinarInfo());
        webinarDate.setText(webinar.getWebinarDate());
        webinarAddedBy.setText(webinar.getAddedBy());
        webinarTime.setText(webinar.getWebinarTime());

    }
}
