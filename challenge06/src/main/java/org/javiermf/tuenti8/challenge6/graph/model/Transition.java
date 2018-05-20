package org.javiermf.tuenti8.challenge6.graph.model;

import org.javiermf.tuenti8.challenge6.graph.UserState;

import java.util.Objects;

public class Transition {

    private final Node targetNode;
    private int score;

    public Transition(Node targetNode, int score) {
        this.targetNode = targetNode;
        this.score = score;
    }

    public void addScore(int score) {
        this.score += score;
    }

    public boolean is(int round, UserState state) {
        return (targetNode.getRound() == round) && (targetNode.getUserState() == state);
    }

    public Node getTargetNode() {
        return targetNode;
    }

    public int getScore() {
        return score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if ((o == null) || (getClass() != o.getClass())) {
            return false;
        }
        Transition that = (Transition) o;
        return (score == that.score) &&
                Objects.equals(targetNode, that.targetNode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(targetNode, score);
    }
}
