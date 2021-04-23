package com.company.parser;

import com.company.DeathException;
import com.company.characters.Player;

import java.util.Scanner;

public class Parser {
    public static String getInputString() {
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }

    public boolean parse(Player player, String userCommand) throws DeathException {
        return false;
    }
}
