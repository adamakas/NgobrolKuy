package com.responsi.ngobrolkuy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class HomeChatActivity extends AppCompatActivity {
    private ImageView setting;
    private FloatingActionButton keluar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_chat);

        setting = findViewById(R.id.btnSetting);
        keluar = findViewById(R.id.fabKeluar);

        String usname = getIntent().getExtras().getString("username");
        String pass = getIntent().getExtras().getString("password");
        String fp = getIntent().getExtras().getString("foto_profil");

        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeChatActivity.this, SettingActivity.class);
                intent.putExtra("username", usname);
                intent.putExtra("foto_profil", fp);
                intent.putExtra("password", pass);
                startActivity(intent);
            }
        });
        for (int i = 1; i <= 7; i++) {
            int id = getResources().getIdentifier("chat" + Integer.toString(i), "id", "com.responsi.ngobrolkuy");
            View view = findViewById(id);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(HomeChatActivity.this, ChatPersonalActivity.class);
                    startActivity(intent);
                }
            });
        }
        keluar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeChatActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}