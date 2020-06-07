package com.jaeyoung.myapplication.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jaeyoung.myapplication.adapter.viewholder.MainViewHolder;
import com.jaeyoung.myapplication.databinding.ListItemBinding;
import com.jaeyoung.myapplication.presenter.MainAdapterPresenter;


public class MainAdapter extends RecyclerView.Adapter<MainViewHolder> implements MainAdapterPresenter.View {

    private MainAdapterPresenter presenter = new MainAdapterPresenter(this);

    public MainAdapterPresenter getPresenter() {
        return presenter;
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MainViewHolder(ListItemBinding.inflate(
            LayoutInflater.from(parent.getContext()), parent, false
        ));
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
        holder.getPresenter().bindView(position, presenter);
    }

    @Override
    public int getItemCount() {
        return presenter.getItemCount();
    }

    @Override
    public void notifyAdapter() {
        notifyDataSetChanged();
    }
}
