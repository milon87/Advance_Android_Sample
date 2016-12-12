package com.android.advance.model;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import com.android.advance.util.ConstantValues;
import com.android.advance.interfaces.OnRequestComplete;
import com.google.gson.Gson;

public class InvokeApi {
    OnRequestComplete requestComplete;

    public InvokeApi(final Context context, final OnRequestComplete onRequestComplete) {
        this.requestComplete = onRequestComplete;

        RequestQueue queue = Volley.newRequestQueue(context);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, ConstantValues.URL,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        //Todo
                        //here typeList is custom object change as your required
                        Gson gson= new Gson();
                        TypeList typeList= gson.fromJson(response.toString(),TypeList.class);
                        Log.d("Response", typeList.getStatus()+"");
                        requestComplete.onRequestComplete(typeList);

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        // Add the request to the RequestQueue.
        queue.add(jsonObjectRequest);
    }
}
