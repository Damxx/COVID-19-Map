package com.example.demo;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DataRepo {

    private List<Point> pointList;

    public List<Point> getPointList() {
        return pointList;
    }

    public void addPoint(Point newPoint) {
        this.pointList.add(newPoint);
    }

    public DataRepo() {
        this.pointList = new ArrayList<>();
    }
}
