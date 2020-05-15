package com.dam.tweetapp.bean;

import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Follower {
    @Id
    public UUID id;
    @NotNull
    private String userId;
    private List<String> followers = new ArrayList<>();



    public Follower(UUID id, @NotNull String userId, List<String> followers) {
        this.id = id;
        this.userId = userId;
        this.followers = followers;
    }

    @Override
    public String toString() {
        return "Follower{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", followers=" + followers +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Follower follower = (Follower) o;
        return Objects.equals(id, follower.id) &&
                Objects.equals(userId, follower.userId) &&
                Objects.equals(followers, follower.followers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, followers);
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<String> getFollowers() {
        return followers;
    }

    public void setFollowers(List<String> followers) {
        this.followers = followers;
    }
}
