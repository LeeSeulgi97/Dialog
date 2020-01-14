package com.example.lsk49.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView test1,test2,test3;
    int setitem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        test1 = (TextView)findViewById(R.id.test1);
        test1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder testDialog = new AlertDialog.Builder(MainActivity.this,android.R.style.Theme_DeviceDefault_Dialog);
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
        test2 =(TextView)findViewById(R.id.test2);
        test2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final CharSequence[] listitem = {"흰색","검은색","빨간색","파란색","초록색"};
                AlertDialog.Builder ListDialog = new AlertDialog.Builder(MainActivity.this);
                ListDialog.setTitle("리스트 다이얼로그 - 색상선택")
                        .setItems(listitem, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(MainActivity.this,listitem[which]+"을 선택하셨습니다.",Toast.LENGTH_SHORT).show();
                            }
                        })
                        .show();
            }
        });
        test3=(TextView)findViewById(R.id.test3);
        test3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final CharSequence[] listitem2 = {"흰색", "검은색", "빨간색", "파란색", "초록색"};
                AlertDialog.Builder ListDialog = new AlertDialog.Builder(MainActivity.this);
                ListDialog.setTitle("라디오 버튼 다이얼로그 - 색상선택(싱글)")
                        .setSingleChoiceItems(listitem2, -1, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                setitem = which;
                            }
                    })
                        .setNeutralButton("선택", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
//                                Log.e("tmfrl","which"+which);
//                                Log.e("tmfrl","setitem"+setitem);
//                                if (which >= 0) {              //여기서 which가 -3이 나온다. 위에 checkeditem의 역할이 뭔지 찾아봐야할듯.
                                    Toast.makeText(MainActivity.this, listitem2[setitem] + "을 선택하셨습니다.", Toast.LENGTH_SHORT).show();
//                                }
                            }
                        })
                        .show();

            }
        });
        //이후에 라디오버튼 싱글초이스말고 멀티초이스도 추가예정
    }
}
