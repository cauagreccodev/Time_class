# Time Class

A practical exercise in Java implementing a class to manipulate and display time values with object-oriented design principles.

## Concepts Used

This project demonstrates several key Java concepts:

- **Encapsulation**: Private attributes (hour, minute, second) with public getter/setter methods for controlled access
- **Constructor Overloading**: Multiple constructors with different parameters and a copy constructor
- **Input Validation**: Custom validation methods that throw `IllegalArgumentException` for invalid values
- **Object Comparison**: Implementation of `Comparable<Time>` interface to enable sorting
- **equals() Method**: Overriding equals() for proper object equality comparison
- **toString() Method**: String representation of Time objects for easy printing
- **Array Sorting**: Using `Arrays.sort()` to order Time objects based on comparison logic
- **Time Manipulation**: Methods like `advance()` and `goBack()` to modify time values

## How to Run

1. Compile the Java files:
   ```bash
   javac src/Time.java src/Main.java
   ```

2. Run the program:
   ```bash
   java -cp src Main
   ```

The program creates multiple Time instances, demonstrates sorting, comparison, and time manipulation operations.
