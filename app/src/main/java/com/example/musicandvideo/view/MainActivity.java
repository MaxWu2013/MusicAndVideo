package com.example.musicandvideo.view;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.databinding.DataBindingUtil;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.musicandvideo.R;
import com.example.musicandvideo.databinding.ActivityMainBinding;
import com.example.musicandvideo.viewmodel.MainActivityModel;

public class MainActivity extends AppCompatActivity implements
        PlayListFragment.OnFragmentInteractionListener,
        PlayScreenFragment.OnPlayScreenFragmentInteractionListener {

    private ActivityMainBinding binding;
    private MainActivityModel mainActivityMode;
    private String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        mainActivityMode = new MainActivityModel(this);

        binding.setMainModel(mainActivityMode);

        mainActivityMode.init(binding);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onPlayListFragmentInteraction(Uri uri) {
        if(null != uri){
            String url = uri.toString();
            Log.i(TAG,"url:"+url);
            mainActivityMode.switchToPlayerFragment(uri);
        }
    }

    @Override
    public void onPlayScreenFragmentInteraction(Uri uri) {
        if(null != uri){
            String url = uri.toString();
            Log.i(TAG,"url:"+url);
        }
    }
}
