package org.javiermf.tuenti8.challenge6.graph;


import org.javiermf.tuenti8.challenge6.graph.model.Graph;
import org.javiermf.tuenti8.challenge6.graph.model.Node;
import org.javiermf.tuenti8.challenge6.graph.model.Transition;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toSet;

public class GraphScoreCalculator {

    private final Graph graph;
    private final int lastRound;

    public GraphScoreCalculator(Graph graph, int lastRound) {
        this.graph = graph;
        this.lastRound = lastRound;
    }

    public int maxScore() {
        completeGraph();

        Set<Node> nodesToEvaluate = new HashSet<>(getNodesWithoutIncommingTransitions());

        while (!nodesToEvaluate.isEmpty()) {

            nodesToEvaluate = nodesToEvaluate.stream()
                    .flatMap(node -> node.nextNodes().stream())
                    .collect(toSet());
        }

        return graph.getNodes().stream()
                .mapToInt(Node::getScore)
                .max().getAsInt();
    }

    private Collection<? extends Node> getNodesWithoutIncommingTransitions() {
        Set<Node> nodesWithIncomingTransitions = graph.getTransitions().stream()
                .map(Transition::getTargetNode)
                .collect(Collectors.toSet());

        return graph.getNodes().stream()
                .filter(n -> !nodesWithIncomingTransitions.contains(n))
                .collect(Collectors.toList());
    }

    // This could be improved a lot for performance
    private void completeGraph() {
        Map<Node, Transition> zeroTransitionsToNode = new HashMap();
        graph.getNodes().forEach(node ->
                zeroTransitionsToNode.put(node, new Transition(node, 0))
        );

        for (int i = 0; i < lastRound; i++) {
            for (Node node : getNodesForRound(i)) {

                int lastTransitionRound;
                if (node.hasTransitions()) {
                    lastTransitionRound = node.getLastTransitionRound();
                } else {
                    lastTransitionRound = i;
                }

                for (Node forwardNode : getNodesFromRound(lastTransitionRound)) {
                    node.addTransition(zeroTransitionsToNode.get(forwardNode));
                }
            }
        }
    }

    private List<Node> getNodesFromRound(int fromRound) {
        return graph.nodesFromRound(fromRound);
    }

    private List<Node> getNodesForRound(int round) {
        return graph.getNodes().stream()
                .filter(n -> n.getRound() == round)
                .collect(Collectors.toList());
    }
}
