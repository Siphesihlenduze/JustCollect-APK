package com.example.jstcollectv1;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;

public class AddNewItemToCat extends AppCompatActivity {

    private static final int SELECT_IMAGE_REQUEST=1;
    private Button mButtonChooseImage;
    private Button mUploadImageBtn;
    private EditText mImageNameText;
    private ImageView mNewFilePreview;
    private ProgressBar mNewImageProgress;
    ActivityResultLauncher<String> mRetrieveContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_item_to_cat);

        mButtonChooseImage = findViewById(R.id.ChooseNewImageBtn);
        mUploadImageBtn = findViewById(R.id.NewItemUploadBtn);
        mImageNameText = findViewById(R.id.EditTextNewFileName);
        mNewFilePreview = findViewById(R.id.NewImagePreview);
        mNewImageProgress = findViewById(R.id.NewFileProgressBar);

        mRetrieveContent = registerForActivityResult(new ActivityResultContracts.GetContent(), new ActivityResultCallback<Uri>() {
            @Override
            public void onActivityResult(Uri result) { mNewFilePreview.setImageURI(result);

            }
        });

        mButtonChooseImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { mRetrieveContent.launch("image/*");

            }
        });




    }
}