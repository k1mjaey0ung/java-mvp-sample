package com.jaeyoung.myapplication.presenter;

import com.jaeyoung.myapplication.data.domain.Data;
import com.jaeyoung.myapplication.data.response.DataResponse;
import com.jaeyoung.myapplication.repository.DataRepository;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MainPresenter {
    private MainPresenter.View view;

    private CompositeDisposable disposables = new CompositeDisposable();
    private DataRepository repository = new DataRepository();

    public MainPresenter(MainPresenter.View view) {
        this.view = view;
    }


    public void fetchItems() {
        view.showLoadingIndicator();
        disposables.add(repository.create().getData()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(this::handleResponse, this::handleError));
    }

    private void handleResponse(DataResponse response) {
        view.addItems(response.items);
        view.hideLoadingIndicator();
    }

    private void handleError(Throwable t) {
        view.hideLoadingIndicator();
    }

    public void clearDisposable() {
        disposables.clear();
    }

    public interface View {
        void addItems(List<Data> items);
        void showLoadingIndicator();
        void hideLoadingIndicator();
    }
}
