package com.example.musicandvideo.model;

public class MediaFileFactory {

    public static MediaFile createMusicFile(){
        MediaFile file = new AudioFile();
        return file;
    }

    public static MediaFile createFilmFile(){
        MediaFile file = new VideoFile();
        return file;
    }
}
