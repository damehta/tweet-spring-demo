package com.dam.tweetapp.controller;

import com.dam.tweetapp.bean.Tweet;
import com.dam.tweetapp.service.TweetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.InternalServerErrorException;

@RestController
public class TweetController {

    @Autowired
    TweetService tweetService;

    @RequestMapping(value = "/tweet", method = RequestMethod.PUT, produces = "application/json")
    public ResponseEntity<Tweet> userTweet(@Valid @RequestBody Tweet tweet, BindingResult bindingResult)
            throws InternalServerErrorException, BadRequestException {
        if(bindingResult.hasErrors()){
            throw new BadRequestException("Author name or the message is/are missing in the request");
        }
        try{
            Tweet postTweet = tweetService.postTweet(tweet);
            return new ResponseEntity<Tweet>(postTweet, HttpStatus.CREATED);
        } catch(Exception ex) {
            throw new InternalServerErrorException(ex.getMessage());
        }
    }

    /*@RequestMapping(value = "/feed", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<ArrayList<Tweet>> userFeed(){

        return null;
    }*/

    @RequestMapping(value = "/feed/{pageNo}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Page<Tweet>> userTweetPage(@Valid @PathVariable("pageNo") @Value("${pageNo:0}") int pageNo) throws InternalServerErrorException{
        final int pageSize = 10;
        try {
            Page<Tweet> pg = tweetService.getTweetPage(PageRequest.of(pageNo, pageSize, Sort.by("publishDate").descending()));
            if(pg==null || pg.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }else{
                return new ResponseEntity<Page<Tweet>>(pg, HttpStatus.OK);
            }
        } catch (Exception e) {
            throw new InternalServerErrorException(e.getMessage());
        }
    }
}
