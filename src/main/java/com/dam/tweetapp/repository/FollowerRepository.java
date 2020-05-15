package com.dam.tweetapp.repository;

import com.dam.tweetapp.bean.Follower;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.UUID;

@Repository
public interface FollowerRepository extends MongoRepository<Follower, UUID> {
    public ArrayList<Follower> findByUserId(String userId);
}
