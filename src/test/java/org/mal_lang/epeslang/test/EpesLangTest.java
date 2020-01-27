package org.mal_lang.epeslang.test;

import core.Asset;
import core.AttackStep;
import core.Defense;
import org.junit.jupiter.api.AfterEach;

import static org.junit.jupiter.api.Assertions.assertTrue;

public abstract class EpesLangTest {
    private static boolean isReached(AttackStep attackStep) {
        return attackStep.ttc < Double.MAX_VALUE;
    }

    private static boolean isNotReached(AttackStep attackStep) {
        return attackStep.ttc == Double.MAX_VALUE;
    }

    public static void assertReached(AttackStep attackStep) {
        assertTrue(
                isReached(attackStep),
                String.format("Attack step %s was not reached", attackStep.fullName()));
    }

    public static void assertNotReached(AttackStep attackStep) {
        assertTrue(
                isNotReached(attackStep),
                String.format("Attack step %s was reached", attackStep.fullName()));
    }

    @AfterEach
    public void deleteModel() {
        Asset.allAssets.clear();
        AttackStep.allAttackSteps.clear();
        Defense.allDefenses.clear();
    }
}
