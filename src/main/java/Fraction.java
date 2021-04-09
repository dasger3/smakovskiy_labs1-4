public class Fraction implements ImmutableFraction {

    private int numerator;
    private int denominator;

    public Fraction () {}

    public Fraction (int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public static Fraction add (Fraction first, Fraction second) {
        return new Fraction(first.getNumerator() * second.getDenominator() + second.getNumerator() * first.getDenominator(),
                            first.getDenominator() * second.getDenominator());
    }

    public static Fraction subtraction (Fraction first, Fraction second) {
        return new Fraction(first.getNumerator() * second.getDenominator() - second.getNumerator() * first.getDenominator(),
                            first.getDenominator() * second.getDenominator());
    }

    public static Fraction multiply (Fraction first, Fraction second) {
        Fraction result = new Fraction();
        result.setNumerator(first.getNumerator() * second.getNumerator());
        result.setDenominator(first.getDenominator() * second.getDenominator());
        return result;
    }

    @ShouldInvoke
    public Fraction simplify() {
        long limit = Math.min(numerator, denominator);

        for (long i = 2; i <= limit; i++) {
            if (numerator % i == 0 && denominator % i == 0) {
                numerator /= i;
                denominator /= i;
            }
        }
        return this;
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
    public String toString() {
        return numerator +
                "/" + denominator;
    }
}
