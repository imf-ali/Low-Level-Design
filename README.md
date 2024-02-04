# Machine Coding / Low Level design of following problems: 
## Cab Booking System
### Details:
* The location is represented as a (x, y) coordinate.
* Distance between two points (x1, y1) and(x2, y2) is sqrt((x1-x2)^2 + (y1-y2)^2)
* Platform has decided upon maximum distance a driver has to travel to pickup a rider.
* A cab has only 1 driver.
* Sharing of cab is not allowed between riders
* There is a single type of cab

Please build an application that exposes following features to riders and drivers.
* Register a rider.
* Register a driver/cab
* Update a cab's location
* A driver can switch on/off his availability
* A rider can book a cab
* Fetch history of all rides taken by a rider.
* End the Trip
## Car Parking System

## Publisher Subscriber System (Messaging Queue)
We have to design a message queue supporting publisher-subscriber model. It should support following operations:

* It should support multiple topics where messages can be published.
* Publisher should be able to publish a message to a particular topic.
* Subscribers should be able to subscribe to a topic.
* Whenever a message is published to a topic, all the subscribers, who are subscribed to that topic, should receive the message.
* Subscribers should be able to run in parallel

## Url Shortener
