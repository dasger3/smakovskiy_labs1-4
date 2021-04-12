import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import voronin.controller.Controller;
import voronin.controller.Inputer;
import voronin.controller.Parser;
import voronin.model.ComplexFraction;
import voronin.model.Fraction;
import voronin.service.CalcService;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class ControllerTest {

    private final Inputer inputer = mock(Inputer.class);
    private final Parser parser = new Parser();
    private final CalcService calcService = new CalcService();

    @Rule
    public final ExpectedException expectedException = ExpectedException.none();

    @Test
    public void shouldReturnRightFraction() {

        Fraction expected = new Fraction(1,4);

        when(inputer.getUserInput()).thenReturn("1 4");

        Controller controller = new Controller(inputer,parser);

        Fraction fraction = controller.fractionConstructor();

        verify(inputer,times(1)).getUserInput();
        Assert.assertEquals(expected, fraction);
    }
    @Test
    public void shouldReturnRightComplexFraction() {

        ComplexFraction expected = new ComplexFraction(1,4, 3,5);

        when(inputer.getUserInput()).thenReturn("1 4").thenReturn("3 5");

        Controller controller = new Controller(inputer,parser);

        ComplexFraction fraction = controller.complexFractionConstructor();

        verify(inputer,times(2)).getUserInput();
        Assert.assertEquals(expected, fraction);
    }
    @Test
    public void FractionLessNumberInputThrowsExceptionTest() {

        when(inputer.getUserInput()).thenReturn("3");
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Incorrect number of args");
        Controller controller = new Controller(inputer,parser);

        controller.complexFractionConstructor();
    }
    @Test
    public void FractionMoreNumberInputThrowsExceptionTest() {

        when(inputer.getUserInput()).thenReturn("3 1 3");
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Incorrect number of args");
        Controller controller = new Controller(inputer,parser);

        controller.complexFractionConstructor();
    }

    @Test
    public void FractionIncorrectTypeOfDataInputThrowsExceptionTest() {
        when(inputer.getUserInput())
                .thenReturn("3 1")
                .thenReturn("1 two");
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Incorrect type of data");
        Controller controller = new Controller(inputer,parser);
        controller.complexFractionConstructor();
    }

}
