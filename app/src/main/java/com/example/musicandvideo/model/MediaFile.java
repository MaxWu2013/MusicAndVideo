package com.example.musicandvideo.model;

import android.graphics.Bitmap;

public interface MediaFile {
    public FileType getType();
    public String getSrc();
    public Bitmap getThumbnail();
    public String getArtWork();
    public String getArtist();
    public String getName();
}
