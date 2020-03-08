package org.mal_lang.epeslang.test;

import core.Attacker;
import org.junit.jupiter.api.Test;

public class SISTest extends EpesLangTest {
    @Test
    public void testDenialOfServiceNoDefense() {
        Attacker attacker = new Attacker();
        SIS sis = new SIS(
                false, false,
                false, false,
                false, false,
                false, false,
                false, false,
                false, false
        );

        attacker.addAttackPoint(sis.access);
        attacker.attack();

        sis.denialOfService.assertCompromisedInstantaneously();
    }
}
