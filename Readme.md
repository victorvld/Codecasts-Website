# Codecasts-Website

This project is the continuation of the Clean Code Case Study episodes by Uncle Bob. Customizing and Taking further his development.

The aim of my project is to drive the original code into a solid design in which the projects will be able to evolve according the S.O.L.I.D principles and the clean Architecture. In particular, I seek to be able to achieve the next points:

- Improve the original design: Add Factories, Builders and Adapters. Follow the S.O.L.I.D components design, i.e, Controllers, Requestor, Responders, Interactors, Entities, Views, Database Gateways and Database implementations are split into maven modules aligned. This way all the depencies are under control and cross the boundaries in the appropiate direction.

- Move to the main module all the factory, startegy and builder implementations as well as the adapters. Making easy the Application configuration from a potential configuration file path passed as argument to the Main method of the application.

- Be able to add new use cases easily by following the design, i.e, creating new classes and derivatives, without modifiying the existing use cases.

- Plug in a real database.


### STORY 1

- Make it work.
- Implement a factory to create the use cases.
- Implement a builder to create the requests.

### STORY 2

- Separate in different Jars(Maven modules each Component final request and do not do any transformation inside. DONE.
  - Controllers by use case.
  - Requestors, i.e, Factories, Builders, Request Interface.
  - Interactors, i.e, Use Cases implementations, builder implementations, factories implementations, response implementation.
  - Responders, i.e, Response Interface, OutputBoundary Interface.
    - Create an interface for the CodecastSummaryResponseModel datastructure.
    - Create an interface for the CodecastDetailsResponseModel datastructure.
  - Views by use case.
  - Database Gateways
  - Database Implementations, i.e, Database Gateways implementations.
  - Entities
  - Router
  - SocketService
  - Utilities
  - Main
  - Application Context

- remove remaining circular dependencies.

### STORY 3

- Investigate how to get UCL diagrams from every module maven module and from the classes in a module. 
  - The best tools seems to be Diagrams, it is available in IntelliJ Ultimate version.

- Remove dependency Context in ControllerDetails module. DONE.


### STORY 4

- Investigate how to read/parse a HTTP request.

  - It was difficult to find a library to do this. What I found out is Servet Applications take care of this. Once you configure them by extending one of your classes, they will provide you an HTTPServletRequest object, from which you can extract cookies, headers, path and method. 
  - There are some well know Servlets frameworks such us Apache Tomcat, Netty and Jetty. 
  - For the time being, I am using my custom Socket. So I will create my own HTTP parser for this one.

### STORY 5

- Remove dependency on Router in Controller modules. DONE.
  - Send Request Instead of ParsedRequest.
  - Move Controller Interface to the Requester module.
- Clean Main, i.e, create a SocketService implementation for the current web service. DONE.
- Create Adapter to translate the incoming Request to our system domain, i.e, ParserRequest -> Request Interface. DONE.
- Create Parser Interface. DONE.
- Create Controller module. DONE.
  - remove router dependency from each controller use case.
- Remove builder param from each controller constructor. DONE.

### STORY 6 

- Recreate all the test cases

- Find a better solution to the TestSetup, RequestBuilderSpy and UseCaseFactorySpy.

- Define properly the strategy pattern for the parser, and the adapter pattern for the adapters.

### STORY 7

- Change HTMLs and create to simplify the website.
- Change the packages ids.

### STORY 8

- Upload project to a remote repository in my Github, and make it open source.
