package xyz.themuser.mvvm;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;

import xyz.themuser.mvvm.databinding.ActivityMainBinding;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final Repository repository = ((MainApplication)getApplication()).getRepository();

        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        MainViewModel viewModel = new MainViewModel(repository);
        viewModel.loadRepository();
        binding.setViewModel(viewModel);
    }
}
