package com.company;

import java.util.Objects;

public class TV {

    private String tvChannel;
    private String tvProgram;

    public TV(String tvChannel, String tvProgram) {
        this.tvChannel = tvChannel;
        this.tvProgram = tvProgram;
    }

    public String getTvChannel() {
        return tvChannel;
    }

    public void setTvChannel(String tvChannel) {
        this.tvChannel = tvChannel;
    }

    public String getTvProgram() {
        return tvProgram;
    }

    public void setTvProgram(String tvProgram) {
        this.tvProgram = tvProgram;
    }

    @Override
    public String toString() {
        return "TV{" +
                "tvChannel='" + tvChannel + '\'' +
                ", tvProgram='" + tvProgram + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TV tv = (TV) o;
        return Objects.equals(tvChannel, tv.tvChannel) &&
                Objects.equals(tvProgram, tv.tvProgram);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tvChannel, tvProgram);
    }
}
