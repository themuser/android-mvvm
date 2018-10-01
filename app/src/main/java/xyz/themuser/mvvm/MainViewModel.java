package xyz.themuser.mvvm;

import android.databinding.BaseObservable;
import android.util.Log;
import android.view.View;

public class MainViewModel extends BaseObservable {
    private static final String TAG = MainViewModel.class.getSimpleName();

    private String first;
    private String second;
    private String result;

    public MainViewModel(String first, String second){
        this.first = first;
        this.second = second;
    }

    public void sum() {
        result = (Integer.parseInt(first) + Integer.parseInt(second)) + "";
        notifyChange();
    }

    public void onBtnSumClick(View v) {
        Log.d(TAG, "btnSumClick.");
        sum();
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getSecond() {
        return second;
    }

    public void setSecond(String second) {
        this.second = second;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
