# Learn Java 📚

A comprehensive Java learning repository covering core concepts, advanced topics, and practical implementations.

## 📖 Table of Contents

- [Asynchronous Programming](#asynchronous-programming)
- [Object-Oriented Programming (OOP)](#object-oriented-programming-oop)
- [Generics](#generics)
- [Stream API](#stream-api)
- [HashMap](#hashmap)
- [Data Sources](#data-sources)

---

## Asynchronous Programming

Learn how to implement concurrent and asynchronous operations in Java using threads and executors.

### Files:
- **[ExecuteUsingRunnable.java](src/com/uk/asynchronous/ExecuteUsingRunnable.java)** - Execute tasks using Runnable interface
- **[ExecuteUsingCallable.java](src/com/uk/asynchronous/ExecuteUsingCallable.java)** - Execute tasks using Callable interface with return values
- **[TaskOneUsingRunnable.java](src/com/uk/asynchronous/TaskOneUsingRunnable.java)** - Runnable task implementation example
- **[TaskOneUsingCallable.java](src/com/uk/asynchronous/TaskOneUsingCallable.java)** - Callable task implementation example

**Topics Covered:**
- Thread execution with Runnable
- Callable and Future pattern
- ExecutorService usage
- Concurrent task management

---

## Object-Oriented Programming (OOP)

Master fundamental OOP principles with practical examples.

### Files:
- **[Application.java](src/com/uk/oop/Application.java)** - Main application showcasing OOP concepts
- **[BankAccount.java](src/com/uk/oop/BankAccount.java)** - Encapsulation and data protection example
- **[Payment.java](src/com/uk/oop/Payment.java)** - Polymorphism and interface implementation

**Topics Covered:**
- Encapsulation and data hiding
- Inheritance and method overriding
- Polymorphism
- Abstraction
- Access modifiers

---

## Generics

Understand type-safe collections and generic programming in Java.

### Core Classes:
- **[App.java](src/com/uk/generic/App.java)** - Main generic programming examples
- **[Aquarium.java](src/com/uk/generic/Aquarium.java)** - Generic container implementation
- **[Arowana.java](src/com/uk/generic/Arowana.java)** - Fish type example
- **[Flowerhorn.java](src/com/uk/generic/Flowerhorn.java)** - Fish type example
- **[Goldfish.java](src/com/uk/generic/Goldfish.java)** - Fish type example
- **[Koi.java](src/com/uk/generic/Koi.java)** - Fish type example

### Advanced Topics:
- **[Covariance](src/com/uk/generic/covariance/)** - Covariance in generics
- **[Upper Bound](src/com/uk/generic/upperbound/)** - Bounded type parameters

**Topics Covered:**
- Generic classes and methods
- Type parameters
- Bounded wildcards
- Covariance and contravariance
- Type erasure

---

## Stream API

Work with functional programming and stream processing.

### Core Stream Operations:
- **[Stream](src/com/uk/streamapi/stream/)** - Basic stream operations (map, filter, collect)

### Advanced Topics:
- **[IntStream](src/com/uk/streamapi/intstream/)** - Primitive stream operations
- **[Parallel Streams](src/com/uk/streamapi/parallelstreams/)** - Concurrent stream processing
- **[Method References](src/com/uk/streamapi/methodreference/)** - Method reference syntax and usage
- **[Questions](src/com/uk/streamapi/questions/)** - Practice problems and solutions

**Topics Covered:**
- Stream creation and terminal operations
- Intermediate operations (map, filter, flatMap)
- Collectors and reduction
- Parallel stream processing
- Method references (::)
- Performance optimization

---

## HashMap

Deep dive into HashMap implementation and usage.

### Files:
- **[DebugHashMap.java](src/com/uk/hashmap/DebugHashMap.java)** - Internal workings and debugging HashMap

**Topics Covered:**
- HashMap structure and hash functions
- Collision handling
- Load factor and resizing
- Performance characteristics
- Internal implementation details

---

## Data Sources

Sample data classes used across projects for demonstrations.

### Classes:
- **[Animal.java](src/com/uk/datasource/Animal.java)** - Base animal class
- **[Creature.java](src/com/uk/datasource/Creature.java)** - Creature interface/class
- **[Dog.java](src/com/uk/datasource/Dog.java)** - Dog implementation
- **[Cat.java](src/com/uk/datasource/Cat.java)** - Cat implementation
- **[Husky.java](src/com/uk/datasource/Husky.java)** - Husky breed implementation
- **[GingerCat.java](src/com/uk/datasource/GingerCat.java)** - Ginger cat implementation
- **[Employee.java](src/com/uk/datasource/Employee.java)** - Employee data class
- **[Student.java](src/com/uk/datasource/Student.java)** - Student data class

---

## Getting Started

1. **Clone the repository:**
   ```bash
   git clone https://github.com/utkarsh-kesarwaNi/Learn-java.git
   cd Learn-java
   ```

2. **Compile and run examples:**
   ```bash
   javac src/com/uk/oop/Application.java
   java com.uk.oop.Application
   ```

3. **Explore each topic:**
   - Start with OOP for foundational concepts
   - Move to Generics for type-safe programming
   - Explore Stream API for functional programming
   - Understand concurrency with Asynchronous Programming

---

## Project Structure

```
Learn-java/
├── src/com/uk/
│   ├── oop/                    # Object-Oriented Programming
│   ├── generic/                # Generics and Type Parameters
│   │   ├── covariance/        # Covariance examples
│   │   └── upperbound/        # Bounded type parameters
│   ├── streamapi/              # Stream API
│   │   ├── stream/            # Basic stream operations
│   │   ├── intstream/         # Primitive streams
│   │   ├── parallelstreams/   # Parallel processing
│   │   ├── methodreference/   # Method references
│   │   └── questions/         # Practice problems
│   ├── asynchronous/           # Concurrent Programming
│   ├── hashmap/                # HashMap internals
│   └── datasource/             # Sample data classes
└── README.md
```

---

## Topics Covered

✅ Object-Oriented Programming  
✅ Generics and Type Safety  
✅ Stream API and Functional Programming  
✅ Asynchronous Programming and Threads  
✅ HashMap and Collections  
✅ Data Structures and Algorithms  

---

## Contributing

Feel free to contribute improvements, additional examples, or corrections!

---

## License

This repository is open source and available under the MIT License.

---

## Author

**Utkarsh Kesarwani**  
GitHub: [@utkarsh-kesarwaNi](https://github.com/utkarsh-kesarwaNi)

---

**Happy Learning! 🚀**
