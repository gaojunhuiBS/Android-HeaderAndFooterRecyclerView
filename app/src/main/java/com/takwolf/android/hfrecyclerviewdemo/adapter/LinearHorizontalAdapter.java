package com.takwolf.android.hfrecyclerviewdemo.adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.takwolf.android.hfrecyclerviewdemo.R;
import com.takwolf.android.hfrecyclerviewdemo.model.Illust;
import com.takwolf.android.hfrecyclerviewdemo.util.RandomUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnLongClick;

public class LinearHorizontalAdapter extends RecyclerView.Adapter<LinearHorizontalAdapter.ViewHolder> {

    private final Activity activity;
    private final LayoutInflater inflater;
    private final List<Illust> illustList = new ArrayList<>();

    public LinearHorizontalAdapter(@NonNull Activity activity) {
        this.activity = activity;
        inflater = LayoutInflater.from(activity);
    }

    @NonNull
    public List<Illust> getIllustList() {
        return illustList;
    }

    @Override
    public int getItemCount() {
        return illustList.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.item_linear_horizontal, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.update(illustList.get(position));
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.img_thumb)
        ImageView imgThumb;

        private Illust illust;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void update(@NonNull Illust illust) {
            this.illust = illust;
            Glide.with(activity).load(illust.getImage()).placeholder(R.drawable.image_placeholder).into(imgThumb);
        }

        @OnClick(R.id.btn_item)
        void onBtnItemClick() {
            int position = illustList.indexOf(illust);
            int newPosition = Math.abs(RandomUtils.random.nextInt()) % illustList.size();
            illustList.add(newPosition, illustList.remove(position));
            notifyItemMoved(position, newPosition);
        }

        @OnLongClick(R.id.btn_item)
        boolean onBtnItemLongClick() {
            int position = illustList.indexOf(illust);
            illustList.remove(position);
            notifyItemRemoved(position);
            return true;
        }

    }

}
