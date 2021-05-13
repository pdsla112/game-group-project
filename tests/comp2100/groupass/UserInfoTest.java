package comp2100.groupass;

import org.junit.Rule;
import org.junit.rules.Timeout;
import org.junit.Test;

import java.util.Scanner;

public class UserInfoTest {
    @Rule
    public Timeout globalTimeout = Timeout.millis(1000);

    @Test
    String data = "Users Input" +
            "\nA second line of user input.";
    System.setIn(new ByteArrayInputStream(data.getBytes()));

    Scanner scanner = new Scanner(System.in);
    System.out.println("Line 1: " + scanner.nextLine());
    System.out.println("Line 2: " + scanner.nextLine());
}
