package voronin.controller;

import voronin.model.Fraction;

public class Parser {

    public Fraction parseFraction (String input) {
        String []args = input.split(" ");
        Fraction result = new Fraction();
        if (args.length != 2) throw new IllegalArgumentException("Incorrect number of args");
        try {
                result.setNumerator(Integer.parseInt(args[0]));
                result.setDenominator(Integer.parseInt(args[1]));
        }
        catch (RuntimeException ex) {
            throw new IllegalArgumentException("Incorrect type of data");
        }
        return result;
    }
}
