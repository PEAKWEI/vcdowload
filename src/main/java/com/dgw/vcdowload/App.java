package com.dgw.vcdowload;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

/**
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
    	OkHttpClient client = new OkHttpClient();
    	
    	Request request = new Request.Builder()
    	.get()
    	.url(AllConfig.url)
    	.build();
    	
    	for (int i = 1; i <= 3000; i++) {
    		Call call = client.newCall(request);
    		final int  x=i;
    		call.enqueue(new Callback() {
    			@Override
    			public void onResponse(Response response) throws IOException {
    	        	InputStream is = response.body().byteStream();
    	        	//将响应数据转化为输入流数据
    	        	byte[] buf = new byte[2048];
    	            int len = 0;
    	            FileOutputStream fos = new FileOutputStream(new File(AllConfig.filepath+File.separator+x+".jpg"));
    	            BufferedOutputStream os = new BufferedOutputStream(fos);
    	            while((len=is.read(buf))!=-1) {
    	          	  os.write(buf,0,len);
    	            }
    	            os.flush();
    	            os.close();
    	            fos.close();
    			}
    			
    			@Override
    			public void onFailure(Request request, IOException e) {
    			}
    		});
		}
    }
}
