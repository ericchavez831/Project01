package com.cst438.project01.group08;

import org.junit.Test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * <h2><b>DisplayActivityUnitTest</b></h2>
 * These are unit tests to test the display activity class.
 *
 * @author Eric Chavez Velez
 */

public class DisplayActivityUnitTest {

    @Test
    public void emptyText() {
        String userInput = "";
        assertEquals(true, DisplayActivity.emptyText(userInput));
    }

    @Test
    public void nonEmptyText() {
        String userInput = "push ups";
        assertEquals(false, DisplayActivity.emptyText(userInput));
    }

    @Test
    public void noExercises() {
        List<Exercise> exercises = new ArrayList<>();
        assertEquals(true, DisplayActivity.noExercises(exercises));
    }

    @Test
    public void yesExercises() {
        List<Exercise> exercises = new ArrayList<>();
        exercises.add(new Exercise("www.gif.com", "Push Up", "None", "Biceps", "Arms"));
        assertEquals(false, DisplayActivity.noExercises(exercises));
    }

}
