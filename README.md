# Kennel Management System

## Overview

Welcome to the Kennel Management System, a Java-based program designed to manage a kennel's collection of cats and dogs. This system allows you to perform various operations, including adding and removing animals, searching for specific animals, and saving/loading kennel information from files.

## Table of Contents

1. [Features](#features)
2. [Getting Started](#getting-started)
    - [Prerequisites](#prerequisites)
    - [Installation](#installation)
3. [Usage](#usage)
4. [Code Structure](#code-structure)
5. [Contributing](#contributing)
6. [License](#license)

## Features

- **Animal Hierarchy:** The program introduces an `Animal` class hierarchy with subclasses for both cats and dogs, promoting code reuse through inheritance.

- **Sorting Animals:** Animals are now sortable by name, enhancing the readability and organization of the kennel information.

- **Polymorphic Operations:** The KennelDemo class is updated to handle both cats and dogs using polymorphic variables and parameters.

- **File I/O:** You can save and load kennel information to and from files, ensuring data persistence between program executions.

## Getting Started

### Prerequisites

- Java Development Kit (JDK) installed on your machine.
- An Integrated Development Environment (IDE) such as Eclipse or IntelliJ IDEA.

### Installation

1. Clone the repository to your local machine:

    ```bash
    git clone https://github.com/your-username/kennel-management.git
    ```

2. Open the project in your preferred IDE.

## Usage

1. Run the `KennelDemo` class to execute the program.

2. Follow the on-screen prompts to interact with the kennel management system.

3. Explore the features, including adding/removing animals, sorting, searching, and saving/loading from files.

## Code Structure

- **`Kennel.java`**: The main class representing the kennel with methods for managing cats and dogs.

- **`Animal.java`**: The base class for all animals, with common attributes and methods.

- **`Cat.java`** and **`Dog.java`**: Subclasses of `Animal` representing cats and dogs, respectively.

- **`KennelDemo.java`**: A demo class demonstrating the usage of the kennel management system.
