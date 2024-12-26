package com.example.dealfinderapp_v3.ui.myPromotions;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.example.dealfinderapp_v3.Promotion;
import com.example.dealfinderapp_v3.R;
import android.content.Intent;
import com.example.dealfinderapp_v3.ui.promotion.PromotionDetailsActivity;


import java.util.List;

public class MyPromotionsAdapter extends BaseAdapter {

    private List<Promotion> promotionList;
    private Context context;

    public MyPromotionsAdapter(Context context, List<Promotion> actionList) {
        this.context = context;
        this.promotionList = actionList;
    }

    @Override
    public int getCount() {
        return promotionList.size();
    }

    @Override
    public Object getItem(int position) {
        return promotionList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.promotion_from_list, parent, false);
            holder = new ViewHolder();
            holder.imageAction = convertView.findViewById(R.id.image_promotion);
            holder.title = convertView.findViewById(R.id.text_promotion_title);
            holder.establishmentName = convertView.findViewById(R.id.text_establishment_name);
            holder.address = convertView.findViewById(R.id.text_address);
            holder.distance = convertView.findViewById(R.id.text_distance);
            holder.progressBar = convertView.findViewById(R.id.progress_bar);
            holder.promotionsCount = convertView.findViewById(R.id.text_promotions_count);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Promotion promotion = promotionList.get(position);
        holder.title.setText(promotion.getTitle());
        holder.imageAction.setImageDrawable(promotion.getImageDrawable());
        holder.establishmentName.setText(promotion.getEstablishmentName());
        holder.address.setText(promotion.getAddress());
        holder.distance.setText(promotion.getDistance());
        holder.progressBar.setProgress(promotion.getProgress());
        holder.progressBar.setMax(promotion.getMaxProgress());
        holder.promotionsCount.setText(promotion.getProgress() + " из " + promotion.getMaxProgress());

        convertView.setOnClickListener(view -> {
            // Создаем Intent для перехода к Activity PromotionDetailsActivity
            Intent intent = new Intent(context, PromotionDetailsActivity.class);
            // Передаем ID акции в Intent
            intent.putExtra("promotion_id", promotion.getId());
            System.out.println("id: " + promotion.getId());
            // Запускаем новую Activity
            context.startActivity(intent);
        });

        return convertView;
    }

    static class ViewHolder {
        ImageView imageAction;
        TextView title, promotionsCount, establishmentName, address, distance;
        ProgressBar progressBar;
    }
}
