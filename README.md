# undercover-spring-auto-config

#####( auto configuration, conditional configuration, failure analysis )
This projet show how we can provide auto configuration to our api based on decision from class available on classpath,
beans created by the api user 

### This project is composed of 3 modules:

#### service

The example api that we provide to end users 

#### starter

The starter, that helps service users, bring dependencies and benefit from autoconguration support

This module contains some context unit testing

#### app

An example of user app using the service, providing some properties to configure the default bean proposed by autoconfiguration



