# Java SDET Capstone Framework

## Program Goal

Learn Java and SDET automation tools.

## Local Setup Notes

Installed:

- JDK 21
- Git
- IntelliJ IDEA Community
- GitHub account

## Learning Log

### 
- Installed Java 21
- Installed IntelliJ IDEA
- Created GitHub repository
- Cloned repository locally
- Learned basic Git commands
- Practiced debugging in IntelliJ IDEA

## Useful Commands Git

- mkdir folder-name — create a new folder
- pwd — show current folder
- ls — show files in folder
- cd — move to another folder
- git clone — download repository
- git status — check repository status
- git add . — add all changes for commit
- git commit -m "message" — save changes in Git
- git push -u origin main — send changes to GitHub
- git checkout -b branch-name — create and switch to a new branch
## Java Exercises

Current exercises are located in:

src/main/java/basics

Completed exercises:

- HelloWorldExercise
- VariablesExercise
- SimpleCalculationExercise
- MathOperatorsExercise
- ConditionExercise
- StringMethodsExercise
- ScannerExercise
- LoopExercise
- ArraysExercise
- DebuggingExercise

Practiced:

- Variables and data types
- Arithmetic and logical operators
- Conditional statements (if, else)
- Loops (for, while)
- Array indexing
- Sum calculation
- Minimum and maximum value search

Implemented methods:

- square(); sum(); multiply(); isEven(); sumArray();
findMaxMin(); contains(); findIndex(); countOccurrences();
areArraysEqual()

Run from IntelliJ IDEA:
- Open a Java class
- Run the class using the green ▶ button

Task 2 – OOP and Collections

Completed:

- Created domain model classes:
User
Room
Booking
BookingStatus (enum)
- Implemented constructors for domain models.
- Learned object relationships (Booking contains User and Room objects).
- Implemented the Validatable interface and booking validation.
- Created BookingService for managing bookings.
- Introduced Java collections:
List
ArrayList
- Implemented booking storage using a List.
- Added and managed multiple Booking objects through BookingService.
- Practiced object creation, method parameters, and object interaction.
- Explored object output and toString() usage.

Run from terminal:

```bash
javac src/main/java/basics/HelloWorldExercise.java
java -cp src/main/java basics.HelloWorldExercise

