package company;

import java.util.ArrayList;

public class Swipe {
    private int userId;
    private int otherUserId;
    private String likeOrNot;

    public Swipe(int userId, int otherUserId, String likeOrNot) {
        this.userId = userId;
        this.otherUserId = otherUserId;
        this.likeOrNot = likeOrNot;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getOtherUserId() {
        return otherUserId;
    }

    public void setOtherUserId(int otherUserId) {
        this.otherUserId = otherUserId;
    }

    public String getLikeOrNot() {
        return likeOrNot;
    }

    public void setLikeOrNot(String likeOrNot) {
        this.likeOrNot = likeOrNot;
    }

    @Override
    public String toString() {
        return "Swipe{" +
                "userId=" + userId +
                ", otherUserId=" + otherUserId +
                ", likeOrNot='" + likeOrNot + '\'' +
                '}';
    }

}