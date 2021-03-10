package com.efimchick.springtutorial.core.zz.lives.elections;

import java.util.List;

public class LoyalElectionPolicy implements ElectionPolicy{

    private Party party;

    public Party getParty() {
        return party;
    }

    public void setParty(final Party party) {
        this.party = party;
    }

    @Override
    public Candidate elect(final List<Candidate> candidates) {
        return candidates.stream()
                .filter(c -> c.party == party)
                .findFirst()
                .get();
    }
}
