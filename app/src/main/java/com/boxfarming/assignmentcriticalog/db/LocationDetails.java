package com.boxfarming.assignmentcriticalog.db;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = Constant.TABLE_NAME)
public class LocationDetails {

    @NonNull
    @PrimaryKey(autoGenerate = true)
    private int serial_no;

    @ColumnInfo(name = Constant.LONGITUDE)
    private String longitude;

    @ColumnInfo(name = Constant.LATITUDE)
    private String latitude;

    public LocationDetails(String longitude, String latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public int getSerial_no() {
        return serial_no;
    }

    public void setSerial_no(int serial_no) {
        this.serial_no = serial_no;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }
}
