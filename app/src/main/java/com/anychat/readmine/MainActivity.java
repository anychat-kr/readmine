package com.anychat.readmine;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private WebView web;
    private WebSettings mWebSettings;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //스플래시 숨김
        final View content = findViewById(android.R.id.content);
        content.getViewTreeObserver().addOnPreDrawListener(
                new ViewTreeObserver.OnPreDrawListener() {
                    @Override
                    public boolean onPreDraw() {
                        // Check if the initial data is ready.
                        if (false) {
                            // The content is ready; start drawing.
                            content.getViewTreeObserver().removeOnPreDrawListener(this);
                            return true;
                        } else {
                            // The content is not ready; suspend.
                            return false;
                        }
                    }
                });

        //스플래시 없어질때 애니메이션


        // 웹뷰
        web = findViewById(R.id.webview);

        Log.d("Finished ::::", "Hey :::::;");
        try{
            String url = "https://demoqa.anychat.com:3000/projects/test-project/issues/gantt?utf8=%E2%9C%93&set_filter=1&gantt=1&f%5B%5D=status_id&op%5Bstatus_id%5D=%3D&v%5Bstatus_id%5D%5B%5D=5&f%5B%5D=&query%5Bdraw_selected_columns%5D=0&query%5Bdraw_relations%5D=0&query%5Bdraw_relations%5D=1&query%5Bdraw_progress_line%5D=0&months=2&month=12&year=2022&zoom=2";
            web.loadUrl(url);
            web.setWebViewClient(new WebViewClient()); // 현재 앱을 나가서 새로운 브라우저를 열지 않도록 함.
            mWebSettings = web.getSettings(); // 웹뷰에서 webSettings를 사용할 수 있도록 함.
            mWebSettings.setJavaScriptEnabled(true); //웹뷰에서 javascript를 사용하도록 설정
            mWebSettings.setTextZoom(80);

        /*
        mWebSettings.setJavaScriptCanOpenWindowsAutomatically(false); //멀티윈도우 띄우는 것
        mWebSettings.setAllowFileAccess(true); //파일 엑세스
        mWebSettings.setLoadWithOverviewMode(true); // 메타태그
        mWebSettings.setUseWideViewPort(true); //화면 사이즈 맞추기
        mWebSettings.setSupportZoom(true); // 화면 줌 사용 여부
        mWebSettings.setBuiltInZoomControls(true); //화면 확대 축소 사용 여부
        mWebSettings.setDisplayZoomControls(true); //화면 확대 축소시, webview에서 확대/축소 컨트롤 표시 여부
        mWebSettings.setCacheMode(WebSettings.LOAD_NO_CACHE); // 브라우저 캐시 사용 재정의 value : LOAD_DEFAULT, LOAD_NORMAL, LOAD_CACHE_ELSE_NETWORK, LOAD_NO_CACHE, or LOAD_CACHE_ONLY
        mWebSettings.setDefaultFixedFontSize(14); //기본 고정 글꼴 크기, value : 1~72 사이의 숫자

        */
        }catch (Exception e){
            Log.e("essue","Exception    "   +e);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (web != null) {
            web.destroy();
            web=null; // remove webView, prevent chromium to crash
        }
    }

}