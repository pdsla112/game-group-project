package comp2100.groupass;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import com.company.GameMap;

public class GameMapTest {
    @Rule
    public Timeout globalTimeout = Timeout.millis(1000);
}
