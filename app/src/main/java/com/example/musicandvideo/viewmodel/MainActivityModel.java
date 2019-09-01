package com.example.musicandvideo.viewmodel;


import android.view.View;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.musicandvideo.R;
import com.example.musicandvideo.databinding.ActivityMainBinding;
import com.example.musicandvideo.model.PlayerModel;
import com.example.musicandvideo.view.MainActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

public class MainActivityModel extends BaseObservable{


    AppBarMainModel appBarMainModel = null;
    PlayerModel playerModel = null;

    private MainActivity context = null;
    public MainActivityModel(MainActivity context){
        this.context = context;
    }

    @Bindable
    public AppBarMainModel getAppBarMainModel(){
        return appBarMainModel;
    }

    public void setAppBarMainModel(AppBarMainModel appBarMainModel){
        this.appBarMainModel = appBarMainModel;
    }

    public void init(ActivityMainBinding binding, PlayerModel playerModel){
        this.playerModel = playerModel;
        Toolbar toolbar = binding.appBarMain.toolbar;
        context.setSupportActionBar(toolbar);


        this.appBarMainModel = new AppBarMainModel(this.context);
        this.appBarMainModel.init(this.playerModel);

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
                context, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
    }

}