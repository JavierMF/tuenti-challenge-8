package org.javiermf.tuenti8.challenge6.graph;


import org.javiermf.tuenti8.challenge6.graph.model.Graph;

import java.util.*;
import java.util.stream.Collectors;

public class Case {

    Set<Note> notes = new HashSet<>();

    public void addNote(int initPos, int length, int speed, int score) {
        notes.add(new Note(initPos, length, speed, score));
    }

    public int maxScore() {
        Integer lastRound = notes.stream()
                .map(Note::getHitEnd).min(Comparator.reverseOrder()).get();

        Graph graph = new Graph();

        notes.forEach(graph::addTransition);

        return new GraphScoreCalculator(graph, lastRound).maxScore();
    }

    public void addNote(String noteLine) {
        List<Integer> val = Arrays.stream(noteLine.split(" "))
                .map(Integer::valueOf)
                .collect(Collectors.toList());
        addNote(val.get(0), val.get(1), val.get(2), val.get(3));
    }

    public Set<Note> getNotes() {
        return notes;
    }
}
