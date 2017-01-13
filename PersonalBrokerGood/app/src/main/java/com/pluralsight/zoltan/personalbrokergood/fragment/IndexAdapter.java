package com.pluralsight.zoltan.personalbrokergood.fragment;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pluralsight.zoltan.personalbrokergood.R;
import com.pluralsight.zoltan.personalbrokergood.fragment.IndexFragment.OnIndexInteractionListener;

import java.util.List;

import MockDatabase.Models.Database.IndexData;
import MockDatabase.Models.Security;

/**
 * {@link RecyclerView.Adapter} that can display a {@link Security} and makes a call to the
 * specified {@link OnIndexInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class IndexAdapter extends RecyclerView.Adapter<IndexAdapter.ViewHolder> {

    private final List<Security> mValues;
    private final OnIndexInteractionListener mListener;

    public IndexAdapter(List<Security> items, OnIndexInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_index, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        holder.mItem = mValues.get(position);
        holder.mNameView.setText(mValues.get(position).getName());
        holder.mDateView.setText(mValues.get(position).getDate());
        holder.mTypeView.setText(mValues.get(position).getType());
        holder.mPriceView.setText(mValues.get(position).getPrice());
        holder.mRateView.setText(mValues.get(position).getRate());
        holder.mPercentageView.setText(mValues.get(position).getPercentage());

        boolean ascending = mValues.get(position).getAscending();

        if(ascending) {
            holder.mRateView.setTextColor(Color.GREEN);
            holder.mPercentageView.setTextColor(Color.GREEN);
        }
        else {
            holder.mRateView.setTextColor(Color.RED);
            holder.mPercentageView.setTextColor(Color.RED);
        }

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onIndexInteraction(holder.mItem);
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
        public final TextView mTypeView;
        public final TextView mPriceView;
        public final TextView mRateView;
        public final TextView mPercentageView;
        public Security mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mNameView = (TextView) view.findViewById(R.id.index2_name);
            mDateView = (TextView) view.findViewById(R.id.index2_date);
            mTypeView = (TextView) view.findViewById(R.id.index2_type);
            mPriceView = (TextView) view.findViewById(R.id.index2_price);
            mRateView = (TextView) view.findViewById(R.id.index2_rate);
            mPercentageView = (TextView) view.findViewById(R.id.index2_percentage);


        }

        @Override
        public String toString() {
            return super.toString() + " '" + mNameView.getText() + "'";
        }
    }
}
