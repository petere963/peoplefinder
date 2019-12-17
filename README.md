# peoplefinder

An API to find people that live in a city, within a configurable radius. The application is implemented using the Dropwizard farmework. It works by calling a seperate applkication to return a set of people which is then filtered based on Lat/Long coordinates.

The application currently supports Leeds and London as searchable cities.

## Configuration
THwe following values are defined in a configuration file loaded at runtime

* Url of backend application
* Radius of search area

The supported cities are held in an Enum object _Locations.java_ within the application - this defines the supported places which are each defined with Lat/Long co-ordinates. In the current implementation these are limited to Leeds and London.

## Building and Executing

The application can be built using Maven with the following command

| mvn clean install

This create and executable jar file which can tghen be run as follows. The location of the configuration file needs to be supplied in the execution command - an example files is supplied in the code base at src/main/properties/local.yml - e.g.

| java -jar peoplefinder-1.0.0-SNAPSHOT server src/main/properties/local.yml
