package org.mal_lang.epeslang.test;

import core.Attacker;
import org.junit.jupiter.api.Test;

public class EngineeringWorkstationTest extends EpesLangTest {
    @Test
    public void testScriptingNoDefense() {
        Attacker attacker = new Attacker();
        EngineeringWorkstation workstation = new EngineeringWorkstation(
                false, false,
                false, false,
                false, false,
                false, false,
                false
        );

        attacker.addAttackPoint(workstation.access);
        attacker.attack();

        workstation.scripting.assertCompromisedInstantaneously();
    }
}
