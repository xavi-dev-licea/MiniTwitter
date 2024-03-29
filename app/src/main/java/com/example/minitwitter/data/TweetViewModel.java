package com.example.minitwitter.data;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.minitwitter.retrofit.response.Tweet;
import com.example.minitwitter.ui.tweets.BottomModalFragment;

import java.util.List;

public class TweetViewModel extends AndroidViewModel {

    private TweetRepository tweetRepository;
    private LiveData<List<Tweet>> tweets;
    private LiveData<List<Tweet>> favTweets;

    public TweetViewModel(@NonNull Application application) {
        super(application);

        tweetRepository = new TweetRepository();
        tweets = tweetRepository.getAllTweets();
    }

    public LiveData<List<Tweet>> getTweets(){
        return tweets;
    }

    public LiveData<List<Tweet>> getFavTweets(){
        favTweets = tweetRepository.getFavsTweets();
        return  favTweets;
    }

    public LiveData<List<Tweet>> getNewTweets(){
        tweets = tweetRepository.getAllTweets();
        return tweets;
    }

    public LiveData<List<Tweet>> getNewFavTweets(){
        getNewTweets();
        return getFavTweets();
    }

    public void newTweet(String mensaje){
        tweetRepository.createTweet(mensaje);
    }

    public void likeTweet(int idTweet){
        tweetRepository.likeTweet(idTweet);
    }

    public void deleteTweet(int idTweet){
        tweetRepository.deleteTweet(idTweet);
    }

    public void openDialogMenu(Context context, int idTweet){
        BottomModalFragment dialog = BottomModalFragment.newInstance(idTweet);
        dialog.show(((AppCompatActivity)context).getSupportFragmentManager(), "BottomModalFragment");
    }
}
