package mbaas.com.nifcloud.androidwebviewapp;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "ShopActivity";
    private static final int REQUEST_RESULT = 0;
    Button _btn_info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ボタンの処理を登録する
        _btn_info = (Button) findViewById(R.id.btnInfo);

        //Informationボタンの処理を実装
        _btn_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // WebviewActivityに遷移
                Intent intent = new Intent(getApplicationContext(), WebviewActivity.class);
                startActivityForResult(intent, REQUEST_RESULT);
            }
        });


    }
}
