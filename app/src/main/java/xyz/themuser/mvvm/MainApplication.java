package xyz.themuser.mvvm;

import android.app.Application;
import android.os.StrictMode;

public class MainApplication extends Application {

    @Override
    public void onCreate() {
        if (BuildConfig.DEBUG) {
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
                .detectAll()
                .penaltyLog()
                .build());

            StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
                .detectAll()
                .penaltyLog()
                .penaltyDeath()
                .build());
        }
        super.onCreate();
    }

    public IRepository getRepository() {
        return new Repository();
    }
}
