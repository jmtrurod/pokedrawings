package com.pepeai.pokedrawings.model;

import org.junit.jupiter.api.Test;
import java.lang.reflect.Field;
import java.util.List; // Added import for List
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for {@link PokemonApiResponse} to ensure variable naming conventions are followed.
 */
public class PokemonApiResponseTest {

    /**
     * Tests that the 'flavor_text_entries' field in PokemonApiResponse is refactored to 'flavorTextEntries'.
     * This test uses reflection to check for the existence of the field with the correct camelCase name.
     */
    @Test
    void testFlavorTextEntriesFieldRefactoredToCamelCase() {
        try {
            Field flavorTextEntriesField = PokemonApiResponse.class.getDeclaredField("flavorTextEntries");
            assertNotNull(flavorTextEntriesField, "The field 'flavorTextEntries' should exist.");
            assertEquals(List.class, flavorTextEntriesField.getType(), "The 'flavorTextEntries' field should be of type List.");
        } catch (NoSuchFieldException e) {
            fail("Field 'flavorTextEntries' not found. It should be refactored from 'flavor_text_entries'.");
        }
    }

    /**
     * Tests that the 'flavor_text' field in FlavorTextEntry is refactored to 'flavorText'.
     * This test uses reflection to check for the existence of the field with the correct camelCase name.
     */
    @Test
    void testFlavorTextFieldRefactoredToCamelCase() {
        try {
            Field flavorTextField = PokemonApiResponse.FlavorTextEntry.class.getDeclaredField("flavorText");
            assertNotNull(flavorTextField, "The field 'flavorText' should exist.");
            assertEquals(String.class, flavorTextField.getType(), "The 'flavorText' field should be of type String.");
        } catch (NoSuchFieldException e) {
            fail("Field 'flavorText' not found. It should be refactored from 'flavor_text'.");
        }
    }

    /**
     * Tests that the 'front_default' field in Sprites is refactored to 'frontDefaultSpriteImageUrl'.
     * This test uses reflection to check for the existence of the field with the correct descriptive name.
     */
    @Test
    void testFrontDefaultFieldRefactoredToDescriptiveName() {
        try {
            // Check for the new descriptive field name
            Field frontDefaultSpriteImageUrlField = PokemonApiResponse.Sprites.class.getDeclaredField("frontDefaultSpriteImageUrl");
            assertNotNull(frontDefaultSpriteImageUrlField, "The field 'frontDefaultSpriteImageUrl' should exist.");
            assertEquals(String.class, frontDefaultSpriteImageUrlField.getType(), "The 'frontDefaultSpriteImageUrl' field should be of type String.");

            // Ensure the old field name 'front_default' no longer exists
            assertThrows(NoSuchFieldException.class, () -> PokemonApiResponse.Sprites.class.getDeclaredField("front_default"),
                    "The old field 'front_default' should no longer exist.");

        } catch (NoSuchFieldException e) {
            fail("Field 'frontDefaultSpriteImageUrl' not found or other reflection error. It should be refactored from 'front_default'.");
        }
    }
}
