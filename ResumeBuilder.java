package com.mgstarlites.jobkaro;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class ResumeBuilder extends AppCompatActivity {

    String websiteURL = "https://resumebuild.com/app/choose-options"; // sets web url
    private WebView webview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resume_builder);



            if( ! CheckNetwork.isInternetAvailable(ResumeBuilder.this)) //returns true if internet available
            {
                //if there is no internet do this
                setContentView(R.layout.activity_main);
                //Toast.makeText(this,"No Internet Connection, Chris",Toast.LENGTH_LONG).show();

                new AlertDialog.Builder(this) //alert the person knowing they are about to close
                        .setTitle("No internet connection available")
                        .setMessage("Please Check you're Mobile data or Wifi network.")
                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        })
                        //.setNegativeButton("No", null)
                        .show();

            }
            else
            {
                //Webview stuff
                webview = findViewById(R.id.webView);
                webview.getSettings().setJavaScriptEnabled(true);
                webview.getSettings().setDomStorageEnabled(true);
                webview.setOverScrollMode(WebView.OVER_SCROLL_NEVER);
                webview.loadUrl(websiteURL);
                webview.setWebViewClient(new WebViewClientDemo());

            }
        }


        private class WebViewClientDemo extends WebViewClient {
            @Override
            //Keep webview in app when clicking links
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        }


    }

    class CheckNetwork {

        private static final String TAG = CheckNetwork.class.getSimpleName();

        public static boolean isInternetAvailable(ResumeBuilder context)
        {
            NetworkInfo info = (NetworkInfo) ((ConnectivityManager)
                    context.getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();

            if (info == null)
            {
                Log.d(TAG,"no internet connection");
                return false;
            }
            else
            {
                if(info.isConnected())
                {
                    Log.d(TAG," internet connection available...");
                    return true;
                }
                else
                {
                    Log.d(TAG," internet connection");
                    return true;
                }

            }
        }
    }
