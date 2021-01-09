package com.facebook.genAlgo.crossover;

import com.facebook.genAlgo.gene.Gene;
import com.facebook.genAlgo.utils.RandomProvider;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mock;

import java.util.stream.Stream;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.when;

public class MixingHalvesCrossoverServiceImplTest {

    @Mock
    RandomProvider randomProviderGene1, randomProviderGene2;

    @ParameterizedTest
    @MethodSource("mixingHalvesCrossoverProvider")
    void shouldProvideMixingHalvesCrossover(int gene1Val, int gene2Val, char gene1ValueAfterCross, char gene2ValueAfterCross) {
        // given
        CrossoverService mixingHalvesService = new MixingHalvesCrossoverServiceImpl();
        when(randomProviderGene1.getRandom(anyInt())).thenReturn(gene1Val);
        when(randomProviderGene2.getRandom(anyInt())).thenReturn(gene2Val);

        // when
        Gene gene1 = new Gene(randomProviderGene1);
        Gene gene2 = new Gene(randomProviderGene2);
        mixingHalvesService.cross(gene1, gene2);

        // then
        Assertions.assertEquals(gene1.getValue(), gene1ValueAfterCross);
        Assertions.assertEquals(gene2.getValue(), gene2ValueAfterCross);
    }


    private Stream<Arguments> mixingHalvesCrossoverProvider() {
        return Stream.of(
                Arguments.of(4505, 36, (char) 4388, (char) 153),
                Arguments.of(33, 5000, (char) 136, (char) 4897),
                Arguments.of(70, 65535, (char) 255, (char) 65350)
        );
    }
}
