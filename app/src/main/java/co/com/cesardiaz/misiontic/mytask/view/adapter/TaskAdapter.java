package co.com.cesardiaz.misiontic.mytask.view.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import co.com.cesardiaz.misiontic.mytask.R;
import co.com.cesardiaz.misiontic.mytask.presenter.MainPresenter;
import co.com.cesardiaz.misiontic.mytask.view.dto.TaskItem;
import co.com.cesardiaz.misiontic.mytask.view.dto.TaskState;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.ViewHolder> {
    private List<TaskItem> data;
    private OnItemClickListener listener;
    private OnItemClickListener longListener;

    public TaskAdapter() {
        data = new ArrayList<>();
    }

    public void setData(List<TaskItem> data) {
        Log.i(TaskAdapter.class.getSimpleName(), "set data");
        this.data = data;
        notifyDataSetChanged();
    }

    public void addItem(TaskItem item) {
        Log.i(TaskAdapter.class.getSimpleName(), "Add new item");
        data.add(item);
        notifyItemInserted(data.size() - 1);
    }

    public void setClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public void setLongClickListener(OnItemClickListener listener) {
        this.longListener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_task, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        TaskItem item = data.get(position);

        if (listener != null) {
            holder.itemView.setOnClickListener(v -> listener.onClick(item));
        }

        if (longListener != null) {
            holder.itemView.setOnLongClickListener(v -> {
                longListener.onClick(item);
                return false;
            });
        }

        holder.tvDescription.setText(item.getDescription());
        holder.tvDate.setText(item.getDate());
        int color = item.getState() == TaskState.PENDING ? R.color.task_pending : R.color.task_done;

        holder.ivIcon.setColorFilter(
                ContextCompat.getColor(holder.itemView.getContext(), color),
                android.graphics.PorterDuff.Mode.MULTIPLY);
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    public void updateTask(TaskItem task) {
        int i = data.indexOf(task);
        TaskItem item = data.get(i);
        item.setState(task.getState());
        notifyItemChanged(i);
    }

    public void removeTask(TaskItem task) {
        int i = data.indexOf(task);
        data.remove(i);
        notifyItemRemoved(i);
    }

    protected class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView ivIcon;
        private final TextView tvDescription;
        private final TextView tvDate;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            ivIcon = itemView.findViewById(R.id.iv_icon);
            tvDescription = itemView.findViewById(R.id.tv_description);
            tvDate = itemView.findViewById(R.id.tv_date);
        }
    }

    public interface OnItemClickListener {
        void onClick(TaskItem item);
    }
}
