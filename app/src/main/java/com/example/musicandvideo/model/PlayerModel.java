package com.example.musicandvideo.model;


import android.util.Log;
import android.view.View;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;


public class PlayerModel extends BaseObservable{
    boolean selectedMusic = true;
    public static final String TAG = "PlayModel";


    @Bindable
    public boolean getSelectedMusic(){
        return selectedMusic;
    }

    public void setSelectedMusic(boolean selectedMusic){
        this.selectedMusic = selectedMusic;
    }

    public void onMusicClick(View view){

        if(!this.selectedMusic){
            this.selectedMusic = true;
            notifyPropertyChanged(com.example.musicandvideo.BR.selectedMusic);
        }
        Log.i(TAG, "onMusicClick:"+this.selectedMusic);
    }

    public void onVideoClick(View view){
        if(this.selectedMusic){
            this.selectedMusic = false;
            notifyPropertyChanged(com.example.musicandvideo.BR.selectedMusic);
        }
        Log.i(TAG, "onVideoClick:"+this.selectedMusic);
    }

}