package com.efimchick.springtutorial.core.zz.lives.elections;

import java.util.List;
import java.util.Random;

public class NotSoLoyalElectionPolicy implements ElectionPolicy {

    private final Party party;
    private final double loyalty;
    private final Random random = new Random();

    public NotSoLoyalElectionPolicy(final Party party, final double loyalty) {
        this.party = party;
        this.loyalty = loyalty;
    }

    @Override
    public Candidate elect(final List<Candidate> candidates) {

        if (random.nextDouble() < loyalty) {
            return candidates.stream()
                    .filter(c -> c.party == party)
                    .findFirst()
                    .get();
        }

        return candidates.stream()
                .filter(c -> c.party != null)
                .findFirst()
                .get();

    }
}
