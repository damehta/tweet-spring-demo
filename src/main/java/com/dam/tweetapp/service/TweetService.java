package com.dam.tweetapp.service;

import com.dam.tweetapp.bean.Tweet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface TweetService {
    public Tweet postTweet(Tweet tweet);
    public Page<Tweet> getTweetPage(Pageable pageable);
}
