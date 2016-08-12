package com.oo.zhihu.ui;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.oo.zhihu.R;
import com.oo.zhihu.adapter.WXHotAdapter;
import com.oo.zhihu.entity.News;
import com.oo.zhihu.response.WXHotResponse;
import com.oo.zhihu.service.WXHotService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WXHotActivity extends Activity {

    private RecyclerView mRecyclerView;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private LinearLayoutManager mManager;
    private List<News> mNewsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wxhot);

        initViews();
        initDatas();
    }

    private void initViews() {
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView_wxhot);
        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipeRefresh_wxhot);
    }

    private void initDatas() {

        mManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mManager);

        Gson gson = new GsonBuilder().create();

        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(WXHotService.HOST)
                .build();

        WXHotService service = retrofit.create(WXHotService.class);

        Call<WXHotResponse> call = service.getWXHot("10", "1", "诛仙青云志", "1", "广州日报");

        call.enqueue(new Callback<WXHotResponse>() {
            @Override
            public void onResponse(Call<WXHotResponse> call, Response<WXHotResponse> response) {
                Log.e("info", response.body().toString());
                mNewsList = response.body().newslist;
                WXHotAdapter adapter = new WXHotAdapter(WXHotActivity.this, mNewsList);
                adapter.setOnItemClickListener(new WXHotAdapter.OnRecyclerViewItemClickListener() {
                    @Override
                    public void onItemClick(View view, News data) {
                        Intent intent = new Intent(WXHotActivity.this,WebViewActivity.class);
                        intent.putExtra("url",data.url);
                        startActivity(intent);
                    }
                });
                mRecyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<WXHotResponse> call, Throwable t) {
                Log.e("info", t.toString());
            }
        });


    }
}
