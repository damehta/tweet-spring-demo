package com.dam.tweetapp.bean;


import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;
import java.util.UUID;

public class Tweet {
    @Id
    public UUID id;
    @NotNull
    private String userId;
    private String message;
    private String publishDate;

    public Tweet(UUID id, @NotNull String userId, String message, String publishDate) {
        this.id = id;
        this.userId = userId;
        this.message = message;
        this.publishDate = publishDate;
    }

    @Override
    public String toString() {
        return "Tweet{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", message='" + message + '\'' +
                ", publishDate='" + publishDate + '\'' +
                '}';
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }
}
