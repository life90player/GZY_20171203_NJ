package org.gzy.greendao.Bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by Administrator on 2018/1/6 0006.
 */

@Entity
public class VideoFile
{
    @Id(autoincrement = true)
    private long id;
    @Property(nameInDb = "VideoName")
    private String videoname;
    @Property(nameInDb = "VideoPath")
    private String videopath;
    public String getVideopath() {
        return this.videopath;
    }
    public void setVideopath(String videopath) {
        this.videopath = videopath;
    }
    public String getVideoname() {
        return this.videoname;
    }
    public void setVideoname(String videoname) {
        this.videoname = videoname;
    }
    public long getId() {
        return this.id;
    }
    public void setId(long id) {
        this.id = id;
    }
    @Generated(hash = 17029515)
    public VideoFile(long id, String videoname, String videopath) {
        this.id = id;
        this.videoname = videoname;
        this.videopath = videopath;
    }
    @Generated(hash = 106420510)
    public VideoFile() {
    }
}
