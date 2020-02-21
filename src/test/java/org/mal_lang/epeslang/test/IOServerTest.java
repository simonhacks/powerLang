package org.mal_lang.epeslang.test;

import core.Attacker;
import org.junit.jupiter.api.Test;

public class IOServerTest extends EpesLangTest {
    @Test
    public void testRestrictedOperationsNoDefense() {
        Attacker attacker = new Attacker();
        IOServer server = new IOServer(
                false, false,
                false, false,
                false, false,
                false
        );
        IcsNetwork network = new IcsNetwork(
                false, false,
                false, false,
                false
        );

        network.addApplications(server);

        attacker.addAttackPoint(server.externalRemoteService);
        attacker.addAttackPoint(network.access);
        attacker.attack();

        server.restrictedOperations.assertCompromisedInstantaneously();
    }

    @Test
    public void testAuthenticatedAccessNotReached() {
        Attacker attacker = new Attacker();
        IOServer server = new IOServer(
                false, false,
                false, false,
                false, false,
                false
        );

        attacker.attack();

        server.authenticatedAccess.assertUncompromised();
    }
}
