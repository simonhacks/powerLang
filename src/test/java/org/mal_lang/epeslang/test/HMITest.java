package org.mal_lang.epeslang.test;

import core.Attacker;
import org.junit.jupiter.api.Test;

public class HMITest extends EpesLangTest {
    @Test
    public void testGuiCollectionNoDefense() {
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

    @Test
    public void testAccessNotReached() {
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

        attacker.attack();

        hmi.access.assertUncompromised();
    }

    @Test
    public void testRogueMasterDeviceNotReached() {
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

        attacker.attack();

        hmi.rogueMasterDevice.assertUncompromised();
    }

    @Test
    public void testValidAccountsNotReached() {
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

        attacker.attack();

        IcsNetwork network = new IcsNetwork(false, false,
                false, false,
                false);

        network.addApplications(hmi);

        hmi.validAccounts.assertUncompromised();
    }

    @Test
    public void testAccessWithNetworkNotReached() {
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

        attacker.attack();

        IcsNetwork network = new IcsNetwork(false, false,
                false, false,
                false);

        network.addApplications(hmi);

        hmi.access.assertUncompromised();
    }
}
