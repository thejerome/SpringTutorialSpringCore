package com.efimchick.springtutorial.core.zz.lives.elections;

import java.util.List;

public interface ElectionPolicy {
    Candidate elect(List<Candidate> candidates);
}
