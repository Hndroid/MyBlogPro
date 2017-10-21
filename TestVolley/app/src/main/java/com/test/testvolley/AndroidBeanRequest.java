package com.test.testvolley;

import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.io.UnsupportedEncodingException;

/**
 * Created by null on 17-10-20.
 */

public class AndroidBeanRequest extends Request<AndroidBean> {

    private  Response.Listener<AndroidBean> mListener;
    private Gson mGson = new Gson();
    private Class<AndroidBean> clazz;


    public AndroidBeanRequest(int method, String url, Class<AndroidBean> clazz, Response.Listener<AndroidBean> listener,
                         Response.ErrorListener errorListener) {
        super(method, url, errorListener);
        mListener = listener;
        this.clazz = clazz;
    }

    @Override
    protected Response<AndroidBean> parseNetworkResponse(NetworkResponse response) {
        try {
            String json = new String(
                    response.data,
                    HttpHeaderParser.parseCharset(response.headers));
            return Response.success(
                    mGson.fromJson(json, clazz),
                    HttpHeaderParser.parseCacheHeaders(response));
        } catch (UnsupportedEncodingException e) {
            return Response.error(new ParseError(e));
        } catch (JsonSyntaxException e) {
            return Response.error(new ParseError(e));
        }
    }

    @Override
    protected void deliverResponse(AndroidBean response) {
        mListener.onResponse(response);
    }
}
