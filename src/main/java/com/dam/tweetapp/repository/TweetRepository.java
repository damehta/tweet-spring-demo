package com.dam.tweetapp.repository;

import com.dam.tweetapp.bean.Tweet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.UUID;

@Repository
public interface TweetRepository extends MongoRepository<Tweet, UUID> {

    public ArrayList<Tweet> findByUserId(String userId);

    ArrayList<Tweet> findAll();
//    ArrayList<Tweet> findFirst100ByAuthorNameInOrderByPublishDateDesc(ArrayList<String> followers);

    Page<Tweet> findAll(Pageable pageable);
}
