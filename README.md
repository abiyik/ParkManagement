# Park Management Application

This is an example Java application that uses Java 11, Spring Boot 2, Maven and Docker.


## Instructions

To compile (also runs unit tests)

```
mvn package
```

## To run the webapp manually

```
mvn spring-boot:run
```

and navigate your browser to  http://localhost:8080/

## To run integration tests

```
mvn spring-boot:run
mvn verify
```

## To create a docker image packaging an existing jar

```
Docker Build
$ docker build -t ahmetbiyik/parkingmanagement .
```

## To run the docker image

```
Docker Run
$ docker run -it -p 8080:8080 ahmetbiyik/parkingmanagement
```

## Access
```
Select parked vehicle list
http://localhost:8080/parkingManagement/status
Response: 
34-SO-1982 [4]
34-SO-1985 [9]
34-SO-1983 [5,6]
34-SO-1984 [7,8]
34-SO-1988 [0,1,2,3]

Park vehicle to parking
http://localhost:8080/parkingManagement/park
JSON Request : {"vehiclePlate": "34-SO-1988", "vehicleColour": "Black", "vehicleType":"Truck"}
Response: Allocated 4 slots.

Leave vehicle from parking with order number
http://localhost:8080/parkingManagement/leave
Response: Vehicle is left.

and leave vehicle from parking with vehicle JSON data. This is plus.
http://localhost:8080/parkingManagement/leaveVehicle
JSON Response: Vehicle is left.
```

##For Test JSON Data 
```
{"vehiclePlate": "34-SO-1988", "vehicleColour": "Black", "vehicleType":"Car"}
{"vehiclePlate": "34-BO-1987", "vehicleColour": "Red", "vehicleType":"Truck"}
{"vehiclePlate": "34-VO-2018", "vehicleColour": "Blue", "vehicleType":"Jeep"}
{"vehiclePlate": "34-HBO-2200", "vehicleColour": "Black", "vehicleType":"Truck"}
3  or {"vehiclePlate": "34-VO-2018", "vehicleColour": "Blue", "vehicleType":"Jeep"}
{"vehiclePlate": "34-LO-2000", "vehicleColour": "White", "vehicleType":"Car"}
```
