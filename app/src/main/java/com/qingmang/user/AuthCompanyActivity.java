package com.qingmang.user;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.qingmang.R;

public class AuthCompanyActivity extends AppCompatActivity {
    private static final int REQUEST_GALLERY = 123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth_company);
        ChooseImages();
    }

    private void ChooseImages() {
        Intent toGallery = new Intent(Intent.ACTION_GET_CONTENT);
        toGallery.setType("image/*");
        toGallery.addCategory(Intent.CATEGORY_OPENABLE);
        startActivityForResult(toGallery, REQUEST_GALLERY);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

    }
}
