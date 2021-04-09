public class ComplexFraction extends Fraction{

    private Fraction realPart;
    private Fraction imgPart;

    public ComplexFraction () {}

    public ComplexFraction (Fraction realPart, Fraction imgPart) {
        this.realPart = realPart;
        this.imgPart = imgPart;
    }

    public ComplexFraction (int realPart_n, int realPart_d, int imgPart_n, int imgPart_d) {
        realPart = new Fraction(realPart_n, realPart_d);
        imgPart = new Fraction(imgPart_n, imgPart_d);
    }

    public static ComplexFraction add(ComplexFraction first, ComplexFraction second) {
        return new ComplexFraction(add(first.getRealPart(),second.getRealPart()),add(first.getImgPart(),second.getImgPart()));
    }
    public static ComplexFraction subtraction(ComplexFraction first, ComplexFraction second) {
        return new ComplexFraction(subtraction(first.getRealPart(),second.getRealPart()),subtraction(first.getImgPart(),second.getImgPart()));
    }

    public static ComplexFraction multiply(ComplexFraction first, ComplexFraction second) {
        return new ComplexFraction(multiply(first.getRealPart(),second.getRealPart()),multiply(first.getImgPart(),second.getImgPart()));
    }

    public Fraction getRealPart() {
        return realPart;
    }

    public void setRealPart(Fraction realPart) {
        this.realPart = realPart;
    }

    public Fraction getImgPart() {
        return imgPart;
    }

    public void setImgPart(Fraction imgPart) {
        this.imgPart = imgPart;
    }

    @Override
    public String toString() {
        return "\nComplexFraction{ " +
                realPart + " + " +
                imgPart +
                " i }";
    }
}
