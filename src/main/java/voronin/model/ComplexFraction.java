package voronin.model;

public class ComplexFraction extends Fraction {

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
    public void simplify() {
        realPart.simplify();
        imgPart.simplify();
    }

    @Override
    public String toString() {
        return "\nComplexFraction{ " +
                realPart + " + " +
                imgPart +
                " i }";
    }
}
