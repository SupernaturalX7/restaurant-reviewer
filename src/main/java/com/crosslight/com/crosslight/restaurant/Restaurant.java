package com.crosslight.com.crosslight.restaurant;

import com.crosslight.com.crosslight.core.BaseEntity;
import com.crosslight.com.crosslight.review.Review;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Restaurant extends BaseEntity {

    private String title;
    private String url;
    @OneToMany(mappedBy = "foodGuide", cascade = CascadeType.ALL)
    private List<Review> reviews;

    protected Restaurant() {
        super();
        reviews = new ArrayList<>();
    }

    public Restaurant(String title, String url) {
        this();
        this.title = title;
        this.url = url;
    }

    public void addReview(Review review) {
        review.setRestaurant(this);
        reviews.add(review);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


}
