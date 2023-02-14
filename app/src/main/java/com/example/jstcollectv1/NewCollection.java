package com.example.jstcollectv1;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class NewCollection extends AppCompatActivity {

    private static final int SELECT_IMAGE_REQUEST=1;
    private Button mButtonSelectImage;
    private Button mButtonUpload;
    private EditText mFileNameText;
    private ImageView mImagePreView;
    private ProgressBar mProgressBar;
    private Uri mImageUri;
    ActivityResultLauncher<String> mGetContent;



    ArrayList barArraylist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_collection);

        //Code for barchart starts here
        BarChart barChart = findViewById(R.id.barchart);
        getdata();
        BarDataSet barDataSet = new BarDataSet(barArraylist,"Cambo Tutorial");
        BarData barData = new BarData(barDataSet);
        barChart.setData(barData);
        barDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        barDataSet.setValueTextColor(Color.BLACK);
        barDataSet.setValueTextSize(16f);
        barChart.getDescription().setEnabled(true);
        //Code for barchart Ends here

        mButtonSelectImage = findViewById(R.id.ChooseFileBtn);
        mButtonUpload = findViewById(R.id.UploadBtn);
        mFileNameText = findViewById(R.id.EditTextFileName);
        mImagePreView = findViewById(R.id.ImagePreview);
        mProgressBar = findViewById(R.id.ProgressBar);
        final EditText mCollectionName = findViewById(R.id.CollectionNameField);
        final EditText mCollectionCat = findViewById(R.id.CollectionCatField);
        final EditText mCollDes = findViewById(R.id.CollectionDescrField);
        final EditText mCollGoal = findViewById(R.id.CollectionGoal);
        final EditText mDateOfac = findViewById(R.id.DateOfAcq);

        DaoUser dao = new DaoUser();

        mButtonUpload.setOnClickListener(v->
        {

            User user = new User(mCollectionName.getText().toString(), mCollectionCat.getText().toString(), mCollDes.getText().toString(),
                    mCollGoal.getText().toString(), mDateOfac.getText().toString());
            dao.add(user).addOnSuccessListener(suc->{

                Toast.makeText(this,"Successfully captured", Toast.LENGTH_SHORT).show();
            }).addOnFailureListener (err->{

                Toast.makeText(this,""+err.getMessage(), Toast.LENGTH_SHORT).show();
            });
        });




        mGetContent=registerForActivityResult(new ActivityResultContracts.GetContent(), new ActivityResultCallback<Uri>() {
            @Override
            public void onActivityResult(Uri result) {
                mImagePreView.setImageURI(result);
            }
        });

        mButtonSelectImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             mGetContent.launch("image/*");
            }

         /*   private void getData()
            {
                barArraylist = new ArrayList();
                barArraylist.add( new BarEntry(2f,10));
                barArraylist.add( new BarEntry(3f,20));
                barArraylist.add( new BarEntry(4f,30));
                barArraylist.add( new BarEntry(5f,40));
                barArraylist.add( new BarEntry(6f,50));

            };*/


        });






    }

    private void getdata() {
        barArraylist = new ArrayList();
        barArraylist.add( new BarEntry(2f,10));
        barArraylist.add( new BarEntry(3f,20));
        barArraylist.add( new BarEntry(4f,30));
        barArraylist.add( new BarEntry(5f,40));
        barArraylist.add( new BarEntry(6f,50));
    }


}