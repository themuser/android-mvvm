package xyz.themuser.mvvm;

import android.databinding.ObservableField;
import android.util.Log;
import android.view.View;

import java.util.Objects;

public class MainViewModel {
    private static final String TAG = MainViewModel.class.getSimpleName();

    private final Repository repository;

    public ObservableField<String> first = new ObservableField<>();
    public ObservableField<String> second = new ObservableField<>();
    public ObservableField<String> result = new ObservableField<>();
    private Repository.Item item;

    public MainViewModel(Repository repository) {
        this.repository = repository;
    }

    public void loadRepository(){
        String first = "123";
        String second = "789";
        Repository.Item item = new Repository.Item(first, second);
        loadRepositoryItem(item);
    }

    private void loadRepositoryItem(final Repository.Item item){
        this.first.set(item.first);
        this.second.set(item.second);
    }

    public void onFirstTextChanged(CharSequence s, int start, int before, int count) {
        Log.d(TAG, "onTextChanged " + s);
        this.first.set(s.toString());
        sum();
    }

    public void onSecondTextChanged(CharSequence s, int start, int before, int count) {
        Log.d(TAG, "onTextChanged " + s);
        this.second.set(s.toString());
        sum();
    }

    public void onBtnSumClick(final View v) {
        Log.d(TAG, "btnSumClick.");
        sum();
    }

    private void sum() {
        Log.d(TAG, "Calculate sum");
        final int first = Integer.parseInt(this.first.get() != null && !Objects.requireNonNull(this.first.get()).isEmpty() ? this.first.get() : "0");
        final int second = Integer.parseInt(this.second.get() != null && !Objects.requireNonNull(this.second.get()).isEmpty() ? this.second.get() : "0");
        final int result = first + second;

        this.result.set(result + "");
    }

}
