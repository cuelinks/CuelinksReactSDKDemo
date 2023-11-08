package com.reactsdkintegration;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;
import com.cuelinks.Cuelinks;
import com.cuelinks.CuelinksListener;
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
        Cuelinks.initialize(reactContext);
        String modifiedUrl = CuelinksUtil.getAffiliatedUrl(url,"Sub1","Sub2");
        promise.resolve(modifiedUrl);
    }

    @Override
    public void openUrl(String url, Context context) {
        //..your code goes here
    }
}
