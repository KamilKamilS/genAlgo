package com.facebook.genAlgo.gene;

import com.facebook.genAlgo.gene.Gene;
import com.facebook.genAlgo.utils.RandomProvider;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GeneTest {

    RandomProvider randomProviderMock = mock(RandomProvider.class);

    @DisplayName("Should Gene.values have random length")
    @ParameterizedTest
    @ValueSource(ints = {0, 2, 100, 145, 257})
    public void testGeneValuesLength(int lengthExpected) {
        // given
        when(randomProviderMock.getRandom(anyInt())).thenReturn(lengthExpected);

        // when
        Gene actual = new Gene(randomProviderMock);

        // then
        assertEquals(lengthExpected, actual.getValues().length);
    }

    @DisplayName("Should Gene.values are filled randomly")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 13, 98, 278, Character.MAX_VALUE})
    public void testGeneValues(int valueExpected) {
        // given
        when(randomProviderMock.getRandom(anyInt())).thenReturn(valueExpected);

        // when
        Gene actual = new Gene(randomProviderMock);

        // then
        for (char value : actual.getValues()) {
            assertEquals(valueExpected, value);
        }
    }

    @DisplayName("Should Gene.values be initialized")
    @Test
    public void shouldGeneValuesBeInitialized() {
        // when
        Gene actual = new Gene(randomProviderMock);

        // then
        assertNotNull(actual.getValues());
    }
}