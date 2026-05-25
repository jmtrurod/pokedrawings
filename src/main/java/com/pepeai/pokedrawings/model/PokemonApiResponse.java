package com.pepeai.pokedrawings.model;

import java.util.List;

/**
 * Represents the API response structure for a Pokémon, specifically for extracting the name, types, and description.
 */
public class PokemonApiResponse {
    private String name;
    private List<TypeWrapper> types;
    private List<FlavorTextEntry> flavorTextEntries;

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
     * Gets the list of flavor text entries for the Pokémon.
     *
     * @return A list of {@link FlavorTextEntry} objects, each containing a description in a specific language.
     */
    public List<FlavorTextEntry> getFlavorTextEntries() {
        return flavorTextEntries;
    }

    /**
     * Sets the list of flavor text entries for the Pokémon.
     *
     * @param flavorTextEntries A list of {@link FlavorTextEntry} objects to set.
     */
    public void setFlavorTextEntries(List<FlavorTextEntry> flavorTextEntries) {
        this.flavorTextEntries = flavorTextEntries;
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

    /**
     * Inner class representing a flavor text entry for a Pokémon.
     */
    public static class FlavorTextEntry {
        private String flavorText;
        private Language language;

        /**
         * Gets the flavor text (description) of the Pokémon.
         *
         * @return The flavor text.
         */
        public String getFlavorText() {
            return flavorText;
        }

        /**
         * Sets the flavor text (description) of the Pokémon.
         *
         * @param flavorText The flavor text to set.
         */
        public void setFlavorText(String flavorText) {
            this.flavorText = flavorText;
        }

        /**
         * Gets the language of the flavor text.
         *
         * @return The {@link Language} object.
         */
        public Language getLanguage() {
            return language;
        }

        /**
         * Sets the language of the flavor text.
         *
         * @param language The {@link Language} object to set.
         */
        public void setLanguage(Language language) {
            this.language = language;
        }
    }

    /**
     * Inner class representing the language of a flavor text entry.
     */
    public static class Language {
        private String name;
        private String url;

        /**
         * Gets the name of the language.
         *
         * @return The name of the language.
         */
        public String getName() {
            return name;
        }

        /**
         * Sets the name of the language.
         *
         * @param name The name of the language to set.
         */
        public void setName(String name) {
            this.name = name;
        }

        /**
         * Gets the URL of the language.
         *
         * @return The URL of the language.
         */
        public String getUrl() {
            return url;
        }

        /**
         * Sets the URL of the language.
         *
         * @param url The URL of the language to set.
         */
        public void setUrl(String url) {
            this.url = url;
        }
    }
}
