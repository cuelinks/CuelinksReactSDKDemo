package com.reactsdkintegration;


import android.content.Context;
import android.text.util.Linkify;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.cuelinks.Cuelinks;
import com.cuelinks.CuelinksListener;
import com.cuelinks.CuelinksMovementMethod;
import com.cuelinks.CuelinksSpan;
import com.cuelinks.CuelinksUtil;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

import org.w3c.dom.Text;

public class CueLinkModule extends ReactContextBaseJavaModule implements CuelinksListener {
    private final ReactApplicationContext reactContext;

    public CueLinkModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.reactContext = reactContext;
    }

    @Override
    public String getName() {
        return "CueLinkModule";
    }


    @ReactMethod
    public void getAffiliateLink(String url, Promise promise) {
        Toast.makeText(reactContext, url, Toast.LENGTH_SHORT).show();
        Cuelinks.initialize(reactContext);
        String modifiedUrl = CuelinksUtil.getAffiliatedUrl(url,"Sub1","Sub2");
        Toast.makeText(reactContext,"Modified : "+modifiedUrl, Toast.LENGTH_SHORT).show();
        promise.resolve(modifiedUrl);
    }

    @Override
    public void openUrl(String url, Context context) {
        Log.e("CuelinkModule","URL :: "+url);
        Toast.makeText(reactContext, "Open URLS", Toast.LENGTH_SHORT).show();
    }
}
