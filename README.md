# Library Management System

## Overview
A simple Library Management System developed using Java as an Object-Oriented Programming (OOP) project. The system organizes books and library members and provides basic library operations.

## Features
- Manage different types of books.
- Support different types of library members.
- Borrow and return books.
- Check book availability.
- Authenticate members using their login information.
- Prevent members from borrowing more books than their allowed limit.
- Support different borrowing durations depending on the book type.

## Object-Oriented Programming Concepts
The project applies the following OOP concepts:
- **Abstraction:** The `Book` class defines common properties and abstract methods for different book types.
- **Inheritance:** `PhysicalBook`, `EBook`, and `ReferenceBook` extend the `Book` class. Member types also extend `LibraryMember`.
- **Encapsulation:** Classes organize data and operations within their own structure.
- **Polymorphism:** Different book types implement their own borrowing duration behavior.

## Book Types
- **PhysicalBook:** Borrowing duration of 14 days.
- **EBook:** Borrowing duration of 21 days.
- **ReferenceBook:** Cannot be borrowed.

## Member Types
- **StudentMember:** Maximum of 3 borrowed books.
- **TeacherMember:** Maximum of 5 borrowed books.
- **GuestMember:** Maximum of 1 borrowed book.

## Technologies
- Java
- NetBeans IDE
- Git and GitHub

## Project Structure
```text
Library-Management-System/
├── src/
│   └── library/
│       └── system/
│           ├── Book.java
│           ├── EBook.java
│           ├── PhysicalBook.java
│           ├── ReferenceBook.java
│           ├── LibraryMember.java
│           ├── StudentMember.java
│           ├── TeacherMember.java
│           ├── GuestMember.java
│           ├── Library.java
│           └── LibrarySystem.java
├── nbproject/
├── build.xml
├── manifest.mf
└── README.md
```

## How to Run
1. Clone or download the repository.
2. Open NetBeans IDE.
3. Open the project in NetBeans.
4. Run the `LibrarySystem` class if it contains the application's main method.

## Author
Developed as a Java Object-Oriented Programming project.
