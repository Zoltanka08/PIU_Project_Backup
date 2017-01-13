package com.pluralsight.zoltan.personalbrokergood.fragment;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.pluralsight.zoltan.personalbrokergood.R;
import com.pluralsight.zoltan.personalbrokergood.fragment.CurrencyFragment.OnCurrencyFragmentInteractionListener;

import java.util.List;

import MockDatabase.Models.Currency;

/**
 * {@link RecyclerView.Adapter} that can display a {@link Currency} and makes a call to the
 * specified {@link OnCurrencyFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class CurrencyAdapter extends RecyclerView.Adapter<CurrencyAdapter.ViewHolder> {

    private final List<Currency> mValues;
    private final OnCurrencyFragmentInteractionListener mListener;

    public CurrencyAdapter(List<Currency> items, OnCurrencyFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_currency, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mNameView.setText(mValues.get(position).getName());
        holder.mEuroView.setText(mValues.get(position).getEuroValue());
        holder.mRateView.setText(mValues.get(position).getRate());

        if(mValues.get(position).getIsAsc()){
            holder.mRateView.setTextColor(Color.GREEN);
        }
        else
        {
            holder.mRateView.setTextColor(Color.RED);
        }

        setupFlags(position, holder);

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onCurrencyInteraction(holder.mItem);
                }
            }
        });
    }

    private void setupFlags(int id, ViewHolder holder){
        switch (id){
            case 0: holder.mImageView.setImageResource(R.drawable.usa_flag);
                break;
            case 1: holder.mImageView.setImageResource(R.drawable.gbd_flag);
                break;
            case 2: holder.mImageView.setImageResource(R.drawable.ron_flag);
                break;
            default: holder.mImageView.setImageResource(R.drawable.usa_flag);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mNameView;
        public final TextView mRateView;
        public final TextView mEuroView;
        public final ImageView mImageView;
        public Currency mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mNameView = (TextView) view.findViewById(R.id.currency_name);
            mRateView = (TextView) view.findViewById(R.id.currency_rate);
            mEuroView = (TextView) view.findViewById(R.id.currency_euro_value);
            mImageView = (ImageView) view.findViewById(R.id.currency_flag);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mNameView.getText() + "'";
        }
    }
}
