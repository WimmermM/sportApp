package com.example.etnateraapp.dagger.module;

import com.example.etnateraapp.fragment.MyListFragment;
import com.example.etnateraapp.fragment.SportsFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class FragmentBuilder {

    @ContributesAndroidInjector()
    abstract MyListFragment myListFragment();

    @ContributesAndroidInjector
    abstract SportsFragment sportsFragment();

}
