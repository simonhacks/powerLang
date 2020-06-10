package org.mal_lang.epeslang.test;

import core.Attacker;
import org.junit.jupiter.api.Test;

public class FirewallTest extends EpesLangTest {
    @Test
    public void testCommonlyUsedPortWithAssetNotReached() {
        Attacker attacker = new Attacker();

        Firewall firewall = new Firewall(
                false, false,
                false, false,
                false, false,
                false, false,
                false
        );

        IcsNetwork network = new IcsNetwork(
                false, false,
                false, false,
                false, false
        );

        HMI hmi = new HMI(
                false, false,
                false, false,
                false, false,
                false, false,
                false
        );

        network.addApplications(hmi);
        network.addApplications(firewall);

        attacker.attack();

        firewall.bypassFirewall.assertUncompromised();
    }
}
