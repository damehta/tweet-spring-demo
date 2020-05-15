package com.dam.tweetapp.service;

import com.dam.tweetapp.bean.Tweet;
import com.dam.tweetapp.repository.TweetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Service
public class TweetServiceImpl implements TweetService {

    @Autowired
    TweetRepository tweetRepository;

    @Override
    public Tweet postTweet(Tweet tweet) {
        tweet.setId(UUID.randomUUID());
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        tweet.setPublishDate(myFormatObj.format(localDateTime));
        return tweetRepository.save(tweet);
    }

    @Override
    public Page<Tweet> getTweetPage(Pageable pageable) {
        return tweetRepository.findAll(pageable);
    }
}
