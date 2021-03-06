package com.changebooths.Services;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.changebooths.Services.location.LocationContent.LocationItem;
import com.changebooths.R;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link LocationItem} and makes a call to the
 * specified {@link LocalServiceFragment.OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyLocalServiceRecyclerViewAdapter extends RecyclerView.Adapter<MyLocalServiceRecyclerViewAdapter.ViewHolder> {

    private final List<LocationItem> mValues;
    private final LocalServiceFragment.OnListFragmentInteractionListener mListener;
    private final Context ctx;

    public MyLocalServiceRecyclerViewAdapter(List<LocationItem> items, LocalServiceFragment.OnListFragmentInteractionListener listener, Context ctx) {
        mValues = items;
        mListener = listener;
        this.ctx = ctx;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_localservice, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        //holder.mIdView.setText(mValues.get(position).id);
        holder.serviceIcon.setImageDrawable(ContextCompat.getDrawable(this.ctx, mValues.get(position).serviceDrawable));
        holder.mContentView.setText(mValues.get(position).name);

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);
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
        public final ImageView serviceIcon;
        public final TextView mContentView;
        public LocationItem mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            serviceIcon = (ImageView) view.findViewById(R.id.serviceIcon);
            //mIdView = (TextView) view.findViewById(R.id.id);
            mContentView = (TextView) view.findViewById(R.id.content);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}
