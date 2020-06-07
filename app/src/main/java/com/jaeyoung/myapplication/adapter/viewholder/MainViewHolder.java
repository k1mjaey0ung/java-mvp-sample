package com.jaeyoung.myapplication.adapter.viewholder;

import androidx.recyclerview.widget.RecyclerView;

import com.jaeyoung.myapplication.R;
import com.jaeyoung.myapplication.databinding.ListItemBinding;
import com.jaeyoung.myapplication.presenter.MainViewHolderPresenter;

import java.text.DecimalFormat;

public class MainViewHolder extends RecyclerView.ViewHolder implements MainViewHolderPresenter.View{
    private ListItemBinding binding;

    private MainViewHolderPresenter presenter = new MainViewHolderPresenter(this);
    public MainViewHolderPresenter getPresenter() {
        return presenter;
    }

    public MainViewHolder(ListItemBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }


    @Override
    public void setName(String name) {
        binding.tvTitle.setText(name);
    }

    @Override
    public void setSalary(String salary) {
        binding.tvBody.setText(String.format(
                binding.getRoot().getResources().getString(R.string.salary),
                new DecimalFormat("#,###").format(Long.parseLong(salary))));
    }
}
