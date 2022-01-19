# 【Android】 mBaaSをWebサーバーとして使ってみよう！
![画像1](/readme-img/001.png)

## 概要
* [ ニフクラ mobile backend ](https://mbaas.nifcloud.com/)の『ファイルストア機能』をWebサーバーとして利用し、保存したWebページを、アプリ内WebViewで表示するサンプルプロジェクトです
* 簡単な操作ですぐに [ ニフクラ mobile backend ](https://mbaas.nifcloud.com/)の機能を体験いただけます

##  ニフクラ mobile backend って何？？
スマートフォンアプリのバックエンド機能（プッシュ通知・データストア・会員管理・ファイルストア・SNS連携・位置情報検索・スクリプト）が**開発不要**、しかも基本**無料**(注1)で使えるクラウドサービスです。

注1：詳しくは[こちら](https://mbaas.nifcloud.com/price.htm)をご覧ください

![画像2](/readme-img/002.png)

## 動作環境

* MacOS Big Sur 11.6 
* Android Studio Arctic Fox 2020.3.1
* Pixle 3 - Android 12 (Simulator)
* SDK v2系だと動作しないので注意

※上記内容で動作確認をしています。

## 手順
### 1. ニフクラ mobile backend の会員登録・ログインとアプリの新規作成
* 下記リンクから会員登録（無料）をします
  * https://console.mbaas.nifcloud.com/signup
* 登録ができたら下記リンクからログインします
  * https://console.mbaas.nifcloud.com/
* 下図のように「アプリの新規作成」画面が出るのでアプリを作成します
  * 既に mobile backend を利用したことがある方は左上の「＋新しいアプリ」をクリックすると同じ画面が表示されます
* アプリ作成されるとAPIキー（アプリケーションキーとクライアントキー）が発行されます
* 「OK」をクリックすると管理画面が開かれます
 * **参考** ：APIキーは Android Studio で作成するアプリに[ ニフクラ mobile backend ](https://mbaas.nifcloud.com/)を紐付けるために使用します。アプリ内でmBaaSを使用する場合には必ず必要になるものですが、 __今回のサンプルアプリでは使用しません__ 。

### 2. GitHubからサンプルプロジェクトのダウンロード
* 下記リンクをクリックしてプロジェクトをMacにダウンロードします
 * https://github.com/NIFCLOUD-mbaas/AndroidWebViewApp/archive/master.zip

* ダウンロードしたプロジェクトを解凍します

### 3. Webページの公開ファイルURLを作成する
* 2.でダウンロードしたプロジェクト内にある「setting」フォルダを開きます
* 次のファイル３点を確認します
  * `index.html`
  * `mb.png`
  * `mb_function.png`

* この３点のファイルを[ ニフクラ mobile backend ](https://mbaas.nifcloud.com/)の「ファイルストア」にアップロードします
* 管理画面を開き、「ファイルストア」＞「↑アップロード」をクリックします

![画像4](/readme-img/004.png)

* ３点のファイルをドラッグ＆ドロップします
* ファイルが表示されたことを確認して「アップロードする」をクリックします

![画像5](/readme-img/005.png)

* アップロードされたことを確認します
 * 順番は違っていてもOKです！
* アップロードした「`index.html`」ファイルをクリックします
* 初期状態では「公開ファイルURL」が「無効」に設定されていますので、有効に設定する必要があります
* 「アプリ設定」をクリックします

![画像6](/readme-img/006.png)

* アプリ設定が開かれますので「公開ファイル設定」の「HTTPSでの取得」を「有効」に設定し、「保存する」をクリックしてください

![画像7](/readme-img/007.png)

* 再び「ファイルストア」に戻り、「`index.html`」をクリックします
* 「公開ファイルURL」が作成されていることが確認できます

![画像8](/readme-img/008.png)

* この時点でWebページが完成しています！ぜひクリックをして、webブラウザで表示してみてください
* 次はこのURLをアプリ内WebViewとして表示してみましょう！
 * 「公開ファイルURL」は後ほど使用します

### 4. Android Studioでアプリを起動

* AndroidStudioを開いて、「Open an existing Android Studio project」から、ダウンロードして解凍したプロジェクトを選択します

![画像8-1](/readme-img/android_project_open.png)

* 選択したプロジェクトが開かれます

![画像9](/readme-img/009.png)

### 5. 公開ファイルURLの設定

* AndroidStudio で WebviewActivity.kt を開きます
  * ディレクトリはデフォルトで「Android」が選択されていますので、「Project」に切り替えてから探してください
![画像11](/readme-img/011.png)

* `YOUR_HTML_PUBLIC_URL`の部分を書き換えます
* 先程[ ニフクラ mobile backend ](https://mbaas.nifcloud.com/)の管理画面上で確認した `index.html` ファイルの「公開ファイルURL」を貼り付けます
  - このとき、ダブルクォーテーション（`"`）を消さないように注意してください

![画像10](/readme-img/010.png)

* 書き換え終わったら保存してください
 * Windowsの場合、`Ctrl + S`で保存できます。
 * Macの場合、`command + S`で保存できます。

### 6. 動作確認
* AndroidStudio でビルドを行います
* アプリを起動したら、真ん中の「INFORMATION」ボタンをクリックします
* 画面が遷移し、「公開ファイルURL」で作成したWebページが表示されます

![画像1](/readme-img/001.png)

## 解説
### 公開ファイルURLについて
公開ファイルURLは次のような構造になっています

```
https://mbaas.api.nifcloud.com/2013-09-01/applications/**APPLICATION_ID**/publicFiles/**fileName**
```

### サンプルWebページについて
今回は `index.html` に２つの画像（`mb.png`, `mb_information.png`）を表示する形式で簡易的に作成していますが、JavaScript（`js`ファイル）を作成しファイルストアに保存んすることで、`index.html` にスクリプトを埋め込むことも可能です。

### サンプルアプリについて
WebViewの表示は、`WebviewActivity.java`に記述しています

```java
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
```
