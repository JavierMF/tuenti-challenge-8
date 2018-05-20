package org.javiermf.tuenti8.challenge6.graph.model;


import lombok.Getter;
import lombok.Setter;
import org.javiermf.tuenti8.challenge6.graph.UserState;

import java.util.*;

import static java.util.Comparator.reverseOrder;

@Getter
@Setter
public class Node {

    private final int round;
    private final UserState userState;
    int hasCode;
    List<Transition> transitions = new ArrayList();
    private int score = 0;

    public Node(int round, UserState userState) {
        this.round = round;
        this.userState = userState;
        hasCode = Objects.hash(round, userState);
    }

    public void addTransition(Transition transition) {
        transitions.add(transition);
    }

    public Optional<Transition> getTransitionToRound(int round, UserState state) {
        return getTransitions().stream()
                .filter(tr -> tr.is(round, state))
                .findFirst();
    }

    public Set<Node> nextNodes() {
        Set<Node> nextNodes = new HashSet();
        for (Transition transition : transitions) {
            int newTargeNodeScore = score + transition.getScore();
            Node targetNode = transition.getTargetNode();
            if (newTargeNodeScore >= targetNode.getScore()) {
                targetNode.setScore(newTargeNodeScore);
                nextNodes.add(targetNode);
            }
        }

        return nextNodes;
    }

    public int getLastTransitionRound() {
        return transitions.stream()
                .map(t -> t.getTargetNode().getRound()).min(reverseOrder()).get();
    }

    public boolean hasTransitions() {
        return !transitions.isEmpty();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if ((o == null) || (getClass() != o.getClass())) {
            return false;
        }
        Node node = (Node) o;
        return (round == node.round) &&
                (userState == node.userState);
    }

    @Override
    public int hashCode() {
        return hasCode;
    }

    @Override
    public String toString() {
        return "Transition[ round=" + round + ", score=" + score + " userState=" + userState + "]";
    }

}
