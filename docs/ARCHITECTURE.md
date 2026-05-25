# Project Architecture

This document outlines the architectural overview of the Pokedrawings application.

## 1. Layered Architecture

The application follows a strict layered architecture to ensure separation of concerns, maintainability, and scalability.

### 1.1. Controller Layer (`com.pepeai.pokedrawings.controller`)
- **Purpose**: Handles incoming HTTP requests, delegates to the service layer, and returns HTTP responses.
- **Components**:
    - `PokemonController`: Manages REST endpoints related to Pokémon, such as retrieving Pokémon names by Pokedex number.

### 1.2. Service Layer (`com.pepeai.pokedrawings.service`)
- **Purpose**: Contains the core business logic, orchestrates operations, and defines transaction boundaries.
- **Components**:
    - `PokemonService`: Interface defining the contract for Pokémon-related business operations.
    - `PokemonServiceImpl`: Implementation of `PokemonService`, containing the actual business logic and interacting with the repository layer.

### 1.3. Repository Layer (`com.pepeai.pokedrawings.repository`)
- **Purpose**: Handles data access operations, interacting with external data sources (e.g., databases, external APIs).
- **Components**:
    - `PokemonRepository`: Interface defining the contract for Pokémon data access.
    - `PokemonRepositoryImpl`: Implementation of `PokemonRepository`, responsible for fetching Pokémon data from the external Pokémon API (simulated via `search_pokemon_docs` tool).

## 2. API Endpoints

### 2.1. Pokémon Endpoints

- **GET /pokemon/{pokedexNumber}**
    - **Description**: Retrieves the name of a Pokémon based on its Pokedex number.
    - **Path Variable**: `pokedexNumber` (integer) - The unique identifier of the Pokémon.
    - **Response**:
        - `200 OK`: Returns the Pokémon's name as a String.
        - `404 Not Found`: If no Pokémon is found for the given Pokedex number.
    - **Logging**: Each request to this endpoint is logged at the INFO level, including the `pokedexNumber` parameter.
