package com.efimchick.springtutorial.core.zz.lives.elections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Configuration
public class ElectionConfig {

    @Bean
    @Scope("prototype")
    public Candidate biden() {
        return new Candidate("Biden", Party.DEM);
    }

    @Bean
    public Candidate trump() {
        return new Candidate("Trump", Party.RES);
    }

    @Bean
    public Candidate kanye() {
        return new Candidate("Kanye West", null);
    }

    @Bean
    public Candidate ross() {
        return new Candidate("Ross Perro", null);
    }

    @Bean
    public ElectionPolicy loyalDemPolicy() {
        final LoyalElectionPolicy loyalElectionPolicy = new LoyalElectionPolicy();
        loyalElectionPolicy.setParty(Party.DEM);
        return loyalElectionPolicy;
    }

    @Bean
    public ElectionPolicy loyalResPolicy() {
        final LoyalElectionPolicy loyalElectionPolicy = new LoyalElectionPolicy();
        loyalElectionPolicy.setParty(Party.RES);
        return loyalElectionPolicy;
    }

    @Bean
    public ElectionPolicy notSoLoyalResPolicy() {
        return new NotSoLoyalElectionPolicy(Party.RES, 0.7);
    }

    @Bean
    public ElectionPolicy resNoTrumpPolicy(final ElectionPolicy loyalResPolicy,
                                           final ElectionPolicy loyalDemPolicy,
                                           final Candidate trump) {
        return new NotThisOneElectionPolicy(
                loyalResPolicy,
                loyalDemPolicy,
                trump
        );
    }

    @Bean
    public Map<ElectionPolicy, Set<String>> bindings(final ElectionPolicy loyalResPolicy,
                                                     final ElectionPolicy loyalDemPolicy,
                                                     final ElectionPolicy notSoLoyalResPolicy,
                                                     final ElectionPolicy resNoTrumpPolicy) {
        return new HashMap<ElectionPolicy, Set<String>>(){
            {
                put(loyalDemPolicy, new HashSet<>(Arrays.asList("CA", "CN", "OR")));
                put(loyalResPolicy, new HashSet<>(Arrays.asList("TX", "WM", "CL")));
                put(notSoLoyalResPolicy, new HashSet<>(Arrays.asList("FL")));
                put(resNoTrumpPolicy, new HashSet<>(Arrays.asList("OH")));
            }
        };

    }


}
