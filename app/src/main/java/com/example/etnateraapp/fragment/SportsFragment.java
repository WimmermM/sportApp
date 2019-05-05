package com.example.etnateraapp.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.etnateraapp.R;
import com.example.etnateraapp.model.SportResult;
import com.example.etnateraapp.service.SportService;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;
import dagger.android.support.DaggerFragment;

public class SportsFragment extends DaggerFragment {




    @Inject
    SportResult sportResult;
    @Inject
    SportService sportService;

    @BindView(R.id.sport_Name)
    EditText name;
    @BindView(R.id.sportDuration)
    EditText duration;
    @BindView(R.id.sportLocation)
    EditText location;
    @BindView(R.id.localStorage)
    CheckBox localStorage;
    @BindView(R.id.externaStorage)
    CheckBox externalStorage;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sports,container,false);
        ButterKnife.bind(this, view);
        localCheck();
        externalCheck();
        return view;
    }

    @OnClick(R.id.addButton)
    public void addSportResult(){
        sportResult.setName(name.getText().toString());
        sportResult.setPlace(location.getText().toString());
        sportResult.setTime(Integer.parseInt(duration.getText().toString()));
        if (externalStorage.isChecked()){
            sportResult.setExternalStorage(true);
            sportService.addToFireBase(sportResult);
        }else if (localStorage.isChecked()){
            sportResult.setLocalStorage(true);
            sportService.addToLocalDB(sportResult);
        }
        name.getText().clear();
        location.getText().clear();
        duration.getText().clear();
        externalStorage.setChecked(false);
        localStorage.setChecked(false);
    }

    @OnCheckedChanged(R.id.localStorage)
    public void localCheck(){
        if (localStorage.isChecked()){
            externalStorage.setChecked(false);
        }
    }

    @OnCheckedChanged(R.id.externaStorage)
    public void externalCheck(){
        if (externalStorage.isChecked()){
            localStorage.setChecked(false);
        }
    }

}
