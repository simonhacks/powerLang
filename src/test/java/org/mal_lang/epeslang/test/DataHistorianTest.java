package org.mal_lang.epeslang.test;

import core.Attacker;
import org.junit.jupiter.api.Test;

public class DataHistorianTest extends EpesLangTest {
    @Test
    public void testAutomatedCollectionNoDefense() {
        Attacker attacker = new Attacker();
        DataHistorian historian = new DataHistorian(
                false, false,
                false, false,
                false, false,
                false, false
        );

        attacker.addAttackPoint(historian.access);
        attacker.addAttackPoint(historian.credentials);
        attacker.attack();

        historian.remoteSystemDiscovery.assertCompromisedInstantaneously();
    }
}
