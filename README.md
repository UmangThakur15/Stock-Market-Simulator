# Stock Market Simulator

## Overview

The Stock Market Simulator is a Java-based application designed to simulate portfolio management, allowing users to manage both flexible and non-flexible portfolios. The project is organized into several components, each handling different aspects of the simulation, including portfolio management, stock information retrieval, and user interaction through a command-line interface or a GUI.

## Project Structure

The project is structured into several key directories, each containing specific components of the application:

- **controller**: Contains the classes responsible for handling user input, managing the flow of the application, and controlling the interaction between the view and the model.
- **model**: Contains the core business logic of the application, including portfolio management and stock data handling.
- **view**: Contains the classes responsible for displaying output to the user, either via command-line or graphical user interface (GUI).
- **test**: Contains unit tests for various components of the application to ensure correctness and reliability.

### Controller

The `controller` directory includes several classes and subdirectories:

- **AbstractPortfolioController.java**: An abstract class that defines common methods for managing portfolios.
- **ControllerFlexible.java**: Manages operations for flexible portfolios, including buying, selling, and viewing stocks.
- **ControllerImpl.java**: The main controller implementation handling the standard operations for both flexible and non-flexible portfolios.
- **ControllerMain.java**: The entry point for the application's controller, coordinating overall execution.
- **ControllerNonFlexible.java**: Manages operations specific to non-flexible portfolios.
- **StockInfo.java & StockInfoImpl.java**: Interfaces and classes to retrieve and manage stock information.
- **FlexiblePortfolio & guicontroller**: Contains additional classes specific to handling flexible portfolios and GUI-based controllers.

### Model

The `model` directory is where the core logic and data management occur:

- **AbstractPortfolio.java**: An abstract class defining the structure of a portfolio.
- **Portfolio.java, PortfolioFlexible.java, PortfolioNonFlexible.java**: Define the different types of portfolios and their respective functionalities.
- **ApiAccessData.java & IApiAccessData.java**: Interfaces and implementations for accessing stock market data via APIs.
- **LoadData.java & ILoadData.java**: Handles loading portfolio data from various sources.
- **ModelImpl.java, ModelImplFlexible, ModelImplNonFlexible**: Implementations of the model interface, managing the simulation's business logic.

### View

The `view` directory handles user interactions:

- **View.java & ViewImpl.java**: Interfaces and implementations for displaying output to the user.
- **guiview**: Contains classes for handling graphical user interface (GUI) views.

### Test

The `test` directory includes unit tests for various components:

- **FlexiblePortfolioTest & NonFlexiblePortfolioTest.java**: Test cases for flexible and non-flexible portfolios.
- **MockModel** and **MockView**: Mock classes used for testing the interaction between different components.
- **MockModelTestFlexible & MockModelTestNonFlexible.java**: Tests for mock models of flexible and non-flexible portfolios.
- **MockViewTestFlexible & MockViewTestNonFlexible.java**: Tests for mock views associated with the portfolios.

### Data Files

The project also includes several CSV files, such as `portfolio_data_1.csv`, `portfolio_data_2.csv`, etc., which are used to load and manage portfolio data within the simulation.

## How to Run

To run the Stock Market Simulator, follow these steps:

1. Compile the Java files in the `controller`, `model`, and `view` directories.
2. Run the `ControllerMain.java` class to start the simulation.
3. Follow the on-screen instructions to interact with the simulator, either through the command-line interface or the GUI.

## Features

- **Flexible Portfolios**: Manage portfolios that allow buying, selling, and viewing stocks with more control and flexibility.
- **Non-Flexible Portfolios**: Simpler portfolio management with restricted operations, simulating more conservative investment strategies.
- **Data Integration**: Load and save portfolio data from and to CSV files, making it easy to start with predefined data sets.
- **API Integration**: Retrieve real-time stock data using APIs, allowing for up-to-date simulations.
- **Testing**: Comprehensive unit tests ensure that the core functionalities are reliable and accurate.
