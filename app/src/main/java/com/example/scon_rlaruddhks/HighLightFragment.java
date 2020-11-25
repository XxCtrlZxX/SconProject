package com.example.scon_rlaruddhks;

import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.fragment.app.Fragment;

public class HighLightFragment extends Fragment {
    public static HighLightFragment newInstance() {
        return new HighLightFragment();
    }
    WebView mWebView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_highlight, container, false);
        mWebView = (WebView) view.findViewById(R.id.webview);
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.loadUrl("https://www.youtube.com/playlist?list=PL7MQjbfOyOE1FHV5fvnNQabZZW7m12aEq");
        mWebView.setWebChromeClient(new WebChromeClient());
        //mWebView.getSettings().setPluginsEnabled(true);
        mWebView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return false;
            }
        });
        return view;
    }

//    @Override
//    public boolean onKeyDown(int keyCode, KeyEvent event) {//뒤로가기 버튼 이벤트
//        if ((keyCode == KeyEvent.KEYCODE_BACK) && mWebView.canGoBack()) {//웹뷰에서 뒤로가기 버튼을 누르면 뒤로가짐
//            mWebView.goBack();
//            return true;
//        }
//        return super.onKeyDown(keyCode, event);
//    }
//
//    private class WebViewClientClass extends WebViewClient {//페이지 이동
//        @Override
//        public boolean shouldOverrideUrlLoading(WebView view, String url) {
//            Log.d("check URL",url);
//            view.loadUrl(url);
//            return true;
//        }
//    }
}
