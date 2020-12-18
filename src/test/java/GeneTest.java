import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.concurrent.ThreadLocalRandom;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class GeneTest {

  @Test
  public void testArraySizeGeneWithMock() {

    // Given
    RandomProvider randomProviderMock = mock(RandomProvider.class);

    int numberExpected = 113;
    when(randomProviderMock.getRandom(any(), any())).thenReturn(numberExpected);

    // when
    Gene actual = new Gene(randomProviderMock);

    // then
    assertEquals(numberExpected, actual.getValues().length);
  }

  @Test
  public void testValueUnderTheIndexGeneWithMock() {
    // Given
    int boundedRandomValue = ThreadLocalRandom.current().nextInt(0, 5);
    RandomProvider randomProviderMock = mock(RandomProvider.class);

    char[] values = new char[5];

    values[0] = (char) boundedRandomValue;
    values[1] = (char) boundedRandomValue;
    values[2] = (char) boundedRandomValue;
    values[3] = (char) boundedRandomValue;
    values[4] = (char) boundedRandomValue;

    Gene gene = new Gene(randomProviderMock);

    for (int i = 0; i < values.length; i++) {

      when(randomProviderMock.getRandom(any(), any())).thenReturn((int) values[i]);

      // When
      int valueUnderTheIndex = gene.values[i];

      // then
      Assert.assertEquals(values[i], valueUnderTheIndex);
    }
  }
}
