package voronin.view;

import voronin.model.ComplexFraction;
import voronin.model.Fraction;

public interface View {

    void showFraction(Fraction fraction);
    void showComplexFraction(ComplexFraction fraction);

}
