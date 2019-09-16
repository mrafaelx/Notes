package ru.fa.notes.mvp.common;

public interface MvpPresenter<T extends MvpView> {
    void attachView(T mvpView);
    void dettachView();
    void destroy();
}
