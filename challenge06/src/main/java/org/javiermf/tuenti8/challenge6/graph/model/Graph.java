package org.javiermf.tuenti8.challenge6.graph.model;

import lombok.Getter;
import org.javiermf.tuenti8.challenge6.graph.Note;
import org.javiermf.tuenti8.challenge6.graph.UserState;

import java.util.*;

import static org.javiermf.tuenti8.challenge6.graph.UserState.PUSH;
import static org.javiermf.tuenti8.challenge6.graph.UserState.UP;

@Getter
public class Graph {

    Set<Node> nodes = new HashSet<>();
    Set<Transition> transitions = new HashSet<>();

    // Auxiliar indexes for performance
    Map<Integer, Node> nodeMap = new HashMap<>();
    Map<Integer, Set<Node>> nodeRoundMap = new HashMap<>();

    public int getMinIndex() {
        return nodes.stream()
                .mapToInt(Node::getRound)
                .sorted()
                .findFirst().getAsInt();
    }

    public List<Node> nodesFromRound(int fromRound) {
        List<Node> nodesFromRound = new ArrayList<>();
        for (Map.Entry<Integer, Set<Node>> nodeRoundsEntry : nodeRoundMap.entrySet()) {
            if (nodeRoundsEntry.getKey() > fromRound) {
                nodesFromRound.addAll(nodeRoundsEntry.getValue());
            }
        }

        return nodesFromRound;
    }

    public void addTransition(Note note) {
        addTransition(note.getHitStart(), note.getHitEnd(), note.getScore());
    }

    private void addTransition(int initRound, int endRound, int score) {
        Node sourceNode = findNode(initRound, PUSH);

        Optional<Transition> transitionToTarget = sourceNode.getTransitionToRound(endRound, UP);
        if (transitionToTarget.isPresent()) {
            transitionToTarget.get().addScore(score);
        } else {
            Node targetNode = findNode(endRound, UP);
            Transition transition = new Transition(targetNode, score);
            transitions.add(transition);
            sourceNode.addTransition(transition);
        }
    }

    private Node findNode(int round, UserState state) {
        Node nodeToFind = new Node(round, state);
        if (nodeMap.containsKey(nodeToFind.hashCode())) {
            return nodeMap.get(nodeToFind.hashCode());
        } else {
            return buildNode(round, state);
        }
    }


    private Node buildNode(int round, UserState state) {
        Node node = new Node(round, state);
        nodes.add(node);
        nodeMap.put(node.hashCode(), node);

        if (nodeRoundMap.containsKey(round)) {
            Set<Node> roundNodes = nodeRoundMap.get(round);
            roundNodes.add(node);
        } else {
            Set<Node> roundNodes = new HashSet<>();
            roundNodes.add(node);
            nodeRoundMap.put(round, roundNodes);
        }
        return node;
    }


}
