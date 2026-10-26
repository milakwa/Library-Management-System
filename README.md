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

## Member
