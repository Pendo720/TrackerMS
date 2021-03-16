package com.trackerms.models;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class TrackableTest {
    Trackable _trackable;
    @BeforeEach
    void setUp() {
        _trackable = new Trackable("Eggs");
    }

    @AfterEach
    void tearDown() { }

    @DisplayName("Item has a valid JSON string syntax")
    @Test
    void has_valid_json_syntax() {
        assertNotNull(_trackable.asJon());
    }
    @DisplayName("Item has a null id")
    @Test
    void has_invalid_id() { assertNull(_trackable.get_id()); }

    @DisplayName("Item has correct label")
    @Test
    void has_correct_name() {
        assertEquals("Eggs", _trackable.get_item());
    }

    @DisplayName("Check-in pause - wip")
    @Disabled
    @Test
    void work_in_progress(){ fail(); }
}