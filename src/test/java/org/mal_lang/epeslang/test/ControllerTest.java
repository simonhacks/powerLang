package org.mal_lang.epeslang.test;

import core.Attacker;
import org.junit.jupiter.api.Test;

public class ControllerTest extends EpesLangTest {
    @Test
    public void testAuthenticatedAccessNotReached() {
        Attacker attacker = new Attacker();
        Controller controller = new Controller(
                false, false,
                false, false,
                false, false,
                false, false,
                false, false,
                false, false
        );

        attacker.attack();

        controller.authenticatedAccess.assertUncompromised();
    }
}
