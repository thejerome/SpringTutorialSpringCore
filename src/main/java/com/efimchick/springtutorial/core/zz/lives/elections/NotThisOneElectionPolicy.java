package com.efimchick.springtutorial.core.zz.lives.elections;

import java.util.List;

public class NotThisOneElectionPolicy implements ElectionPolicy {

    private final ElectionPolicy defaultPolicy;
    private final ElectionPolicy fallbackPolicy;
    private final Candidate banned;

    public NotThisOneElectionPolicy(final ElectionPolicy defaultPolicy,
                                    final ElectionPolicy fallbackPolicy,
                                    final Candidate banned) {
        this.defaultPolicy = defaultPolicy;
        this.fallbackPolicy = fallbackPolicy;
        this.banned = banned;
    }

    @Override
    public Candidate elect(final List<Candidate> candidates) {
        Candidate proposed = defaultPolicy.elect(candidates);
        return proposed.equals(banned) ? fallbackPolicy.elect(candidates) : proposed;
    }
}
