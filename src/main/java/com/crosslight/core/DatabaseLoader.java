package com.crosslight.core;

import com.crosslight.restaurant.Restaurant;
import com.crosslight.restaurant.RestaurantRepository;
import com.crosslight.review.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Component
public class DatabaseLoader implements ApplicationRunner {
    private final RestaurantRepository restaurants;

    @Autowired
    public DatabaseLoader(RestaurantRepository restaurants) {
        this.restaurants = restaurants;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Restaurant restaurant = new Restaurant("McDonald's", "www.mcdonalds.com");
        restaurant.addReview(new Review(3, "This is a review"));
        restaurants.save(restaurant);
        String[] templates = {
                "Burger King %s",
                "Applebees %s",
                "Buffalo Wild Wings %s",
                "Logan's %s"
        };

        String[] reviewedItems = {
            "Whopper",
            "Sirloin Steak",
            "Mild Wing Basket",
            "Mozzarella Sticks",
            "Porterhouse Steak"
        };

        List<Restaurant> bunchOfRestaurants = new ArrayList<>();
        IntStream.range(0, 100).forEach(i -> {
            String template = templates[i % templates.length];
            String reviewedItem = reviewedItems[i % reviewedItems.length];
            String title = String.format(template, reviewedItem);
            Restaurant r = new Restaurant(title, "http://crosslight.com");
            r.addReview(new Review(i % 5, String.format("More %s please!", reviewedItem)));
            bunchOfRestaurants.add(r);
        });

        restaurants.saveAll(bunchOfRestaurants);
    }
}
