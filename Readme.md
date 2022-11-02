// TODO:

0) Make it work.
1) Implement a factory to create the use cases.
2) Implement a builder to create the requests.
3) Separate in different Jars(Maven modules each Component
   1) Controllers
   2) Requestors, i.e, Factories, Builders, Request Interface.
   3) Interactors, i.e, Use Cases implementations, builder implementations, factories implementations, response implementation.
   4) Responders, i.e, Response Interface, OutputBoundary Interface.
   5) Database Gateways
   6) Database Implementations, i.e, Database Gateways
   7) Entities
   EP:14 - Open Close Principle - T=17:30 

Here is explained how to use factories, builders and interfaces
to decoupled the controller from the use cases and requests.

When the controller has detected that it suppose to create an 
hourly employee. Then it creates the 
request data-structure, it gets the hourly employee use-case,
and then it passes that data-structure into the use case. Calling the execute method.

Image 1

That controller depends on the details of 
the data-structure and the details of the use case.

If I attempt to extend that data-structure or that use-case,
I will have to recompile and redeploy the controller.

We can fix this by decoupling the data-structures and the use-cases from the controller.
By using builders, factories and interfaces.

Image 2

For example, we can create the Builder interface.
And in this interface we can put methods that build each
individual data-structure. 

The implementation of that interface will actually do the building.
And it will return those data-structures under the degenerate type request.

The use-case factory interface has methods in it to create every possible use case. 
The implementation of that interface would create those use-cases,
but it would return them as the interface use-case.
The use-case interface and the request data-type, a degenerate data-type,
will be both use by the controller that execute the use case. 

This way we have decoupled the request and use cases from the controller.
As long as the changes don't change the signature of the methods at the request builder. 
The controller will remain unaffected.

The same for the use cases, 
we can do changes on the uses cases and those changes won't affect to the controller
as long as we don't change the signature of the methods on the use case factory.
The controller will remain unaffected. 

There is only one RequestBuilder and only one UseCaseFactory in the system.

But what about adding a new use case. This will make use to change, the RequestBuilder and the UseCaseFactory interface.
Because we will have to add a new method to ech one.

This is a violation of the ISP.

We can solve this problem by using a dynamic language like ruby or 
By using a dynamic interface for the request builder and the use case factory.
(by breaking type safety in static languages).

Image 3

For the request builder, the string will contain the identity of the 
data structure to build. And the hashmap will contain all the construction arguments.

This means we lose type safety. We can fix the type safety by adding a basilian interfaces.

Image 4

Another important point, is not to make the base class Employee depend on
particular things from its derivative. To avoid that we have to downcast again to the derivative,
this is not a problem since we know which derivative to cast.

Imagine 5

The wrong approach will be this:

Image 6, 7 and 8
