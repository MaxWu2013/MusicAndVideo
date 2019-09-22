package com.example.musicandvideo.viewmodel;


import android.util.Log;
import android.view.View;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;

import com.example.musicandvideo.R;
import com.example.musicandvideo.databinding.ActivityMainBinding;
import com.example.musicandvideo.view.MainActivity;
import com.example.musicandvideo.view.PlayListFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

public class MainActivityModel extends BaseObservable{


    boolean selectedMusic = true;
    public static final String TAG = "MainActivityModel";

    private MainActivity mainActivity = null;
    public MainActivityModel(MainActivity context){
        this.mainActivity = context;
    }


    public void init(ActivityMainBinding binding ){
        Toolbar toolbar = binding.appBarMain.toolbar;
        mainActivity.setSupportActionBar(toolbar);

        FloatingActionButton fab = binding.appBarMain.fab;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                mainActivity, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
    }

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
        //need to notify PlayListFragment to refresh UI

        FragmentManager fragmentManager = mainActivity.getSupportFragmentManager();
        PlayListFragment fragment = (PlayListFragment) fragmentManager.findFragmentByTag(PlayListFragment.class.getName());
        fragment.switchToAudioList();
    }

    public void onVideoClick(View view){
        if(this.selectedMusic){
            this.selectedMusic = false;
            notifyPropertyChanged(com.example.musicandvideo.BR.selectedMusic);
        }
        Log.i(TAG, "onVideoClick:"+this.selectedMusic);

        FragmentManager fragmentManager = mainActivity.getSupportFragmentManager();
        PlayListFragment fragment = (PlayListFragment) fragmentManager.findFragmentByTag(PlayListFragment.class.getName());
        fragment.switchToVideoList();
    }
}