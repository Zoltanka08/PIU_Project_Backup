package com.pluralsight.zoltan.personalbrokergood.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Environment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.pluralsight.zoltan.personalbrokergood.R;
import com.pluralsight.zoltan.personalbrokergood.fragment.NewsFragment.OnNewsInteractionListener;

import java.io.File;
import java.util.List;

import MockDatabase.Models.Database.SecurityData;
import MockDatabase.Models.News;
import MockDatabase.Models.Security;

/**
 * {@link RecyclerView.Adapter} that can display a {@link News} and makes a call to the
 * specified {@link OnNewsInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    private Context context;

    private final List<News> mValues;
    private final OnNewsInteractionListener mListener;

    public NewsAdapter(List<News> items, OnNewsInteractionListener listener, Context context) {
        mValues = items;
        mListener = listener;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_news, parent, false);
        return new ViewHolder(view);
    }

    private void setupImage(int position, ViewHolder holder){
        switch(position){
            case 0:
                holder.mImageView.setImageResource(R.drawable.gold);
                break;
            case 1:
                holder.mImageView.setImageResource(R.drawable.gas_flare);
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            case 8:
                break;
            default:
                break;
        }
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mNameView.setText(mValues.get(position).getTitle());
        holder.mDateView.setText(mValues.get(position).getDate());

        Security security = SecurityData.portfolioSecurities.get(position);

        setupImage(position, holder);

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onNewsInteraction(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mNameView;
        public final TextView mDateView;
        public final ImageView mImageView;
        public News mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mNameView = (TextView) view.findViewById(R.id.news_title);
            mDateView = (TextView) view.findViewById(R.id.news_date);
            mImageView = (ImageView) view.findViewById(R.id.news_image);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mNameView.getText() + "'";
        }


    }
}
