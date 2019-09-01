package com.example.musicandvideo.viewmodel;


import android.content.Context;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.example.musicandvideo.model.PlayerModel;

public class AppBarMainModel extends BaseObservable{

    ContentMainModel contentMainModel = null;


    private Context context;
    private PlayerModel playerModel;
    public AppBarMainModel(Context context){
        this.context = context;
    }

    @Bindable
    public ContentMainModel getContentMainModel(){
        return contentMainModel;
    }

    public void setContentMainModel(ContentMainModel contentMainModel){
        this.contentMainModel = contentMainModel;
    }

    public void init(PlayerModel playerModel){
        this.playerModel = playerModel;
        this.contentMainModel = new ContentMainModel(this.context);
    }

}