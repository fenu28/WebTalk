package com.example.android.webtalktrial;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class SearchWebinar extends BaseClass implements WebinarListAdapter.OnWebinarClickListener {

    private ArrayList<Webinar> webinarList;
    private WebinarListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_webinar);

        this.webinarList = MainActivity.webinarList;
        EditText search = findViewById(R.id.search_bar);
        RecyclerView mRecyclerView = findViewById(R.id.SearchRecyclerView);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(1);
        menuItem.setChecked(true);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId())
                {
                    case R.id.home:
                    {
                        Intent intent = new Intent(SearchWebinar.this,MainActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        finishAffinity();
                        startActivity(intent);
                        overridePendingTransition(R.anim.slide_in_right,R.anim.slide_in_left);
                        finish();
                        break;
                    }
                    case R.id.add_webinar:
                    {   Intent intent = new Intent(SearchWebinar.this,AddWebinar.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        finishAffinity();
                        startActivity(intent);
                        overridePendingTransition(R.anim.slide_in_right,R.anim.slide_in_left);
                        finish();
                        break;
                    }
                    case R.id.about:
                    {
                        Intent intent = new Intent(SearchWebinar.this,SettingsActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        finishAffinity();
                        startActivity(intent);
                        overridePendingTransition(R.anim.slide_in_right,R.anim.slide_in_left);
                        finish();
                        break;
                    }
                    case R.id.featured:
                    {
                        Intent intent = new Intent(SearchWebinar.this,FeaturedWebinar.class);
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
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new WebinarListAdapter(SearchWebinar.this, this.webinarList);
        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                filter(s.toString());
            }
        });
        mRecyclerView.setAdapter(mAdapter);
    }
    private void filter(String text)
    {
        ArrayList<Webinar> filteredList = new ArrayList<>();
        for(Webinar item : webinarList)
            if(item.getWebinarName().toLowerCase().contains(text.toLowerCase()))
            {
                filteredList.add(item);
            }
        mAdapter.filterList(filteredList);
    }
    @Override
    public void onWebinarClick(int position) {
        Intent intent =  new Intent(SearchWebinar.this,WebinarDetails.class);
        intent.putExtra("webinarObject",webinarList.get(position));
        startActivity(intent);
    }
}
