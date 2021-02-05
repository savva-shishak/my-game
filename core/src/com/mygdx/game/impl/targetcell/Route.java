package com.mygdx.game.impl.targetcell;

import volnovoialgoritm.Point;

import java.util.ArrayList;

public class Route {
    public ArrayList<Point> path = new ArrayList<>();
    public ArrayList<Point> completed = new ArrayList<>();
    public final TargetCell targetCell;

    public Route(TargetCell targetCell) {
        this.targetCell = targetCell;
    }
}
