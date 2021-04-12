package voronin.controller;

import voronin.model.ComplexFraction;
import voronin.model.Fraction;

public class Controller {
    private final Parser parser;
    private final Inputer inputer;
    //private final CalcService calcService;

    public Controller (Inputer inputer, Parser parser) {
        this.inputer = inputer;
        this.parser = parser;
        //calcService = new CalcService();
    }

    public Fraction fractionConstructor() {
        System.out.print("Enter the numerator and denominator separated by a space: ");
        String input = inputer.getUserInput();
        return parser.parseFraction(input);
    }

    public ComplexFraction complexFractionConstructor() {
        ComplexFraction result = new ComplexFraction();

        System.out.println("Enter real part:");
        result.setRealPart(fractionConstructor());

        System.out.println("Enter imagine part:");
        result.setImgPart(fractionConstructor());

        return result;
    }

}
