package com.test.testvolley;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {
    private RequestQueue requestQueue;
    private StringRequest request;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView textView = (TextView) MainActivity.this.findViewById(R.id.tv);
        final Button button = (Button) MainActivity.this.findViewById(R.id.search_go_btn);

        //[1.0]创建 RequestQueue 的实例
        requestQueue = Volley.newRequestQueue(MainActivity.this);

        String url = "http://gank.io/api/data/Android/10/1";

        //[2.0]构造一个 request（请求）
        request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                textView.setText("Response is: " + response.toString());
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                textView.setText("Error is happenning");
            }
        });

        //[3.0]把 request 添加进请求队列 RequestQueue 里面
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requestQueue.add(request);
            }
        });

        /*AndroidBeanRequest request = new AndroidBeanRequest(Request.Method.GET, url, AndroidBean.class, new Response.Listener<AndroidBean>() {

            @Override
            public void onResponse(AndroidBean response) {
                textView.setText("Response is: " + response.getResults().get(1).getCreatedAt());
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                textView.setText("Error is heppening");
            }
        });

        requestQueue.add(request);*/
    }


}
