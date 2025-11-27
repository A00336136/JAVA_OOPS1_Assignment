# JAVA_OOPS1_Assignment
Java OOPS1 Assignment Msc in Software Design with Cloud Native Computing
# Restaurant Ordering System – Java OOP (Java 21/22)

## Overview

This project is my coursework assignment for an Object-Oriented Programming module.  
It demonstrates Java OOP fundamentals and modern Java 21+ features using a simple **Restaurant Ordering System**.

The application models:
- Menu items (starters, mains, desserts, drinks)
- Orders and order items
- Payments (cash, card, digital wallet)
- Staff roles (manager, chef, waiter)
- Billing and basic discount logic

---

## Features

### Functional

- View the restaurant menu
- Create an order with multiple menu items
- Calculate order totals
- Process different payment types
- Model staff roles using a sealed interface hierarchy

### Technical / Java Features

**Fundamentals:**
- Classes and objects (`Order`, `OrderItem`, `Menu`, `Money`)
- Constructors and `this(...)` constructor chaining
- Method overloading (`Order.withSingleItem`)
- Varargs (`Menu.addItems(MenuItem... items)`)
- Encapsulation and defensive copying
- Interfaces (`Billing`)
- Inheritance and polymorphism (sealed `Role` and its implementations)
- Enums (`MenuItem.Category`, `Order.Status`)
- Checked and unchecked exceptions
- Use of Java core APIs: `String`, `StringBuilder`, `List`, `ArrayList`, `LocalDateTime`

**Advanced:**
- Records (`MenuItem`, `Payment.Cash`, `Payment.Card`, `Payment.DigitalWallet`)
- Custom immutable type (`Money`)
- Lambdas and `Predicate`
- Method references (`System.out::println`)
- Switch expressions with pattern matching (`PaymentProcessor`)
- Sealed interfaces (`Role`, `Payment`)
- Local variable type inference (`var`)
- Discussion of `final` and effectively final in lambda capture

**Java 22 (Extras):**
- Unnamed variables and patterns (optional extra example)
- Explanation of how to compile and run with JDK 22

---

## Project Structure

```text
src/
  restaurant/
    Main.java
    model/
      MenuItem.java
      Menu.java
      Order.java
      OrderItem.java
      Money.java
      Role.java
      StaffManager.java
      Chef.java
      Waiter.java
      Payment.java
      PaymentProcessor.java
      exceptions/
        OrderNotFoundException.java
        InvalidOrderStateException.java
    services/
      Billing.java
      DiscountService.java
    util/
      UUIDGenerator.java
