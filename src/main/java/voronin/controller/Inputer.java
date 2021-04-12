package voronin.controller;

import java.util.Scanner;

public class Inputer {

    private final Scanner scanner = new Scanner(System.in);

    public String getUserInput() {
        return scanner.nextLine();
    }
}
