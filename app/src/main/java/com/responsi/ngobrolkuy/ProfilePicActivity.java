package com.responsi.ngobrolkuy;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class ProfilePicActivity extends AppCompatActivity {
    private ImageView btnEdit, imgProfile;
    private int GALLERY_REQUEST_CODE = 1;
    private Uri imageUri;
    private Button btnLanjut, btnLewati;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_pic);

        btnEdit = findViewById(R.id.pinkCircle);
        imgProfile = findViewById(R.id.profilePic);
        btnLanjut = findViewById(R.id.profil_btnLanjut);
        btnLewati = findViewById(R.id.profil_btnLewati);

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI), GALLERY_REQUEST_CODE);
            }
        });

        btnLewati.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ProfilePicActivity.this, HomeChatActivity.class));
            }
        });
        btnLanjut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ProfilePicActivity.this, HomeChatActivity.class));
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_CANCELED) {
            Toast.makeText(this, "Load image cancelled", Toast.LENGTH_SHORT).show();
            return;
        }
        if (requestCode == GALLERY_REQUEST_CODE) {
            if (data != null) {
                try {
                    imageUri = data.getData();
                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), imageUri);
                    imgProfile.setImageBitmap(bitmap);
                    btnLewati.setVisibility(View.INVISIBLE);
                    btnLanjut.setVisibility(View.VISIBLE);
                } catch (Exception e) {
                    Toast.makeText(this, "Can't load image", Toast.LENGTH_SHORT).show();
                }
            }
            else Toast.makeText(this, "Condition not met", Toast.LENGTH_SHORT).show();
        }
    }
}