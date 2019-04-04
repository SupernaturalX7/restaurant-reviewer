package com.crosslight.review;

import com.crosslight.core.BaseEntity;
import com.crosslight.restaurant.Restaurant;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
@Entity
public class Review extends BaseEntity {

    private int rating;
    private String description;
    @ManyToOne
    private Restaurant restaurant;

    protected Review() {
        super();
    }

    public Review(int rating, String description) {
        this.rating = rating;
        this.description = description;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
