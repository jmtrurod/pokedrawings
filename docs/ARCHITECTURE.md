# Project Architecture

This document outlines the architectural design and key components of the Pokedrawings application.

## 1. Layered Architecture

The application follows a strict layered architecture to ensure separation of concerns, maintainability, and scalability.

*   **`controller`**: Handles incoming HTTP requests, delegates to the service layer, and returns HTTP responses.
*   **`service`**: Contains the core business logic, orchestrates operations, and interacts with repositories or external services.
*   **`repository`**: Manages data access operations (not explicitly used in this feature, but part of the overall architecture).
*   **`model`**: Defines data structures, DTOs, and entities used across layers.
*   **`utils`**: Reserved for stateless utility classes and helpers.

## 2. Feature: Retrieve Pokémon Name by Pokedex Number

### 2.1. Controller Layer

*   **`PokemonController`** (`com.pepeai.pokedrawings.controller.PokemonController`)
    *   **Description**: A REST controller responsible for handling HTTP requests related to Pokémon information.
    *   **Endpoint**: `GET /pokemon/{pokedexNumber}`
        *   **Purpose**: Retrieves the name of a Pokémon given its Pokedex number.
        *   **Parameters**:
            *   `pokedexNumber` (path variable): An integer representing the unique identifier of the Pokémon.
        *   **Response**: Returns a `String` representing the Pokémon's name with an HTTP 200 OK status.
        *   **Logging**: Includes an `INFO` level log at the start of the `getPokemonNameByPokedexNumber` method for traceability.

### 2.2. Service Layer

*   **`PokemonService`** (`com.pepeai.pokedrawings.service.PokemonService`)
    *   **Description**: Contains the business logic for fetching Pokémon data. It interacts with the external PokeAPI.
    *   **Method**: `String getPokemonNameByPokedexNumber(int pokedexNumber)`
        *   **Purpose**: Calls the external PokeAPI (`https://pokeapi.co/api/v2/pokemon/{pokedexNumber}`) to retrieve Pokémon details and extracts the Pokémon's name.
        *   **Dependencies**: Utilizes `RestTemplate` for making HTTP calls to the external API.

### 2.3. Model Layer

*   **`PokemonApiResponse`** (`com.pepeai.pokedrawings.model.PokemonApiResponse`)
    *   **Description**: A POJO used to deserialize the JSON response from the PokeAPI, now including Pokémon types.
    *   **Fields**:
        *   `name` (String): Holds the name of the Pokémon.
        *   `types` (List<TypeWrapper>): A list of type wrappers, each containing details about a Pokémon type.

### 2.4. Configuration

*   **`RestTemplateConfig`** (`com.pepeai.pokedrawings.utils.RestTemplateConfig`)
    *   **Description**: A Spring `@Configuration` class that provides a `RestTemplate` bean to the application context, enabling HTTP communication with external services.
*   **`application.properties`**
    *   **Property**: `pokeapi.base.url=https://pokeapi.co/api/v2/`
    *   **Purpose**: Configures the base URL for the PokeAPI, used by `PokemonService`.

## 3. Feature: Retrieve Pokémon Types by Pokedex Number

### 3.1. Controller Layer

*   **`PokemonController`** (`com.pepeai.pokedrawings.controller.PokemonController`)
    *   **Endpoint**: `GET /pokemon/{pokedexNumber}/types`
        *   **Purpose**: Retrieves a list of types for a Pokémon given its Pokedex number.
        *   **Parameters**:
            *   `pokedexNumber` (path variable): An integer representing the unique identifier of the Pokémon.
        *   **Response**: Returns a `List<String>` representing the Pokémon's types with an HTTP 200 OK status.
        *   **Logging**: Includes an `INFO` level log at the start of the `getPokemonTypesByPokedexNumber` method for traceability.

### 3.2. Service Layer

*   **`PokemonService`** (`com.pepeai.pokedrawings.service.PokemonService`)
    *   **Method**: `List<String> getPokemonTypesByPokedexNumber(int pokedexNumber)`
        *   **Purpose**: Calls the external PokeAPI (`https://pokeapi.co/api/v2/pokemon/{pokedexNumber}`) to retrieve Pokémon details and extracts a list of the Pokémon's types.
        *   **Dependencies**: Utilizes `RestTemplate` for making HTTP calls to the external API.

## 3. Feature: Retrieve Pokémon Types by Pokedex Number

### 3.1. Controller Layer

*   **`PokemonController`** (`com.pepeai.pokedrawings.controller.PokemonController`)
    *   **Endpoint**: `GET /pokemon/{pokedexNumber}/types`
        *   **Purpose**: Retrieves a list of types for a Pokémon given its Pokedex number.
        *   **Parameters**:
            *   `pokedexNumber` (path variable): An integer representing the unique identifier of the Pokémon.
        *   **Response**: Returns a `List<String>` representing the Pokémon's types with an HTTP 200 OK status.
        *   **Logging**: Includes an `INFO` level log at the start of the `getPokemonTypesByPokedexNumber` method for traceability.

### 3.2. Service Layer

*   **`PokemonService`** (`com.pepeai.pokedrawings.service.PokemonService`)
    *   **Method**: `List<String> getPokemonTypesByPokedexNumber(int pokedexNumber)`
        *   **Purpose**: Calls the external PokeAPI (`https://pokeapi.co/api/v2/pokemon/{pokedexNumber}`) to retrieve Pokémon details and extracts a list of the Pokémon's types.
        *   **Dependencies**: Utilizes `RestTemplate` for making HTTP calls to the external API.
