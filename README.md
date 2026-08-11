# Programming Workshop 2026

This repository contains the work developed for the Programming Workshop 2026. The project is focused on applying Java programming, object-oriented programming principles, software development tools, version control, and AI-assisted programming.

As part of the workshop, a public GitHub repository was created to organize and document the development process. Visual Studio Code is used as the main development environment, together with Java development extensions such as Extension Pack for Java, Gradle for Java, GitLens, and GitHub Copilot.

The project follows the standard Maven directory structure. The main source code is organized under `src/main/java/com/umb/taller`, which is divided into the `domain`, `application`, and `infrastructure` packages. Tests are located under `src/test/java`. The project also includes a `pom.xml` file for Maven configuration and a `build.gradle` file as the base Gradle configuration.

Git and GitHub are used to manage the project's version history. Conventional Commits are being applied to keep commit messages clear and organized. The initial project structure was committed using the message `feat: initial project structure with Maven layout`, followed by a build configuration commit.

During the object-oriented programming section, GitHub Copilot is being used as a programming assistant to generate domain classes. The generated code is not accepted without review. Each suggestion is evaluated critically, and changes are made when necessary to improve the design, readability, validation, and organization of the code.

The domain model includes classes such as `Usuario`, `Residuo`, `ResiduoReciclable`, and `PuntoReciclaje`. These classes are designed to demonstrate four important object-oriented programming principles: encapsulation, abstraction, inheritance, and polymorphism.

The main objective of this repository is to document the practical application of the concepts presented in the workshop while maintaining a clear development history and evaluating the advantages and limitations of AI-assisted programming.
