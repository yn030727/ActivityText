package com.example.activitytext;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = findViewById(R.id.textView);
        textView.setText("这是一个测试案例");

        //通过在Intent中设置标志位来为Activity指定启动模式
        Intent intent = new Intent();
        intent.setClass(MainActivity.this,SecondActivity.class);
        intent.setDataAndType(Uri.parse("file://abc"),"image/jpeg");
        PackageManager packageManager = getPackageManager();
        if(packageManager.resolveActivity(intent,PackageManager.MATCH_DEFAULT_ONLY)!=null){
            startActivity(intent);
        }else{
            Toast.makeText(this,"没有找到你想要的Activity",Toast.LENGTH_SHORT).show();
        }
    }

    //在TextView的源码当中，这两个方法会保存文本选中状态和文本内容
    //所以说即使翻转屏幕也不会发生影响
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d("Ning","onSaveInstanceState");
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d("Ning","onRestoreInstanceState");
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}