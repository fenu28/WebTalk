package com.example.android.webtalktrial;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class SettingsActivity extends AppCompatActivity {
    private TextView displayName;
    private TextView emailID;
    private Button logoutButton;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        displayName = findViewById(R.id.displayname);
        emailID = findViewById(R.id.emailID);
        logoutButton = findViewById(R.id.logout);

        GoogleSignInAccount signInAccount = GoogleSignIn.getLastSignedInAccount(this);
        if(signInAccount!=null)
        {
            displayName.setText(signInAccount.getDisplayName());
            emailID.setText(signInAccount.getEmail());
        }

        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                finishAffinity();
                startActivity(intent);
                finish();
            }
        });

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(4);
        menuItem.setChecked(true);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId())
                {
                    case R.id.add_webinar:
                    {
                        Intent intent = new Intent(SettingsActivity.this,AddWebinar.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        finishAffinity();
                        startActivity(intent);
                        overridePendingTransition(R.anim.slide_in_right,R.anim.slide_in_left);
                        finish();
                        break;
                    }
                    case R.id.search:
                    {
                        Intent intent = new Intent(SettingsActivity.this,SearchWebinar.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        finishAffinity();
                        startActivity(intent);
                        overridePendingTransition(R.anim.slide_in_right,R.anim.slide_in_left);
                        finish();
                        break;
                    }
                    case R.id.featured:
                    {
                        Intent intent = new Intent(SettingsActivity.this,FeaturedWebinar.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        finishAffinity();
                        startActivity(intent);
                        overridePendingTransition(R.anim.slide_in_right,R.anim.slide_in_left);
                        finish();
                        break;
                    }
                    case R.id.home:
                    {
                        Intent intent = new Intent(SettingsActivity.this,MainActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        finishAffinity();
                        startActivity(intent);
                        overridePendingTransition(R.anim.slide_in_right,R.anim.slide_in_left);
                        finish();
                        break;
                    }
                    default:
                        break;
                }
                return false;
            }
        });
    }
}
