package com.jaeyoung.myapplication.presenter;

import com.jaeyoung.myapplication.data.domain.Data;

public class MainViewHolderPresenter {

    private MainViewHolderPresenter.View view;
    public MainViewHolderPresenter(MainViewHolderPresenter.View view) {
        this.view = view;
    }

    public void bindView(int position, MainAdapterPresenter presenter) {
        Data data = presenter.getItem(position);

        view.setName(data.name);
        view.setSalary(data.salary);
    }

    public interface View {
        void setName(String name);
        void setSalary(String salary);
    }
}
