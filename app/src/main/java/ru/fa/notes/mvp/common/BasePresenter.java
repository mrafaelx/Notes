package ru.fa.notes.mvp.common;

public class BasePresenter<T extends MvpView> implements MvpPresenter<T> {

    private T view = null;

    @Override
    public void attachView(T mvpView) {
        view = mvpView;
    }

    @Override
    public void dettachView() {
        view = null;
    }

    @Override
    public void destroy() {

    }
}
