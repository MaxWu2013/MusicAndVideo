package com.example.musicandvideo.model;


import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.BindingAdapter;

public class PlayerModel extends BaseObservable{
    boolean selectedMusic = true;



    @Bindable
    public boolean getSelectedMusic(){
        return selectedMusic;
    }

    public void setSelectedMusic(boolean selectedMusic){
        this.selectedMusic = selectedMusic;
    }

    @BindingAdapter("android:onClick")
    public void onMusicClick(){
        this.selectedMusic = true;
    }
    @BindingAdapter("android:onClick")
    public void onVideoClick(){
        this.selectedMusic = false;
    }

}