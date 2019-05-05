package com.example.etnateraapp.dagger.module;

import com.example.etnateraapp.activity.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector
    abstract MainActivity bindsMainActivity();
}
