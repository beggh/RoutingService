package com.example.RoutingService.service;


import com.example.RoutingService.entity.Location;
import com.example.RoutingService.entity.RestuarantCustomerPair;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoutingService {
    public List<Location> findOptimalPath(Location source, RestuarantCustomerPair[] pairs) {
        List<Location> path = new ArrayList<>();
        path.add(source);
        Location currLocation = source;
        final double time = 20; // assuming same informing time of 20 mins
        while (path.size() < pairs.length * 2 + 1) {
            double minTime = Double.MAX_VALUE;
            Location currRestaurant = null;
            Location currCustomer = null;

            for (int i = 0; i < pairs.length; i++) {
                if (!path.contains(pairs[i].getRestaurant())) {
                    double travelTimeToRestaurant = calculateHaversineDistance(currLocation, pairs[i].getRestaurant())/ 20.0 * 60.0;
                    double totalTime = travelTimeToRestaurant + time;
                    if (totalTime < minTime) {
                        minTime = totalTime;
                        currRestaurant = pairs[i].getRestaurant();
                        currCustomer = pairs[i].getCustomer();
                    }
                }
            }
            // find min distance restuarant and set it to currLocation
            if (currRestaurant != null) {
                path.add(currRestaurant);
                path.add(currCustomer);
                currLocation = currCustomer;
            }
        }
        return path;
    }

    private double calculateHaversineDistance(Location loc1, Location loc2) {
        final double radius = 6371;
        double lat1 = Math.toRadians(loc1.getX());
        double lon1 = Math.toRadians(loc1.getY());
        double lat2 = Math.toRadians(loc2.getX());
        double lon2 = Math.toRadians(loc2.getY());

        double deltaLat = lat2 - lat1;
        double deltaLon = lon2 - lon1;

        double a = Math.sin(deltaLat / 2) * Math.sin(deltaLat / 2) +
                Math.cos(lat1) * Math.cos(lat2) * Math.sin(deltaLon / 2) * Math.sin(deltaLon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return radius * c;
    }
}
