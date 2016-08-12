package com.oo.zhihu.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.oo.zhihu.R;
import com.oo.zhihu.entity.News;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * 类名 OOZhihu
 * 作者 Keyu Chan
 * 创建日期 2016/8/12
 * 邮箱 chenky@corp.21cn.com
 * 说明
 */
public class WXHotAdapter extends RecyclerView.Adapter implements View.OnClickListener{

    private Context mContext;
    private List<News> mNewsList;
    private OnRecyclerViewItemClickListener mOnItemClickListener = null;

    public static interface OnRecyclerViewItemClickListener {
        void onItemClick(View view , News data);
    }

    public WXHotAdapter(Context context, List<News> newsList) {
        this.mContext = context;
        this.mNewsList = newsList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View resultView = LayoutInflater.from(mContext).inflate(R.layout.item_wxhot,null);
        //将创建的View注册点击事件
        resultView.setOnClickListener(this);
        return new WXHotViewHolder(resultView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        News news = mNewsList.get(position);
        Picasso.with(mContext)
                .load(news.picUrl)
                .into(((WXHotViewHolder) holder).picIv);
//        ((WXHotViewHolder) holder).picIv.setImageBitmap();
        ((WXHotViewHolder) holder).titleTv.setText(news.title);
        ((WXHotViewHolder) holder).descriptionTv.setText(news.description);
        ((WXHotViewHolder) holder).ctimeTv.setText(news.ctime);

        //将数据保存在itemView的Tag中，以便点击时进行获取
        holder.itemView.setTag(mNewsList.get(position));
    }

    @Override
    public int getItemCount() {
        return mNewsList.size();
    }

    @Override
    public void onClick(View view) {
        if (mOnItemClickListener != null) {
            //注意这里使用getTag方法获取数据
            mOnItemClickListener.onItemClick(view,(News)view.getTag());
        }
    }

    class WXHotViewHolder extends RecyclerView.ViewHolder {

        private ImageView picIv;
        private TextView titleTv;
        private TextView descriptionTv;
        private TextView ctimeTv;

        public WXHotViewHolder(View itemView) {
            super(itemView);
            picIv = (ImageView) itemView.findViewById(R.id.pic_wxhot_item);
            titleTv = (TextView) itemView.findViewById(R.id.title_wxhot_item);
            descriptionTv = (TextView) itemView.findViewById(R.id.description_wxhot_item);
            ctimeTv = (TextView) itemView.findViewById(R.id.ctime_wxhot_item);
        }

    }

    public void setOnItemClickListener(OnRecyclerViewItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }

}
