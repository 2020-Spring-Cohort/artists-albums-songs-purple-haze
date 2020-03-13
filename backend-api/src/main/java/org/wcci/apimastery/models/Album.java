package org.wcci.apimastery.models;

public class Album {
    private String albumTitle;
    private String recordLabel;

    public Album(String albumTitle) {
        this.albumTitle = albumTitle;
    }

    public String getAlbumTitle() {
        return albumTitle;
    }

    public String getRecordLabel() {
        return recordLabel;
    }
}

