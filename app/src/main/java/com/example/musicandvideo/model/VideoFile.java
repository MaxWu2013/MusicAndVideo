package com.example.musicandvideo.model;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;

import com.example.musicandvideo.R;

class VideoFile implements MediaFile {

    String src;


    @Override
    public FileType getType() {
        return FileType.VIDEO;
    }

    @Override
    public String getSrc() {
        return Environment.getExternalStorageDirectory()+"/mp4/sample.mp4";
    }

    @Override
    public Bitmap getThumbnail() {
        return BitmapFactory.decodeResource(null, R.mipmap.ic_launcher);
    }

    @Override
    public String getArtWork() {
        return "Albulm";
    }

    @Override
    public String getArtist() {
        return "anump";
    }

    @Override
    public String getName() {
        return "Haven of history";
    }
}
