package com.jaeyoung.myapplication.presenter;

import com.jaeyoung.myapplication.data.domain.Data;

import java.util.List;

public class MainAdapterPresenter {

    private MainAdapterPresenter.View view;
    private List<Data> items;

    public MainAdapterPresenter(MainAdapterPresenter.View view) {
        this.view = view;
    }

    public void addItems(List<Data> items) {
        if(this.items == null) {
            this.items = items;
        } else {
            this.items.addAll(items);
        }

        view.notifyAdapter();
    }

    public int getItemCount() {
        return items == null ? 0 : items.size();
    }

    public Data getItem(int position) {
        return items == null ? null : items.get(position);
    }

    public interface View {
        void notifyAdapter();
    }
}
