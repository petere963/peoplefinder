# peoplefinder

An API to find people that live in a city, within a configurable radius. The application is implemented using the Dropwizard farmework. It works by calling a seperate application to return a set of people which is then filtered based on Lat/Long coordinates.

The application currently supports Leeds and London as searchable cities.

## Configuration
THwe following values are defined in a configuration file loaded at runtime

* Url of backend application
* Radius of search area

The supported cities are held in an Enum object _Locations.java_ within the application - this defines the supported places which are each defined with Lat/Long co-ordinates. In the current implementation these are limited to Leeds and London.

## Building and Executing

The application can be built using Maven with the following command

> mvn clean install

This create and executable jar file which can then be run as follows. The location of the configuration file needs to be supplied in the execution command - an example file is supplied in the code base at src/main/properties/local.yml - e.g.

> java -jar peoplefinder-1.0.0-SNAPSHOT server src/main/properties/local.yml

## Determination of radius

The centre of each supported place (currently Leeds and London) is defined within the application (see enum _Locations.java_). Each person returned by the backend application has their own Lat/Long co-ordinates. These are used to determine the distance from the relevant place - and if it is within the defined radius, then the persion is included in the selected set. See class _DistanceCalulator_ for more information.

## API
The application is accessed by a get to the following URLs. Note that the current implementation only supports http requests

### All people within 50 miles of Leeds

http://localhost:8090/people/leeds

### All people within 50 miles of London

http://localhost:8090/people/london
