package com.efimchick.springtutorial.core.zz.lives.elections;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Map;


public class Main {

    public static void main(String[] args) throws Exception {

        //Bean <- BeanDefinition
        //Context <- Configuration

        String state = args[0];

        final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Student.class, Group.class);

        final Student student = context.getBean(Student.class);
        System.out.println(student.getName());

        final Group group = context.getBean(Group.class);
        System.out.println(group.getName());
        System.out.println(group.getStudent().getName());

//
//
//        final List<Candidate> candidates = new ArrayList<>(context.getBeansOfType(Candidate.class).values());
//        final Map<?,?> bindings = context.getBean("bindings", Map.class);
//
//        Map<ElectionPolicy, List<String>> policies = new HashMap<>();
//        for (Object key : bindings.keySet()) {
//            policies.put(
//                    (ElectionPolicy) key,
//                    ((Set<?>) bindings.get(key)).stream().map(String.class::cast).collect(toList()));
//        }


//        businessCode(state, candidates, policies);

    }

    private static void businessCode(final String state,
                                     final List<Candidate> candidates,
                                     final Map<ElectionPolicy, List<String>> policies) {
        for (Map.Entry<ElectionPolicy, List<String>> entry : policies.entrySet()) {
            if (entry.getValue().contains(state)) {
                final Candidate winner = entry.getKey().elect(candidates);
                System.out.println(winner.name);
            }
        }
    }


}
