package com.example.restaurantreview.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.restaurantreview.R;
import java.util.ArrayList;

public class ReviewAdapter extends RecyclerView.Adapter<ReviewAdapter.ViewHolder> {

    private final ArrayList<String> listReview;

    public ReviewAdapter(ArrayList<String> listReview) {
        this.listReview = listReview;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_review, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        String review = listReview.get(position);
        holder.tvReview.setText(review);
    }

    @Override
    public int getItemCount() {
        return listReview.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvReview;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvReview = itemView.findViewById(R.id.tvItem);
        }
    }
}
