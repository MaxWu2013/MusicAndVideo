package com.example.musicandvideo.view;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.library.baseAdapters.BR;
import androidx.recyclerview.widget.RecyclerView;

import com.example.musicandvideo.R;
import com.example.musicandvideo.model.FileType;
import com.example.musicandvideo.model.MediaFile;
import com.example.musicandvideo.testData.Test;

import java.util.ArrayList;

public class PlayListAdapter extends RecyclerView.Adapter {

    public interface OnItemClickListener{
         void onItemCLick(View view, MediaFile mediaFile);
    }


    public class PlayListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private final String TAG = "PlayListViewHolder";
        private final ViewDataBinding binding;
        private MediaFile mMediaFile;

        public PlayListViewHolder(ViewDataBinding binding){
            super(binding.getRoot());
            this.binding = binding;
            binding.getRoot().setOnClickListener(this);
        }

        public void bind(MediaFile mediaFile){
            mMediaFile = mediaFile;
            binding.setVariable(BR.mediaFile,mediaFile);
            binding.executePendingBindings();
        }

        @Override
        public void onClick(View view) {
            Log.i(TAG,mMediaFile.getSrc());
            mOnItemClickListener.onItemCLick(view,mMediaFile);
        }
    }


    private ArrayList<MediaFile> mList = Test.MusicList;
    private FileType mFileType = FileType.AUDIO;
    private OnItemClickListener mOnItemClickListener;

    public PlayListAdapter(OnItemClickListener listener) {
        mOnItemClickListener = listener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ViewDataBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.play_list_item,parent,false);
        if(null == binding){
            Log.e("xxxxxxxxxx","Binding is null");
        }
        return new PlayListViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MediaFile file = mList.get(position);
        ((PlayListViewHolder)holder).bind(file);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    public void switchToAudio(){
        if(FileType.AUDIO !=this.mFileType){
            this.mFileType = FileType.AUDIO;
            this.mList = Test.MusicList;
            notifyDataSetChanged();
        }
    }

    public void switchToVideo(){
        if(FileType.VIDEO != this.mFileType){
            this.mFileType = FileType.VIDEO;
            this.mList = Test.FilmList;
            notifyDataSetChanged();
        }
    }
}
