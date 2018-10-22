package xyz.themuser.mvvm;

import android.databinding.ObservableField;
import android.util.Log;
import android.view.View;

import java.util.Objects;

public class MainViewModel {
    private static final String TAG = MainViewModel.class.getSimpleName();


    public ObservableField<String> first = new ObservableField<>();
    public ObservableField<String> second = new ObservableField<>();
    public ObservableField<String> result = new ObservableField<>();

    public MainViewModel(IRepository repository) {
        loadRepository(repository);
    }

    public void loadRepository(IRepository repository) {
//        loadRepositoryItem(this.repository.getItem());
        final IRepository.Item item = repository.getItem();
        if (item != null) {
            this.first.set(item.first);
            this.second.set(item.second);
        }
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

    public void sum() {
        Log.d(TAG, "Calculate sum");
        final int first = Integer.parseInt(this.first.get() != null && !Objects.requireNonNull(this.first.get()).isEmpty() ? this.first.get() : "0");
        final int second = Integer.parseInt(this.second.get() != null && !Objects.requireNonNull(this.second.get()).isEmpty() ? this.second.get() : "0");
        final int result = first + second;

        this.result.set(result + "");
    }

}
