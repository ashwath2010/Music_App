package com.symphony.music.model.smartplaylist;

import android.content.Context;
import android.os.Parcel;

import androidx.annotation.NonNull;

import com.symphony.music.R;
import com.symphony.music.loader.TopAndRecentlyPlayedSongsLoader;
import com.symphony.music.model.Song;
import com.symphony.music.provider.SongPlayCountStore;

import java.util.List;

public class MyTopSongsPlaylist extends AbsSmartPlaylist {

    public MyTopSongsPlaylist(@NonNull Context context) {
        super(context.getString(R.string.my_top_songs), R.drawable.ic_trending_up_white_24dp);
    }

    @NonNull
    @Override
    public List<Song> getSongs(@NonNull Context context) {
        return TopAndRecentlyPlayedSongsLoader.getTopSongs(context);
    }

    @Override
    public void clear(@NonNull Context context) {
        SongPlayCountStore.getInstance(context).clear();
    }


    @Override
    public int describeContents() {
        return 0;
    }

    protected MyTopSongsPlaylist(Parcel in) {
        super(in);
    }

    public static final Creator<MyTopSongsPlaylist> CREATOR = new Creator<MyTopSongsPlaylist>() {
        public MyTopSongsPlaylist createFromParcel(Parcel source) {
            return new MyTopSongsPlaylist(source);
        }

        public MyTopSongsPlaylist[] newArray(int size) {
            return new MyTopSongsPlaylist[size];
        }
    };
}
