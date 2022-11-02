package com.responsi.ngobrolkuy;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class ChangePasswordActivity extends AppCompatActivity {
    private ImageView mundur;
    private Button terapkan;
    private EditText password_baru;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        mundur = findViewById(R.id.btnMundur);
        terapkan = findViewById(R.id.btnTerapkan);
        password_baru = findViewById(R.id.etPasswordBaru);

        mundur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChangePasswordActivity.this, HomeChatActivity.class);
                startActivity(intent);
            }
        });

        terapkan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChangePasswordActivity.this, ConfirmChangePasswordActivity.class);
                if (password_baru.getText().toString().isEmpty()) {
                    password_baru.setError("Password baru harus diisi");
                } else {
                    intent.putExtra("password_baru", password_baru.getText().toString());
                    startActivity(intent);
                }
            }
        });
    }
}