package org.mal_lang.epeslang.test;

import core.Attacker;
import org.junit.jupiter.api.Test;

public class ControllerTest extends EpesLangTest {
    @Test
    public void testAutomatedCollectionNoDefense() {
        Attacker attacker = new Attacker();
        Controller controller = new Controller(
                false, false,
                false, false,
                false, false,
                false, false,
                false, false,
                false, false,
                false, false,
                false, false
        );

        attacker.addAttackPoint(controller.access);
        attacker.addAttackPoint(controller.credentials);
        attacker.attack();

        controller.automatedCollection.assertCompromisedInstantaneously();
    }
}
