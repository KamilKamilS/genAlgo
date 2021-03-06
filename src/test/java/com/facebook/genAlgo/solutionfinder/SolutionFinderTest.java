package com.facebook.genAlgo.solutionfinder;

import com.facebook.genAlgo.gene.Gene;
import com.facebook.genAlgo.utils.RandomProvider;
import com.facebook.genAlgo.utils.RandomProviderImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionFinderTest {

    RandomProvider randomProvider = new RandomProviderImpl();
    List<Gene> geneList;

    @BeforeEach
    public void setUp() {
        geneList = List.of(
                new Gene(randomProvider),
                new Gene(randomProvider),
                new Gene(randomProvider)
        );
    }

    @Test
    public void shouldReturnTrueWhenFoundSolution() {
        // given
        char target = 'A';
        geneList.get(2).setValue(target);
        SolutionFinder solutionFinder = new SolutionFinder(target);

        // when
        Boolean result = solutionFinder.findSolution(geneList);

        // then
        assertTrue(result);
    }

    @Test
    public void shouldReturnFalseWhenNotFoundSolution() {
        // given
        char target = 'A';
        char notTarget = 'C';
        geneList.get(0).setFitness(notTarget);
        geneList.get(1).setFitness(notTarget);
        geneList.get(2).setFitness(notTarget);

        SolutionFinder solutionFinder = new SolutionFinder(target);

        // when
        Boolean result = solutionFinder.findSolution(geneList);

        // then
        assertFalse(result);
    }
}