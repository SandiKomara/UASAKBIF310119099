package com.example.uasakbif310119099.ViewPager;
/*

NIM   : 10119099
Nama  : Sandi Komara
Kelas : IF-3

 */
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.uasakbif310119099.Login.Login;
import com.example.uasakbif310119099.MainActivity;
import com.example.uasakbif310119099.R;
import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;

public class ViewPager extends AppCompatActivity {

    private androidx.viewpager.widget.ViewPager viewPager;
    private ArrayList<Model> modelArrayList;
    private Adapter adapter;
    private MaterialButton button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
        Dialog dialog = new Dialog(ViewPager.this);
        dialog.setCanceledOnTouchOutside(true);
        viewPager = findViewById(R.id.viewPager);
        loadCards();viewPager.addOnPageChangeListener(new androidx.viewpager.widget.ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                String title = modelArrayList.get(position).getTitle();
                if(position == modelArrayList.size()-1){
                    button.setText("Mulai");
                }else {
                    button.setText("Lanjut");
                }

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(viewPager.getCurrentItem()+1<modelArrayList.size()){
                    viewPager.setCurrentItem(viewPager.getCurrentItem()+1);
                }else{
                    //kembali ke main activity
                    startActivity(new Intent(ViewPager.this, Login.class));
                    finish();
                }

            }
        });
    }

    private void loadCards() {
        modelArrayList = new ArrayList<>();

        modelArrayList.add(new Model("What's Notes! Apps?","Aplikasi catatan harian.",R.drawable.splash));
        modelArrayList.add(new Model("Write Your Daily Notes!","Anda dapat menulis catatan apapun yang ingin anda simpan!",R.drawable.write));
        modelArrayList.add(new Model("Update Your Daily Notes!!","Anda bisa mengubah bahkan menghapus catatan tertentu yang telah anda catat!",R.drawable.settings));

        adapter = new Adapter(this,modelArrayList);
        viewPager.setAdapter(adapter);
        viewPager.setPadding(100,0,100,0);
    }

}