package com.s23010419.agrilink;

import android.content.Context;
import android.icu.util.ULocale;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {

    private Context context;
    private ArrayList<CategoryModel> categoryList;
    private OnCategoryClickListener listener;

    public CategoryAdapter(CategoryBrowserActivity context, List<ULocale.Category> categoryList) {
    }

    // Interface for click handling
    public interface OnCategoryClickListener {
        void onCategoryClick(String categoryName);
    }

    public CategoryAdapter(Context context, ArrayList<CategoryModel> categoryList, OnCategoryClickListener listener) {
        this.context = context;
        this.categoryList = categoryList;
        this.listener = listener;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView categoryImage;
        TextView categoryText;

        public ViewHolder(View itemView) {
            super(itemView);
            categoryImage = itemView.findViewById(R.id.categoryImage);
            categoryText = itemView.findViewById(R.id.categoryText);
        }
    }

    @NonNull
    @Override
    public CategoryAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.activity_category_adapter, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CategoryAdapter.ViewHolder holder, int position) {
        CategoryModel model = categoryList.get(position);
        holder.categoryImage.setImageResource(model.getImageResId());
        holder.categoryText.setText(model.getCategoryName());

        holder.itemView.setOnClickListener(v -> {
            if (listener != null) {
                listener.onCategoryClick(model.getCategoryName());
            }
        });
    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }
}
