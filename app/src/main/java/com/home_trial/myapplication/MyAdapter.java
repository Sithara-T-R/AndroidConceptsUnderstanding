package com.home_trial.myapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {


    private final Context context;
    private String[] list;
    private LayoutInflater inflater;

    public MyAdapter(String[] list, Context context) {
        this.list = list;
        this.context = context;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.buttons, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.getButton().setText(list[position]);
    }

    @Override
    public int getItemCount() {
        return list.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private Button button;
        private View.OnClickListener onClickListener = (View v) -> {
            switch (getAdapterPosition()) {

                case 0:
                    EventsInjection.getInstance().inject(MyConstants.RETROFIT);
                    break;


            }
        };

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            button = itemView.findViewById(R.id.button_name);

            button.setOnClickListener(onClickListener);
        }

        public Button getButton() {
            return button;
        }
    }
}