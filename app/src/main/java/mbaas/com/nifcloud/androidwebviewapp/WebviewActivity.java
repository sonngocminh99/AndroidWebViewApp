package mbaas.com.nifcloud.androidwebviewapp;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class WebviewActivity extends AppCompatActivity {

    private static final String TAG = "ShopActivity";
    private static final int REQUEST_RESULT = 0;
    Button _btn_back;
    WebView _webview;

    //index.htmlの公開URL
    String url = "YOUR_HTML_PUBLIC_URL";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);

        //WebviewのURLを設定
        _webview = (WebView) findViewById(R.id.webviewInfo);
        _webview.setWebViewClient(new WebViewClient());
        _webview.loadUrl(url);

        //ボタンの処理を登録する
        _btn_back = (Button) findViewById(R.id.btnBack);

        //Btn Back 画面遷移の処理を実装
        _btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // MainActivityに戻る処理
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivityForResult(intent, REQUEST_RESULT);
            }
        });
    }
}
