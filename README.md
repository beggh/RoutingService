# Route Optimizer Service
This repository explains how to optimize route of deliveryPerson beginning from source and delivering from Restuarants to Customers

# Assumptions
- 2 customers, 2 restuarants and 1 delivery person which can be extended to N customers, restaurants
- A predefined source as starting point for delivery person
- A restuarant is mapped to a specific customer only
- Deliveryperson, Restuarant1 and Restuarant2 were informed about these orders at
the exact same time and all of them confirm on doing it immediately. Also, for travel time between 
any two geo-locations, you can use the haversine formula with an average speed of 20km/hr ( 
basically ignore actual road distance or confirmation delays everywhere)

# Installation and Prerequisites
- Built on Java 8+ and Springboot framework with Maven project

# How to test
- git clone repository ```https://github.com/beggh/RoutingService.git``` and make sure atleast java version 8 is installed
- Exposes an endpoint which prints path in sequence of visited
  - ```curl --location 'localhost:8080/routingService/api/getPath'```

# Improvements
- Customers and Restuarants can be added by using post api and storing pair in the set in the repository layer or make use database storage and create 2 tables and use foreign key (customerId) in restuarant table to store 1:1 relationship between customer and restuarant
