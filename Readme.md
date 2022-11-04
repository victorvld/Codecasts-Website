STORY 1

0) Make it work. DONE.
1) Implement a factory to create the use cases. DONE.
2) Implement a builder to create the requests. DONE.

STORY 2

4) Separate in different Jars(Maven modules each Component final request and do not do any transformation inside. DONE.
   1) Controllers by use case.
   2) Requestors, i.e, Factories, Builders, Request Interface.
   3) Interactors, i.e, Use Cases implementations, builder implementations, factories implementations, response implementation.
   4) Responders, i.e, Response Interface, OutputBoundary Interface.
      1) Create an interface for the CodecastSummaryResponseModel datastructure.
      2) Create an interface for the CodecastDetailsResponseModel datastructure.
   5) Views by use case.
   6) Database Gateways
   7) Database Implementations, i.e, Database Gateways implementations.
   8) Entities
   9) Router
   10) SocketService
   11) Utilities
   12) Main
   13) Application Context

5) remove remaining circular dependencies. DONE.

STORY 3

Investigate how to get UCL diagrams from every module maven module and from the classes in a module. 

The best tools seems to be Diagrams, it is available in IntelliJ Ultimate version.

6) Remove dependency Context in ControllerDetails module. DONE.


STORY 4

Investigate how to read/parse a HTTP request.

It was difficult to find a library to do this. 
What I found out is Servet Applications take care of this. Once you configure them by extending one of your classes,
they will provide you an HTTPServletRequest object, from which you can extract cookies, headers, path and method.

There are some well know Servlets frameworks such us Apache Tomcat, Netty and Jetty.

For the time being, I am using my custom Socket. So I will create my own HTTP parser for this one.

STORY 5

7) Remove dependency on Router in Controller modules. DONE.
    1) Send Request Instead of ParsedRequest.
    2) Move Controller Interface to the Requester module.
8) Clean Main, i.e, create a SocketService implementation for the current web service. DONE.
9) Create Adapter to translate the incoming Request to our system domain, i.e, ParserRequest -> Request Interface. DONE.
10) Create Parser Interface. DONE.
11) Create Controller module. DONE.
    1) remove router dependency from each controller use case.
12) Remove builder param from each controller constructor. DONE.

STORY 6 

13) Recreate all the test cases
14) Find a better solution to the TestSetup, RequestBuilderSpy and UseCaseFactorySpy.

STORY 7

15) Change HTMLs and create my own ones.

STORY 8

16) Upload project to a remote repository in my Github, and make it open source.
