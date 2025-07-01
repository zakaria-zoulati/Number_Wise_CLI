# NumberWise CLI

## Overview

**NumberWise CLI** is a command-line interface (CLI) tool for analyzing numbers using various mathematical and number-theoretic algorithms. It provides a set of commands to check properties of numbers, such as primality, Fibonacci sequence membership, and more. The CLI interacts with a Flask-based backend API to perform these checks.

---

## Features

- Analyze numbers using a variety of algorithms:
  - Primality (`isPrime`)
  - Palindromic check (`isPalindromic`)
  - Fibonacci sequence membership (`isFibonacci`)
  - Lucas number check (`isLucas`)
  - Triangular number check (`isTriangular`)
  - And many more (see the full list below).
- Generate an overview of all supported algorithms for a given number.
- Lightweight and easy-to-use CLI built with [Picocli](https://picocli.info/).
- Interacts with a Flask backend API for algorithmic computations.

---

## Installation

### Prerequisites

- Java 17 or higher
- Maven
- Flask backend running on `http://localhost:8000`

### Build Instructions

1. Clone the repository:
   ```sh
   git clone <repository-url>
   cd Number_Wise_CLI
   ```

2. Build the project using Maven:
   ```sh
   mvn clean package
   ```

3. The executable JAR file will be located in the `target` directory:
   ```
   target/First_CLI-1.0-SNAPSHOT-shaded.jar
   ```

---

## Usage

### Running the CLI

To run the CLI, use the provided batch script or execute the JAR file directly:

```sh
java -jar target/First_CLI-1.0-SNAPSHOT-shaded.jar <command> <number>
```

### Commands

#### `check`
Analyze a number using a specific algorithm.

**Syntax:**
```sh
java -jar target/First_CLI-1.0-SNAPSHOT-shaded.jar check <algorithm> <number>
```

**Example:**
```sh
java -jar target/First_CLI-1.0-SNAPSHOT-shaded.jar check isPrime 17
```

#### `overview`
Generate an overview of all supported algorithms for a given number.

**Syntax:**
```sh
java -jar target/First_CLI-1.0-SNAPSHOT-shaded.jar check overview <number>
```

**Example:**
```sh
java -jar target/First_CLI-1.0-SNAPSHOT-shaded.jar check overview 17
```

---

## Algorithms

The following algorithms are supported:

- `isPrime`: Check if the number is prime.
- `isPalindromic`: Check if the number is palindromic.
- `isFibonacci`: Check if the number is in the Fibonacci sequence.
- `isLucas`: Check if the number is a Lucas number.
- `isTriangular`: Check if the number is triangular.
- `isPronic`: Check if the number is pronic.
- `isPolite`: Check if the number is polite.
- `isPerfect`: Check if the number is perfect.
- `isPentatope`: Check if the number is a pentatope number.
- `isPentagonal`: Check if the number is pentagonal.
- `isOctagonal`: Check if the number is octagonal.
- `isIcosahedral`: Check if the number is icosahedral.
- `isHarshad`: Check if the number is a Harshad number.
- `isFermat`: Check if the number is a Fermat number.
- `isEven`: Check if the number is even.
- `isDeficient`: Check if the number is deficient.
- `isCullen`: Check if the number is a Cullen number.
- `isCatalan`: Check if the number is a Catalan number.
- `isAutomorphic`: Check if the number is automorphic.
- `isSphenic`: Check if the number is sphenic.

---

## Development

### Code Structure

- **Main Class**: `NumberWise`
  - Entry point for the CLI.
  - Registers subcommands like `global`.

- **Subcommand**: `global`
  - Implements the `check` command.
  - Validates input and interacts with the Flask backend via `SpringClient`.

- **REST Client**: `SpringClient`
  - Sends HTTP requests to the Flask backend.
  - Parses JSON responses using Jackson.

### Dependencies

- [Picocli](https://picocli.info/): CLI framework.
- [Spring Web](https://spring.io/projects/spring-framework): REST client.
- [Jackson](https://github.com/FasterXML/jackson): JSON parsing.

---
