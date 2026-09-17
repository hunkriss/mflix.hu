package hu.mflix.hu;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends Activity {

    private WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // Teljes képernyős WebView létrehozása kódoltan
        mWebView = new WebView(this);
        setContentView(mWebView);

        // Beállítások a sima lejátszáshoz és webes működéshez
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setLoadsImagesAutomatically(true);
        webSettings.setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);

        // Hogy a linkek a WebView-n belül maradjanak, ne nyissanak külső böngészőt
        mWebView.setWebViewClient(new WebViewClient());

        // Az Mflix oldal betöltése
        mWebView.loadUrl("https://mflix.hu");
    }

    @Override
    public void onBackPressed() {
        // Ha a weboldalon belül tud még hova visszalépni, tegye azt, különben kilép
        if (mWebView.canGoBack()) {
            mWebView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}
