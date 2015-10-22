package com.hitherejoe.pickr.injection.module;

import android.app.Application;

import com.hitherejoe.pickr.data.DataManager;
import com.hitherejoe.pickr.util.TestDataManager;
import com.squareup.otto.Bus;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Provides application-level dependencies for an app running on a testing environment
 * This allows injecting mocks if necessary.
 */
@Module
public class ApplicationTestModule {
    private final Application mApplication;

    public ApplicationTestModule(Application application) {
        mApplication = application;
    }

    @Provides
    @Singleton
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    @Singleton
    DataManager provideDataManager() {
        return new TestDataManager(mApplication);
    }

    @Provides
    @Singleton
    Bus provideEventBus() {
        return new Bus();
    }
}