package com.example.musicandvideo.view;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.databinding.DataBindingUtil;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.musicandvideo.R;
import com.example.musicandvideo.databinding.ActivityMainBinding;
import com.example.musicandvideo.model.PlayerModel;
import com.example.musicandvideo.viewmodel.MainActivityModel;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private PlayerModel playerModel;
    private MainActivityModel mainActivityMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        playerModel = new PlayerModel();
        mainActivityMode = new MainActivityModel(this);

        binding.setPlayerModel(playerModel);
        binding.setMainModel(mainActivityMode);

        mainActivityMode.init(binding,playerModel);

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
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
