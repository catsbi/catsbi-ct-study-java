package catsbi.me.algorithm.mst;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PrimTest {
    private ArrayList<Prim.Edge> myedges;

    @BeforeEach
    void setUp() {
        myedges = new ArrayList<>();
        myedges.add(new Prim.Edge(7, "A", "B"));
        myedges.add(new Prim.Edge(5, "A", "D"));
        myedges.add(new Prim.Edge(8, "B", "C"));
        myedges.add(new Prim.Edge(9, "B", "D"));
        myedges.add(new Prim.Edge(7, "D", "E"));
        myedges.add(new Prim.Edge(5, "C", "E"));
        myedges.add(new Prim.Edge(7, "B", "E"));
        myedges.add(new Prim.Edge(6, "D", "F"));
        myedges.add(new Prim.Edge(8, "E", "F"));
        myedges.add(new Prim.Edge(9, "E", "G"));
        myedges.add(new Prim.Edge(11, "F", "G"));
    }


    @Test
    void primTest() {
        final Prim prim = new Prim();
        final List<Prim.Edge> result = prim.primFunc("A", myedges);

        System.out.println("result = " + result);
    }

}
