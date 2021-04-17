package com.example.a84.stockapp.ui.notifications;

import android.webkit.WebView;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebViewClient;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.a84.stockapp.R;

public class NotificationsViewModel extends ViewModel {

    private MutableLiveData<String> mText;
    private WebView webView;


    public NotificationsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("");

    


    }

    public LiveData<String> getText() {
        return mText;
    }
}