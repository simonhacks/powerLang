package org.mal_lang.epeslang.test;

import core.Attacker;
import org.junit.jupiter.api.Test;

public class ControlServerTest extends EpesLangTest {
    @Test
    public void testAccessNotReached() {
        Attacker attacker = new Attacker();
        ControlServer server = new ControlServer(
                false, false,
                false, false,
                false, false,
                false, false,
                false, false,
                false
        );

        attacker.attack();

        server.access.assertUncompromised();
    }

    @Test
    public void testDataDestructionNotDefended() {
        Attacker attacker = new Attacker();
        ControlServer server = new ControlServer(
                false, false,
                false, false,
                false, false,
                false, false,
                false, false,
                false
        );

        AntiVirus av = new AntiVirus(false);

        av.addObserved(server);

        attacker.addAttackPoint(server.access);
        attacker.addAttackPoint(server.credentials);
        attacker.attack();

        server.dataDestruction.assertCompromisedInstantaneously();
    }

    @Test
    public void testDataDestructionDefended() {
        Attacker attacker = new Attacker();
        ControlServer server = new ControlServer(
                false, false,
                false, false,
                false, false,
                false, false,
                false, false,
                false
        );

        AntiVirus av = new AntiVirus(true);

        av.addObserved(server);

        attacker.addAttackPoint(server.access);
        attacker.addAttackPoint(server.credentials);
        attacker.attack();

        //Assert Bernoulli distribution?
        //server.dataDestruction.assertCompromisedWithEffort();
    }

    @Test
    public void testValidAccountsNotDefended() {
        Attacker attacker = new Attacker();
        ControlServer server = new ControlServer(
                false, false,
                false, false,
                false, false,
                false, false,
                false, false,
                false
        );

        AntiVirus av = new AntiVirus(false);
        av.addObserved(server);

        IcsNetwork network = new IcsNetwork(
                false, false,
                false, false,
                false);

        network.addApplications(server);

        attacker.addAttackPoint(server.access);
        attacker.addAttackPoint(server.credentials);
        attacker.attack();

        server.authentication.assertCompromisedInstantaneously();
    }

    @Test
    public void testSpoofingMessageNoDefense() {
        Attacker attacker = new Attacker();
        ControlServer server = new ControlServer(
                false, false,
                false, false,
                false, false,
                false, false,
                false, false,
                false
        );

        attacker.attack();

        server.spoofReportingMessageDefended.assertUncompromised();
    }

    @Test
    public void testSpoofingMessageWithNetworkNoDefense() {
        Attacker attacker = new Attacker();
        ControlServer server = new ControlServer(
                false, false,
                false, false,
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
        attacker.attack();

        server.spoofReportingMessageDefended.assertUncompromised();
    }
}
