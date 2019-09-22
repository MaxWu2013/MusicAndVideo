package com.example.musicandvideo.testData;

import com.example.musicandvideo.model.MediaFile;
import com.example.musicandvideo.model.MediaFileFactory;

import java.util.ArrayList;

public class Test {
    public static ArrayList<MediaFile> MusicList = new ArrayList<MediaFile>();
    public static ArrayList<MediaFile> FilmList = new ArrayList<MediaFile>();


    public static void initTestingData(){
        for(int i=0; i<40 ;i++){
            MusicList.add(MediaFileFactory.createMusicFile());
            FilmList.add(MediaFileFactory.createFilmFile());
        }
    }
}
