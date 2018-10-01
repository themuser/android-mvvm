package xyz.themuser.mvvm;

public interface BaseViewModel {
    void onCreate();

    void onResume();

    void onPause();

    void onDestroy();
}
