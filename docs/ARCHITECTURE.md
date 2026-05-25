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
    *   **Base Request Mapping**: `/api/pokemon`
    *   **Endpoint**: `GET /api/pokemon/{pokedexNumber}`
        *   **Purpose**: Retrieves the name of a Pokémon given its Pokedex number.
        *   **Parameters**:
            *   `pokedexNumber` (path variable): An integer representing the unique identifier of the Pokémon.
        *   **Response**: Returns a `String` representing the Pokémon's name with an HTTP 200 OK status.
        *   **Logging**: Includes an `INFO` level log at the start of the `getPokemonNameByPokedexNumber` method for traceability.

### 2.2. Service Layer

*   **`PokemonService`** (`com.pepeai.pokedrawings.service.PokemonService`)
    *   **Method**: `String getPokemonNameByPokedexNumber(int pokedexNumber)`
        *   **Purpose**: Calls the external PokeAPI (`https://pokeapi.co/api/v2/pokemon/{pokedexNumber}`) to retrieve Pokémon details and extracts the Pokémon's name.
        *   **Dependencies**: Utilizes `RestTemplate` for making HTTP calls to the external API.

### 2.3. Model Layer

*   **`PokemonApiResponse`** (`com.pepeai.pokedrawings.model.PokemonApiResponse`)
    *   **Description**: A POJO used to deserialize the JSON response from the PokeAPI, now including Pokémon types and flavor text entries.
    *   **Fields**:
        *   `name` (String): Holds the name of the Pokémon.
        *   `types` (List<TypeWrapper>): A list of type wrappers, each containing details about a Pokémon type.
        *   `flavor_text_entries` (List<FlavorTextEntry>): A list of flavor text entries, each containing a description in a specific language.

## 3. Feature: Retrieve Pokémon Types by Pokedex Number

### 3.1. Controller Layer

*   **`PokemonController`** (`com.pepeai.pokedrawings.controller.PokemonController`)
    *   **Endpoint**: `GET /api/pokemon/{pokedexNumber}/types`
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

## 4. Feature: Retrieve Pokémon Description by Pokedex Number

### 4.1. Controller Layer

*   **`PokemonController`** (`com.pepeai.pokedrawings.controller.PokemonController`)
    *   **Endpoint**: `GET /api/pokemon/{pokedexNumber}/description`
        *   **Purpose**: Retrieves the description of a Pokémon given its Pokedex number.
        *   **Parameters**:
            *   `pokedexNumber` (path variable): An integer representing the unique identifier of the Pokémon.
        *   **Response**: Returns a `String` representing the Pokémon's description with an HTTP 200 OK status.
        *   **Logging**: Includes an `INFO` level log at the start of the `getPokemonDescriptionByPokedexNumber` method for traceability.

### 4.2. Service Layer

*   **`PokemonService`** (`com.pepeai.pokedrawings.service.PokemonService`)
    *   **Method**: `String getPokemonDescriptionByPokedexNumber(int pokedexNumber)`
        *   **Purpose**: Calls the external PokeAPI (`https://pokeapi.co/api/v2/pokemon-species/{pokedexNumber}`) to retrieve Pokémon species details and extracts the English flavor text (description).
        *   **Dependencies**: Utilizes `RestTemplate` for making HTTP calls to the external API.

## 5. Feature: Retrieve Pokémon Image by Pokedex Number

### 5.1. Controller Layer

*   **`PokemonController`** (`com.pepeai.pokedrawings.controller.PokemonController`)
    *   **Endpoint**: `GET /api/pokemon/{pokedexNumber}/image`
        *   **Purpose**: Retrieves the default front sprite image URL of a Pokémon given its Pokedex number.
        *   **Parameters**:
            *   `pokedexNumber` (path variable): An integer representing the unique identifier of the Pokémon.
        *   **Response**: Returns a `String` representing the Pokémon's image URL with an HTTP 200 OK status if found, or HTTP 404 Not Found if the image URL is null.
        *   **Logging**: Includes an `INFO` level log at the start of the `getPokemonImageByPokedexNumber` method for traceability.

### 5.2. Service Layer

*   **`PokemonService`** (`com.pepeai.pokedrawings.service.PokemonService`)
    *   **Method**: `String getPokemonImageByPokedexNumber(int pokedexNumber)`
        *   **Purpose**: Calls the external PokeAPI (`https://pokeapi.co/api/v2/pokemon/{pokedexNumber}`) to retrieve Pokémon details and extracts the URL of the default front sprite (`sprites.frontDefaultSpriteImageUrl`).
        *   **Dependencies**: Utilizes `RestTemplate` for making HTTP calls to the external API.

### 5.3. Model Layer

*   **`PokemonApiResponse`** (`com.pepeai.pokedrawings.model.PokemonApiResponse`)
    *   **Update**: Added a `sprites` field of type `Sprites`.
    *   **New Inner Class**: `public static class Sprites`
        *   **Description**: Represents the sprites object from the PokeAPI response.
        *   **Fields**:
            *   `frontDefaultSpriteImageUrl` (String): Holds the URL of the default front sprite image.

## 6. Feature: Display Random Pokémon on Web Page

### 6.1. Controller Layer

*   **`PokemonWebController`** (`com.pepeai.pokedrawings.controller.PokemonWebController`)
    *   **Description**: A Spring Web Controller responsible for rendering a Thymeleaf template to display a random Pokémon. It generates a random Pokémon ID, fetches its details using the `PokemonService`, and prepares the data for the view.
    *   **Endpoint**: `GET /`
        *   **Purpose**: Generates a random Pokedex number (between 1 and 500), fetches Pokémon's name, types, description, and image URL using `PokemonService`, adds these details to the Spring `Model`, and returns the `pokemon-display` view.
        *   **Parameters**: None.
        *   **Response**: Returns the logical view name `pokemon-display`, which corresponds to the `pokemon-display.html` Thymeleaf template.
        *   **Logging**: Includes an `INFO` level log at the start of the `displayRandomPokemon` method for traceability.

### 6.2. View Layer (Thymeleaf Template)

*   **`pokemon-display.html`** (`src/main/resources/templates/pokemon-display.html`)
    *   **Description**: A Thymeleaf HTML template responsible for presenting the random Pokémon's information to the user.
    *   **Data Displayed**: Pokédex Number, Pokémon Name, Pokémon Types (iterated), Pokémon Description, and Pokémon Image (using `th:src`).
    *   **Styling**: Incorporates modern CSS with a Pokédex-inspired design, utilizing flexbox/grid for layout, clean card design, and appropriate color schemes.
    *   **Interactivity**: Includes a "Next Pokémon" button that reloads the page to fetch and display a new random Pokémon.
    *   **Thymeleaf Usage**: Employs `th:text` for displaying text content, `th:src` for image URLs, and `th:each` for iterating over the list of Pokémon types.

## 7. Configuration

This section outlines the key configuration aspects of the Pokedrawings application.

### 7.1. Application Properties

*   **`application.properties`**: Located in `src/main/resources`, this file contains application-wide settings.
    *   **External API Base URL**: Configuration for the PokeAPI base URL.
    *   **Server Port**: Defines the port on which the Spring Boot application runs.

### 7.2. Maven Dependencies

*   **`pom.xml`**: Manages project dependencies and build configurations.
    *   **Spring Boot Starter Web**: For building web applications, including RESTful services.
    *   **Thymeleaf**: Template engine for server-side rendering of HTML.
    *   **Spring Boot Starter Test**: For writing unit and integration tests.
    *   **Lombok**: (Optional) For reducing boilerplate code (e.g., getters, setters, constructors).
