import org.junit.Assert;
import org.junit.Test;
import voronin.model.ComplexFraction;
import voronin.model.Fraction;
import voronin.service.CalcService;
import voronin.service.ReflectionService;

import java.util.Arrays;
import java.util.List;

public class CalcTest {
    private final CalcService calcService = new CalcService();

    Fraction fraction1 = new Fraction(1,6);
    Fraction fraction2 = new Fraction(4,6);
    ComplexFraction complexFraction1 = new ComplexFraction(1,2,3,4);
    ComplexFraction complexFraction2 = new ComplexFraction(2,5, 2, 7);
    ComplexFraction complexFraction3 = new ComplexFraction(12,24, 3, 9);

    @Test
    public void CheckIfAddFraction_IsCalcCorrect_True() {
        //GIVEN
        Fraction expected = new Fraction(5,6);
        //WHEN
        Fraction actual = calcService.add(fraction1, fraction2);
        actual.simplify();
        //THEN
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void CheckIfSubtractionFraction_IsCalcCorrect_True() {
        //GIVEN
        Fraction expected = new Fraction(1,2);
        //WHEN
        Fraction actual = calcService.subtraction(fraction2, fraction1);
        actual.simplify();
        //THEN
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void CheckIfMultiplyFraction_IsCalcCorrect_True() {
        //GIVEN
        Fraction expected = new Fraction(1,9);
        //WHEN
        Fraction actual = calcService.multiply(fraction2, fraction1);
        actual.simplify();
        //THEN
        Assert.assertEquals(expected, actual);
    }


    @Test
    public void CheckIfAddComplexFraction_IsCalcCorrect_True() {
        //GIVEN
        ComplexFraction expected = new ComplexFraction(1,1, 29,28);
        //WHEN
        ComplexFraction actual = calcService.add(complexFraction1, complexFraction2);
        actual.simplify();
        //THEN
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void CheckIfSubtractionComplexFraction_IsCalcCorrect_True() {
        //GIVEN
        ComplexFraction expected = new ComplexFraction(9,10, 1,28);
        //WHEN
        ComplexFraction actual = calcService.subtraction(complexFraction1, complexFraction2);
        actual.simplify();
        //THEN
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void CheckIfSimplifyComplexFraction_IsCalcCorrect_True() {
        //GIVEN
        ComplexFraction expected = new ComplexFraction(1,2, 1,3);
        //WHEN
        complexFraction3.simplify();
        //THEN
        Assert.assertEquals(expected, complexFraction3);
    }
}
