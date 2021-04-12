package voronin.view;

import voronin.model.ComplexFraction;
import voronin.model.Fraction;

public class ConsoleView implements View{

    public void showFraction(Fraction fraction) {
        System.out.println("Fraction: " + fraction.getNumerator() + "/" + fraction.getDenominator());
    }
    public void showComplexFraction(ComplexFraction fraction) {
        System.out.println("ComplexFraction: " + fraction.getRealPart() + " + " + fraction.getImgPart()+ " i");
    }

}
