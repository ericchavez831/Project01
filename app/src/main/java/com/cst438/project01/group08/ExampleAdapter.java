package com.cst438.project01.group08;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.ExerciseViewHolder> {
    private List<Exercise> mExampleList;

    public class ExerciseViewHolder extends RecyclerView.ViewHolder {
//        public ImageView mImageView;
        public TextView mName;
        public TextView mEquipment;
        public TextView mTarget;
        public TextView mBodyPart;

        public ExerciseViewHolder(View itemView) {
            super(itemView);
//            mImageView = itemView.findViewById(R.id.imageView);
            mName = itemView.findViewById(R.id.tvExerciseName);
            mEquipment = itemView.findViewById(R.id.tvEquipment);
            mTarget = itemView.findViewById(R.id.tvTarget);
            mBodyPart = itemView.findViewById(R.id.tvBodyPart);
        }

        public void bind(Exercise exercise) {
//            Glide.with(itemView)
//                    .load(exercise.getGifUrl())
//                    .into(mImageView);

            mName.setText("Exercise: " + exercise.getName());
            mEquipment.setText("Equipment: " + exercise.getEquipment());
            mTarget.setText("Target Muscle: " + exercise.getTarget());
            mBodyPart.setText("Body Part: " + exercise.getBodyPart() + "\n");
        }
    }

    public ExampleAdapter(List<Exercise> exampleList) {
        mExampleList = exampleList;
    }

    @Override
    public ExerciseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_exercise, parent, false);
        ExerciseViewHolder evh = new ExerciseViewHolder(v);
        return evh;
    }

    @Override
    public void onBindViewHolder(@NonNull ExerciseViewHolder holder, int position) {
        Exercise exercise = mExampleList.get(position);
        holder.bind(exercise);
    }

    @Override
    public int getItemCount() {
        return mExampleList.size();
    }
}
