package org.mal_lang.epeslang.test;

import core.Attacker;
import org.junit.jupiter.api.Test;

public class ControlServerTest extends EpesLangTest {
    @Test
    public void testAutomatedCollectionNoDefense() {
        Attacker attacker = new Attacker();
        ControlServer server = new ControlServer(
                false, false,
                false, false,
                false, false,
                false, false,
                false, false,
                false, false,
                false, false
        );

        attacker.addAttackPoint(server.access);
        attacker.addAttackPoint(server.credentials);
        attacker.attack();

        server.automatedCollection.assertCompromisedInstantaneously();
    }
}
