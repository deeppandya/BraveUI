package com.example.braveui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TimerDialogFragment extends BottomSheetDialogFragment {
    public static final String TAG = TimerDialogFragment.class.getName();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_timer_dialog_list_dialog, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        final RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.timer_action_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        List<TimerItemModel> timerItemModels = new ArrayList<>(Arrays.asList(new TimerItemModel(requireContext().getString(R.string.pause_for_15_minutes), R.drawable.ic_pause_filled), new TimerItemModel(requireContext().getString(R.string.pause_for_1_hour), R.drawable.ic_pause_filled), new TimerItemModel(requireContext().getString(R.string.disable), R.drawable.ic_disabled)));
        recyclerView.setAdapter(new TimerItemAdapter(timerItemModels));

        View cancelView = view.findViewById(R.id.cancel_view);
        TextView timerActionText = cancelView.findViewById(R.id.timer_action_text);
        ImageView timerActionImage = cancelView.findViewById(R.id.timer_action_image);
        TimerItemModel timerItemModel = new TimerItemModel(requireContext().getString(android.R.string.cancel), R.drawable.ic_cancel_filled);
        timerActionText.setText(timerItemModel.getActionText());
        timerActionImage.setImageResource(timerItemModel.getActionImage());
    }

    private static class TimerViewHolder extends RecyclerView.ViewHolder {

        final TextView timerActionText;
        final ImageView timerActionImage;

        public TimerViewHolder(@NonNull View itemView) {
            super(itemView);
            this.timerActionText = itemView.findViewById(R.id.timer_action_text);
            this.timerActionImage = itemView.findViewById(R.id.timer_action_image);
        }
    }

    private static class TimerItemAdapter extends RecyclerView.Adapter<TimerViewHolder> {

        private final List<TimerItemModel> mTimerItemModels;

        TimerItemAdapter(List<TimerItemModel> timerItemModels) {
            mTimerItemModels = timerItemModels;
        }

        @NonNull
        @Override
        public TimerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            View timerItem = layoutInflater.inflate(R.layout.fragment_timer_dialog_list_dialog_item, parent, false);
            return new TimerViewHolder(timerItem);
        }

        @Override
        public void onBindViewHolder(TimerViewHolder holder, int position) {
            TimerItemModel timerItemModel = mTimerItemModels.get(position);
            holder.timerActionText.setText(timerItemModel.getActionText());
            holder.timerActionImage.setImageResource(timerItemModel.getActionImage());
            holder.itemView.setOnClickListener(view -> Toast.makeText(view.getContext(), timerItemModel.getActionText(), Toast.LENGTH_SHORT).show());
        }

        @Override
        public int getItemCount() {
            return mTimerItemModels.size();
        }

    }
}
