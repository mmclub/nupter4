package com.mmclub.nupternew.OtherClass.QiNiu;


import android.util.Log;

import com.qiniu.android.http.ResponseInfo;
import com.qiniu.android.storage.Configuration;
import com.qiniu.android.storage.UpCancellationSignal;
import com.qiniu.android.storage.UpCompletionHandler;
import com.qiniu.android.storage.UpProgressHandler;
import com.qiniu.android.storage.UploadManager;
import com.qiniu.android.storage.UploadOptions;

import org.json.JSONObject;

import java.io.File;

/**
 * Created by J on 15/11/2.
 */
public class UploadQiNiu {
    File file;
    String key;
    String token;
    UpCompletionHandler completionHandler;
    UploadOptions options;
    Configuration config;
    boolean isCancelled=false;

    public void UploadQiNiu(File file,String key,String token){
        this.file=file;
        this.key=key;
        this.token=token;
        this.completionHandler=new UpCompletionHandler() {
            @Override
            public void complete(String key, ResponseInfo info, JSONObject res) {
                //  res 包含hash、key等信息，具体字段取决于上传策略的设置。
                Log.i("qiniu",key + ",\r\n " + info + ",\r\n " + res);

            }
        };
        options=new UploadOptions(null,null,false,new UpProgressHandler(){
            public void progress(String key, double percent){
                Log.i("qiniu", key + ": " + percent);
            }
        }, new UpCancellationSignal(){
            public boolean isCancelled(){
                return isCancelled;
            }
        });
        config=new Configuration.Builder().build();

    }

    public void UploadManager(){
        UploadManager uploadManager=new UploadManager(config);
        uploadManager.put(file,key,token,completionHandler,options);

    }

    //取消上传
    private void cancell() {
        isCancelled = true;
    }



}
