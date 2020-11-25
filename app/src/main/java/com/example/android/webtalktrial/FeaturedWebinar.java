package com.example.android.webtalktrial;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class FeaturedWebinar extends AppCompatActivity {

    public static ArrayList<Webinar> webinarList;
    private RecyclerView recyclerView;
    private WebinarListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_featured_webinar);
        webinarList = new ArrayList<>();
        recyclerView = findViewById(R.id.featured_webinar_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(3);
        menuItem.setChecked(true);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId())
                {
                    case R.id.add_webinar:
                    {
                        Intent intent = new Intent(FeaturedWebinar.this,AddWebinar.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                        finishAffinity();
                        overridePendingTransition(R.anim.slide_in_right,R.anim.slide_in_left);
                        finish();
                        break;
                    }
                    case R.id.search:
                    {
                        Intent intent = new Intent(FeaturedWebinar.this,SearchWebinar.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                        finishAffinity();
                        overridePendingTransition(R.anim.slide_in_right,R.anim.slide_in_left);
                        finish();
                        break;
                    }
                    case R.id.home:
                    {
                        Intent intent = new Intent(FeaturedWebinar.this,MainActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        finishAffinity();
                        startActivity(intent);
                        overridePendingTransition(R.anim.slide_in_right,R.anim.slide_in_left);
                        finish();
                        break;
                    }
                    case R.id.about:
                    {
                        Intent intent = new Intent(FeaturedWebinar.this,SettingsActivity.class);
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
        DatabaseReference firebaseReference = FirebaseDatabase.getInstance().getReference("webinar");
        firebaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                webinarList.clear();
                for (DataSnapshot webinarSnapshot : snapshot.getChildren()) {
                    Webinar webinar = webinarSnapshot.getValue(Webinar.class);
                    webinarList.add(webinar);
                }
                Log.v("Tag",""+webinarList.get(1).getWebinarName());
                adapter = new WebinarListAdapter(FeaturedWebinar.this, webinarList);
                recyclerView.setAdapter(adapter);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.v("No data change",error.toString());
            }
        });
    }
    public ArrayList<Webinar> getWebinarList()
    {
        return webinarList;
    }
}

