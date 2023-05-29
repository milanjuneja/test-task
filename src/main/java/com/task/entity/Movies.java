package com.task.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class Movies {

    @Id
    private String tConst;

    private String titleType;

    private String primaryTitle;

    private int runTimeMinutes;

    private String genres;


    public Movies(){
        super();
    }
    public Movies(String tConst, String titleType, String primaryTitle, int runTimeMinutes, String genres) {
        this.tConst = tConst;
        this.titleType = titleType;
        this.primaryTitle = primaryTitle;
        this.runTimeMinutes = runTimeMinutes;
        this.genres = genres;
    }

    @Override
    public String toString() {
        return "Movies{" +
                "tConst='" + tConst + '\'' +
                ", titleType='" + titleType + '\'' +
                ", primaryTitle='" + primaryTitle + '\'' +
                ", runTimeMinutes=" + runTimeMinutes +
                ", genres='" + genres + '\'' +
                '}';
    }


    public Movies(String tConst, String primaryTitle, int runTimeMinutes, String genres) {
        this.tConst = tConst;
        this.primaryTitle = primaryTitle;
        this.runTimeMinutes = runTimeMinutes;
        this.genres = genres;
    }

    public String gettConst() {
        return tConst;
    }

    public void settConst(String tConst) {
        this.tConst = tConst;
    }

    public String getTitleType() {
        return titleType;
    }

    public void setTitleType(String titleType) {
        this.titleType = titleType;
    }

    public String getPrimaryTitle() {
        return primaryTitle;
    }

    public void setPrimaryTitle(String primaryTitle) {
        this.primaryTitle = primaryTitle;
    }

    public int getRunTimeMinutes() {
        return runTimeMinutes;
    }

    public void setRunTimeMinutes(int runTimeMinutes) {
        this.runTimeMinutes = runTimeMinutes;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }
}
