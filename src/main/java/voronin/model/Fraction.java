package voronin.model;

import voronin.annotation.ShouldInvoke;

import java.util.Objects;

public class Fraction implements ImmutableFraction {

    private int numerator;
    private int denominator;

    public Fraction () {}

    public Fraction (int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Fraction (Fraction fraction) {
        this.numerator = fraction.getNumerator();
        this.denominator = fraction.getDenominator();
    }

    @ShouldInvoke
    public void simplify() {
        long limit = Math.min(numerator, denominator);

        for (long i = 2; i <= limit; i++) {
            if (numerator % i == 0 && denominator % i == 0) {
                numerator /= i;
                denominator /= i;
                i--;
            }
        }
    }

    @ShouldInvoke
    public double getResult () {
        return numerator * 1.0 / denominator;
    }

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fraction fraction = (Fraction) o;
        return numerator == fraction.numerator && denominator == fraction.denominator;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numerator, denominator);
    }

    @Override
    public String toString() {
        return numerator +
                "/" + denominator;
    }
}
