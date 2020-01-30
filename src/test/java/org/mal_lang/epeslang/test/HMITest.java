package org.mal_lang.epeslang.test;

import core.Attacker;
import org.junit.jupiter.api.Test;

public class HMITest extends EpesLangTest {
    @Test
    public void testAutomatedCollectionNoDefense() {
        Attacker attacker = new Attacker();
        HMI hmi = new HMI(
                false, false,
                false, false,
                false, false,
                false, false,
                false, false,
                false, false,
                false, false
        );

        attacker.addAttackPoint(hmi.graphicalUserInterface);
        attacker.attack();

        hmi.pointAndTackIdentification.assertCompromisedInstantaneously();
    }
}
