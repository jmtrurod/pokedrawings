package com.pepeai.pokedrawings.model;

import java.util.List;

/**
 * Represents the API response structure for a Pokémon, specifically for extracting the name and types.
 */
public class PokemonApiResponse {
    private String name;
    private List<TypeWrapper> types;

    /**
     * Gets the name of the Pokémon.
     *
     * @return The name of the Pokémon.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the Pokémon.
     *
     * @param name The name of the Pokémon.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the list of types for the Pokémon.
     *
     * @return A list of {@link TypeWrapper} objects, each containing details about a Pokémon type.
     */
    public List<TypeWrapper> getTypes() {
        return types;
    }

    /**
     * Sets the list of types for the Pokémon.
     *
     * @param types A list of {@link TypeWrapper} objects to set.
     */
    public void setTypes(List<TypeWrapper> types) {
        this.types = types;
    }

    /**
     * Inner class representing a wrapper for a Pokémon type, including its slot.
     */
    public static class TypeWrapper {
        private int slot;
        private Type type;

        /**
         * Gets the slot number of the type.
         *
         * @return The slot number.
         */
        public int getSlot() {
            return slot;
        }

        /**
         * Sets the slot number of the type.
         *
         * @param slot The slot number to set.
         */
        public void setSlot(int slot) {
            this.slot = slot;
        }

        /**
         * Gets the type details.
         *
         * @return The {@link Type} object containing the type's name and URL.
         */
        public Type getType() {
            return type;
        }

        /**
         * Sets the type details.
         *
         * @param type The {@link Type} object to set.
         */
        public void setType(Type type) {
            this.type = type;
        }
    }

    /**
     * Inner class representing the details of a Pokémon type.
     */
    public static class Type {
        private String name;
        private String url;

        /**
         * Gets the name of the type.
         *
         * @return The name of the type.
         */
        public String getName() {
            return name;
        }

        /**
         * Sets the name of the type.
         *
         * @param name The name of the type to set.
         */
        public void setName(String name) {
            this.name = name;
        }

        /**
         * Gets the URL of the type.
         *
         * @return The URL of the type.
         */
        public String getUrl() {
            return url;
        }

        /**
         * Sets the URL of the type.
         *
         * @param url The URL of the type to set.
         */
        public void setUrl(String url) {
            this.url = url;
        }
    }
}
