# Codecasts-Web-App

This project is the continuation of the Clean Code Case Study episodes by Uncle Bob. Customizing and Taking further his development.

The aim of my project is to drive the original code into a solid design in which the projects will be able to evolve according the S.O.L.I.D principles and the clean Arquitecture. In particular, I seek to be able to achieve the next points:

- Improve the original design: Add Factories, Builders and Adapters. Follow the S.O.L.I.D components design, i.e, Controllers, Requestor, Responders, Interactors, Entities, Views, Database Gataweys and Database implementations are split into maven modules aligned. This way all the depencies are under control and cross the boundaries in the appropiate direction.

- Move to the main module all the factory, startegy and builder implementations as well as the adapters. Making easy the Application configuration from a potential configuration file path passed as argument to the Main method of the application.

- Be able to add new use cases easily by following the design, i.e, creating new classes and derivatives, without modifiying the existing use cases.

- Plug in a real database.
