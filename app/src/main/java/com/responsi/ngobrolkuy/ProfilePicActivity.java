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
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProfilePicActivity extends AppCompatActivity {
    private CircleImageView foto_profil;
    private Button lanjut;
    private TextView lewati;
    private ImageView pensil;
    private static final int GALLERY_REQUEST_CODE = 1;
    private static final String TAG = ProfilePicActivity.class.getCanonicalName();
    private Bitmap bitmap;
    private Uri imgUri = null;
    private boolean change_img = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_pic);

        foto_profil = findViewById(R.id.profilePic);
        lanjut = findViewById(R.id.btnLanjut);
        lewati = findViewById(R.id.btnLewati);
        pensil = findViewById(R.id.pinkCircle);
        String usname = getIntent().getExtras().getString("username");
        String pass = getIntent().getExtras().getString("password");

        foto_profil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, GALLERY_REQUEST_CODE);
            }
        });

        pensil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, GALLERY_REQUEST_CODE);
            }
        });

        lanjut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProfilePicActivity.this, HomeChatActivity.class);
                intent.putExtra("foto_profil", imgUri.toString());
                intent.putExtra("username", usname);
                intent.putExtra("password", pass);
                startActivity(intent);
            }
        });

        lewati.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProfilePicActivity.this, HomeChatActivity.class);
                intent.putExtra("username", usname);
                intent.putExtra("password", pass);
                startActivity(intent);
            }
        });

    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_CANCELED){
            Toast.makeText(this, "     Batal mengambil gambar     ", Toast.LENGTH_SHORT).show();
            return;
        } else {
            if (requestCode == GALLERY_REQUEST_CODE){
                if (data != null){
                    try {
                        change_img = true;
                        imgUri = data.getData();
                        bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(),imgUri);
                        foto_profil.setImageBitmap(bitmap);
                        lewati.setVisibility(View.INVISIBLE);
                        lanjut.setVisibility(View.VISIBLE);
                    } catch (IOException e) {
                        Toast.makeText(this, "     Gagal mengambil gambar     ", Toast.LENGTH_SHORT).show();
                        Log.e(TAG, e.getMessage());
                    }
                }
            }
        }
    }
}