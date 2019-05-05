package com.example.etnateraapp.dagger;

import android.app.Application;

import com.example.etnateraapp.EtnateraApp;
import com.example.etnateraapp.dagger.module.ActivityBuilder;
import com.example.etnateraapp.dagger.module.AppModule;
import com.example.etnateraapp.dagger.module.FragmentBuilder;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {AndroidSupportInjectionModule.class,
        AppModule.class, FragmentBuilder.class, ActivityBuilder.class})

public interface AppComponent extends AndroidInjector<EtnateraApp> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }

    void inject(EtnateraApp etnateraApp);
}
