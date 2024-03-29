package com.example.minitwitter.retrofit.response;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Tweet {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("mensaje")
    @Expose
    private String mensaje;
    @SerializedName("likes")
    @Expose
    private List<Like> likes = null;
    @SerializedName("user")
    @Expose
    private User user;

    /**
     * No args constructor for use in serialization
     *
     */
    public Tweet() {
    }

    public Tweet(Tweet tweet) {
        this.id = tweet.getId();
        this.mensaje = tweet.getMensaje();
        this.user = tweet.getUser();
        this.likes = tweet.getLikes();
    }

    /**
     *
     * @param id
     * @param mensaje
     * @param user
     * @param likes
     */
    public Tweet(Integer id, String mensaje, List<Like> likes, User user) {
        super();
        this.id = id;
        this.mensaje = mensaje;
        this.likes = likes;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public List<Like> getLikes() {
        return likes;
    }

    public void setLikes(List<Like> likes) {
        this.likes = likes;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}