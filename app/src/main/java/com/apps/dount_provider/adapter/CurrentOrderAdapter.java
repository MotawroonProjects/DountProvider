

package com.apps.dount_provider.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.apps.dount_provider.R;
import com.apps.dount_provider.databinding.OrderRowBinding;
import com.apps.dount_provider.model.OrderModel;
import com.apps.dount_provider.uis.activity_home.fragments_home_navigaion.FragmentHome;

import java.util.List;

public class CurrentOrderAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<OrderModel> list;
    private Context context;
    private LayoutInflater inflater;
    private Fragment fragment;


    public CurrentOrderAdapter(Context context, Fragment fragment) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.fragment = fragment;
    }

    @androidx.annotation.NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@androidx.annotation.NonNull ViewGroup parent, int viewType) {


        OrderRowBinding binding = DataBindingUtil.inflate(inflater, R.layout.order_row, parent, false);
        return new MyHolder(binding);


    }

    @Override
    public void onBindViewHolder(@androidx.annotation.NonNull RecyclerView.ViewHolder holder, int position) {

        MyHolder myHolder = (MyHolder) holder;
        myHolder.binding.setModel(list.get(position));


        myHolder.binding.btnDetails.setOnClickListener(v -> {
            if (fragment instanceof FragmentHome) {
                FragmentHome fragmentHome = (FragmentHome) fragment;
                fragmentHome.showDetails(list.get(myHolder.getAdapterPosition()));

            }
        });

        myHolder.binding.flCancel.setOnClickListener(v -> {
            if (fragment instanceof FragmentHome) {
                FragmentHome fragmentHome = (FragmentHome) fragment;
                fragmentHome.cancel(list.get(myHolder.getAdapterPosition()),myHolder.getAdapterPosition());

            }
        });

    }

    @Override
    public int getItemCount() {
        if (list != null) {
            return list.size();
        } else {
            return 0;
        }
    }

    public static class MyHolder extends RecyclerView.ViewHolder {
        public OrderRowBinding binding;

        public MyHolder(OrderRowBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }
    }

    public void updateList(List<OrderModel> list) {
        this.list = list;
        notifyDataSetChanged();
    }

}
