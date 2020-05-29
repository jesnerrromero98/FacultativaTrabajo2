package com.example.actividadrecycle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;

import android.widget.ImageView;
import android.widget.TextView;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.content.Intent;
import android.os.Bundle;

public class Activity2 extends AppCompatActivity {
    TextView mTitleView, mDescriptionView,mProfesorview,mDiaview,mHoraview,mFechaentregaview;
    ImageView mImageView;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
            //
        ActionBar actionBar=getSupportActionBar();
        // se hace refencia alos datos de la actividad_2.xml,
        // se muestran los datos selccionados de la actividad principal
        mTitleView=findViewById(R.id.titleview);
        mDescriptionView=findViewById(R.id.descripcionview);
        mImageView=findViewById(R.id.imageview);
        mProfesorview=findViewById(R.id.profesorview);
        mDiaview=findViewById(R.id.diaview);
        mHoraview=findViewById(R.id.horaview);
        mFechaentregaview=findViewById(R.id.fechaentregaview);

            // se obtienen los datos con Intent
        Intent intent=getIntent();
        String mTitle=intent.getStringExtra("iTitle");
        String mDes=intent.getStringExtra("iDesc");
        String mPro=intent.getStringExtra("iProfesor");
        String mDi=intent.getStringExtra("iDia");
        String mHor=intent.getStringExtra("iHora");
        String mFechen=intent.getStringExtra("iFechentrega");

        byte[] mBytes=getIntent().getByteArrayExtra("iImage");
        Bitmap bitmap=BitmapFactory.decodeByteArray(mBytes,0,mBytes.length);

        // se asignan los datos que obtuvimos  alos elementos de la actividad_2.xml
        actionBar.setTitle(mTitle);
        mTitleView.setText(mTitle);
        mDescriptionView.setText(mDes);
        mImageView.setImageBitmap(bitmap);
        mProfesorview.setText(mPro);
        mDiaview.setText(mDi);
        mHoraview.setText(mHor);
        mFechaentregaview.setText(mFechen);


    }

}
