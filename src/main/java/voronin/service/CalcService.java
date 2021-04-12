package voronin.service;

import voronin.model.ComplexFraction;
import voronin.model.Fraction;

public class CalcService {
    public Fraction add (Fraction first, Fraction second) {
        return new Fraction(first.getNumerator() * second.getDenominator() + second.getNumerator() * first.getDenominator(),
                            first.getDenominator() * second.getDenominator());
    }

    public Fraction subtraction (Fraction first, Fraction second) {
        return new Fraction(first.getNumerator() * second.getDenominator() - second.getNumerator() * first.getDenominator(),
                            first.getDenominator() * second.getDenominator());
    }

    public Fraction multiply (Fraction first, Fraction second) {
        return new Fraction(first.getNumerator() * second.getNumerator(),
                            first.getDenominator() * second.getDenominator());
    }

    public ComplexFraction add(ComplexFraction first, ComplexFraction second) {
        return new ComplexFraction(add(first.getRealPart(),second.getRealPart()),
                                    add(first.getImgPart(),second.getImgPart()));
    }
    public ComplexFraction subtraction(ComplexFraction first, ComplexFraction second) {
        return new ComplexFraction(subtraction(first.getRealPart(),second.getRealPart()),
                                    subtraction(first.getImgPart(),second.getImgPart()));
    }

    public ComplexFraction multiply(ComplexFraction first, ComplexFraction second) {
        return new ComplexFraction(multiply(first.getRealPart(),second.getRealPart()),
                                    multiply(first.getImgPart(),second.getImgPart()));
    }
}
