package org.gzy.greendao.Bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by Administrator on 2018/1/6 0006.
 */
@Entity
public class MusicFile
{
    @Id(autoincrement = true)
    private long id;
    @Property(nameInDb = "MusicName")
    private String musicname;
    @Property(nameInDb = "MusicPath")
    private String musicpath;
    public String getMusicpath() {
        return this.musicpath;
    }
    public void setMusicpath(String musicpath) {
        this.musicpath = musicpath;
    }
    public String getMusicname() {
        return this.musicname;
    }
    public void setMusicname(String musicname) {
        this.musicname = musicname;
    }
    public long getId() {
        return this.id;
    }
    public void setId(long id) {
        this.id = id;
    }
    @Generated(hash = 1871643474)
    public MusicFile(long id, String musicname, String musicpath) {
        this.id = id;
        this.musicname = musicname;
        this.musicpath = musicpath;
    }
    @Generated(hash = 1290180758)
    public MusicFile() {
    }
}
