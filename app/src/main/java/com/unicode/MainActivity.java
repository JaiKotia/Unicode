package com.unicode;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Post> postList = new ArrayList<>();
    private PostAdapter postAdapter;
    private RequestQueue requestQueue;
    private RecyclerView recyclerView;
    private static final String URL = "https://api.myjson.com/bins/i3loz";
    private final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        postAdapter = new PostAdapter(postList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(postAdapter);


        requestQueue = Volley.newRequestQueue(this);
        requestQueue = Volley.newRequestQueue(getApplicationContext());

        fetchPosts();
    }

    private void fetchPosts() {
        StringRequest request = new StringRequest(Request.Method.GET, URL, onPostsLoaded, onPostsError);
        requestQueue.add(request);
    }

    private final com.android.volley.Response.Listener<String> onPostsLoaded = new com.android.volley.Response.Listener<String>() {
        @Override
        public void onResponse(String response) {
            Log.d(TAG, "Response " + response);
            GsonBuilder builder = new GsonBuilder();
            Gson mGson = builder.create();
            postList = Arrays.asList(mGson.fromJson(response, Post[].class));
            postAdapter = new PostAdapter(postList);
            recyclerView.setAdapter(postAdapter);
        }

    };

    private final com.android.volley.Response.ErrorListener onPostsError = new com.android.volley.Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            Log.e("MainActivity", error.toString());
        }
    };

}