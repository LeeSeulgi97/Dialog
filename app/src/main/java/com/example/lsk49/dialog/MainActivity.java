package com.example.lsk49.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView test1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        test1 = (TextView)findViewById(R.id.test1);
        test1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder testDialog = new AlertDialog.Builder(MainActivity.this);
                testDialog.setTitle("일반 다이얼로그")
                        .setMessage("선택사항 - 예 or 아니오 (다이얼로그종료)")
                        .setPositiveButton("예", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(MainActivity.this,"Yes버튼",Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNeutralButton("아니요", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                testDialog.setCancelable(false); //백버튼으로 팝업창 닫힘 방지
                testDialog.show();
            }
        });

    }
}
