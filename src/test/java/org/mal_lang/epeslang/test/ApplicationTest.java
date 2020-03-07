package org.mal_lang.epeslang.test;

import core.Attacker;
import org.junit.jupiter.api.Test;

public class ApplicationTest extends EpesLangTest {
    @Test
    public void testPhishing() {
        Attacker attacker = new Attacker();
        User user = new User();
        Identity identity = new Identity();
        Credentials credentials = new Credentials();
        Application application = new Application();

        user.addUserIds(identity);
        identity.addCredentials(credentials);
        identity.addExecPrivApps(application);

        attacker.addAttackPoint(user.attemptSocialEngineering);

        //application.codeExecution.assertCompromisedWithEffort();
    }

}
