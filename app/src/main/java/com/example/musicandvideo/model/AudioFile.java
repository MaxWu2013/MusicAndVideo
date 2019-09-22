package com.example.musicandvideo.model;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;

import com.example.musicandvideo.R;

class AudioFile implements MediaFile{

    @Override
    public FileType getType() {
        return FileType.AUDIO;
    }

    @Override
    public String getSrc() {
        return Environment.getExternalStorageDirectory()+"/mp3/bear.mp3";
    }

    @Override
    public Bitmap getThumbnail() {
        return BitmapFactory.decodeResource(null, R.mipmap.ic_launcher);
    }

    @Override
    public String getArtWork() {
        return "Truly love you";
    }

    @Override
    public String getArtist() {
        return "Beyond";
    }

    @Override
    public String getName() {
        return "Say goodbye to ideal";
    }
}
