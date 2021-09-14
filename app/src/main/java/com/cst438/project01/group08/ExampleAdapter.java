package com.cst438.project01.group08;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
public class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder> {
    private ArrayList<ExampleExercise> mExampleList;
    public static class ExampleViewHolder extends RecyclerView.ViewHolder {
        public ImageView mImageView;
        public TextView mName;
        public TextView mEquipment;
        public TextView mTarget;
        public TextView mBodyPart;

        public ExampleViewHolder(View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.imageView);
            mName = itemView.findViewById(R.id.tvExerciseName);
            mEquipment = itemView.findViewById(R.id.tvEquipment);
            mTarget = itemView.findViewById(R.id.tvTarget);
            mBodyPart = itemView.findViewById(R.id.tvBodyPart);
        }
    }
    public ExampleAdapter(ArrayList<ExampleExercise> exampleList) {
        mExampleList = exampleList;
    }
    @Override
    public ExampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_exercise, parent, false);
        ExampleViewHolder evh = new ExampleViewHolder(v);
        return evh;
    }
    @Override
    public void onBindViewHolder(ExampleViewHolder holder, int position) {
        ExampleExercise currentItem = mExampleList.get(position);
        holder.mName.setText(currentItem.getName());
        holder.mEquipment.setText(currentItem.getEquipment());
        holder.mTarget.setText(currentItem.getTarget());
        holder.mBodyPart.setText(currentItem.getBodyPart());
    }
    @Override
    public int getItemCount() {
        return mExampleList.size();
    }
}
