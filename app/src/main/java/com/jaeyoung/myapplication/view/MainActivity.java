package com.jaeyoung.myapplication.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;

import com.jaeyoung.myapplication.adapter.MainAdapter;
import com.jaeyoung.myapplication.data.domain.Data;
import com.jaeyoung.myapplication.databinding.ActivityMainBinding;
import com.jaeyoung.myapplication.presenter.MainPresenter;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainPresenter.View {
    private ActivityMainBinding binding;
    private MainAdapter adapter;
    private MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        presenter = new MainPresenter(this);
        adapter = new MainAdapter();

        setRecyclerView();
        start();
    }

    @Override
    protected void onDestroy() {
        presenter.clearDisposable();
        super.onDestroy();
    }

    private void setRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        binding.rvContents.setLayoutManager(layoutManager);
        binding.rvContents.setAdapter(adapter);
    }

    private void start() {
        presenter.fetchItems();
    }

    @Override
    public void addItems(List<Data> items) {
        adapter.getPresenter().addItems(items);
    }

    @Override
    public void showLoadingIndicator() {

    }

    @Override
    public void hideLoadingIndicator() {

    }
}
