package com.androidmodule.gutenbergapp.ui.main.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.androidmodule.gutenbergapp.R;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {


    private LinearLayout llFictionLayout,llDramaLayout,llHumorLayout,llPoliticsLayout,llPhilosophyLayout,
            llHistoryLayout, llAdventureLayout;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_layout);
        initView();
        clickListener();
    }

    private void clickListener() {
        llAdventureLayout.setOnClickListener(this);
        llHumorLayout.setOnClickListener(this);
        llPoliticsLayout.setOnClickListener(this);
        llPhilosophyLayout.setOnClickListener(this);
        llHistoryLayout.setOnClickListener(this);
        llDramaLayout.setOnClickListener(this);
        llFictionLayout.setOnClickListener(this);
    }

    private void initView() {
        llFictionLayout = (LinearLayout) findViewById(R.id.fiction);
        llDramaLayout = (LinearLayout) findViewById(R.id.drama);
        llHistoryLayout = (LinearLayout) findViewById(R.id.history);
        llPhilosophyLayout = (LinearLayout) findViewById(R.id.philosophy);
        llPoliticsLayout = (LinearLayout) findViewById(R.id.politics);
        llHumorLayout = (LinearLayout) findViewById(R.id.humor);
        llAdventureLayout = (LinearLayout) findViewById(R.id.adventure);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id){
            case R.id.fiction: {
                Intent intent = new Intent(this, MainActivity.class);
                intent.putExtra("genre","Fiction");
                startActivity(intent);
            }
            break;
            case R.id.drama:{
                Intent intent = new Intent(this, MainActivity.class);
                intent.putExtra("genre","Drama");
                startActivity(intent);
            }
            break;
            case R.id.adventure:{
                Intent intent = new Intent(this, MainActivity.class);
                intent.putExtra("genre","Adventure");
                startActivity(intent);
            }
            break;
            case R.id.humor:{
                Intent intent = new Intent(this, MainActivity.class);
                intent.putExtra("genre","Humor");
                startActivity(intent);
            }
            break;
            case R.id.history:{
                Intent intent = new Intent(this, MainActivity.class);
                intent.putExtra("genre","History");
                startActivity(intent);
            }
            break;
            case R.id.philosophy:{
                Intent intent = new Intent(this, MainActivity.class);
                intent.putExtra("genre","Philosophy");
                startActivity(intent);
            }
            break;
            case R.id.politics:{
                Intent intent = new Intent(this, MainActivity.class);
                intent.putExtra("genre","Politics");
                startActivity(intent);
            }
            break;
        }
    }
}
