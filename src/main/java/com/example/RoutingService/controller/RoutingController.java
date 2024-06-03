package com.example.RoutingService.controller;

import com.example.RoutingService.entity.Location;
import com.example.RoutingService.entity.RestuarantCustomerPair;
import com.example.RoutingService.service.RoutingService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/routingService/api")
public class RoutingController {
    private final RoutingService service;

    private RoutingController() {
        this.service = new RoutingService();
    }

    @GetMapping("/getPath")
    public List<Location> findOptimalPath() {
        Location source = new Location(0,0,"S");
        RestuarantCustomerPair[] pairs = new RestuarantCustomerPair[]{
                new RestuarantCustomerPair(new Location(3.0, 2.0, "R1"), new Location( 5.0, 3.0, "C1")),
                new RestuarantCustomerPair(new Location( 5.0, 1.0, "R2"), new Location(2.0, 2.1, "C2")),
        };
        return service.findOptimalPath(source, pairs);
    }
}
