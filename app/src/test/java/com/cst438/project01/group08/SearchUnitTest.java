package com.cst438.project01.group08;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * <h2><b>SearchUnitTest</b></h2>
 * These are unit tests to test the search class. It validates whether or not
 * we are able to retrieve information from the function in the Search class.
 *
 * @author Angel Gutierrez
 */

public class SearchUnitTest {
    Search search = new Search();

    @Test
    public void runWithNoParamsShouldReturnOneString() {
        String[] actual = search.getSearchTerms("");
        String[] expected = {""};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void runWithTwoParamsShouldReturnTwoStrings() {
        String[] actual = search.getSearchTerms("muscle, upper arm");
        String[] expected = {"muscle","upper arm"};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void runWithTwoParamsNoDelimiterShouldReturnWholeString() {
        String[] actual = search.getSearchTerms("muscle; upper arm");
        String[] expected = {"muscle; upper arm"};
        assertArrayEquals(expected, actual);

    };
}
