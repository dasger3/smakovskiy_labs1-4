import org.junit.Assert;
import org.junit.Test;
import voronin.model.Fraction;
import voronin.model.ImmutableFraction;
import voronin.service.ReflectionService;

import java.util.Arrays;
import java.util.List;

public class ReflectionServiceTest {

    private final ReflectionService reflectionService = new ReflectionService();

    Fraction fraction1 = new Fraction(1,6);
    Fraction fraction2 = new Fraction(4,6);

    @Test
    public void CheckIfShouldInvoke_IsAnnotationWork_True() {
        //GIVEN
        List<String> expected = Arrays.asList("getResult", "simplify");
        Fraction before = new Fraction(fraction2);
        //WHEN
        List<String> actual = reflectionService.checkIfShouldInvoke(fraction2);
        //THEN
        Assert.assertNotEquals(before, fraction2);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void ShowConstructorList_IsListCorrect_True() {
        //GIVEN
        List<String> expected = Arrays.asList("public voronin.model.Fraction(voronin.model.Fraction)",
                                              "public voronin.model.Fraction(int,int)",
                                              "public voronin.model.Fraction()");
        //WHEN
        List<String> actual = reflectionService.showConstructorList(fraction1);
        //THEN
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void showAccessModifierInformation_IsResultCorrect_True() {
        //GIVEN
        String expected = "Class modifier: public";
        //WHEN
        String actual = reflectionService.showAccessModifierInformation(fraction1);
        //THEN
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = RuntimeException.class)
    public void ImmutableProxyExample_CanNotUseSetter_Exception() {
        //GIVEN
        ImmutableFraction immutableFraction = reflectionService.immutableProxyExample(fraction1);
        //WHEN
        immutableFraction.setDenominator(100);
    }

    @Test
    public void ImmutableProxyExample_CanUseGetter_True() {
        //GIVEN
        ImmutableFraction immutableFraction = reflectionService.immutableProxyExample(fraction1);
        //WHEN
        int actual = immutableFraction.getDenominator();
        //THEN
        Assert.assertEquals(6, actual);
    }
}
