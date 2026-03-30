package de.tha.prog2.performance;

import de.tha.prog2.Container;
import de.tha.prog2.List;
import de.tha.prog2.OptimizedList;
import de.tha.prog2.OptimizedVector;
import de.tha.prog2.Vector;

public class ContainerPerformance {

    public static final int OPERATIONS = 25_000;

    private static void doTestAndMeasure(String message, Runnable runnable) {
        long startTime = System.currentTimeMillis();
        runnable.run();
        long endTime = System.currentTimeMillis();

        System.out.printf("%40s - Duration: %10d ms%n", message, endTime - startTime);
    }

    private static void testOperations(Container container) {
        Runnable add = () -> {
            for (int i = 0; i < OPERATIONS; i++) {
                container.add(i);
            }
        };

        Runnable remove = () -> {
            for (int i = 0; i < OPERATIONS; i++) {
                container.remove(i);
            }
        };

        doTestAndMeasure("Adding elements to container", add);
        doTestAndMeasure("Get size of container", container::size);
        doTestAndMeasure("Removing elements from container", remove);
        doTestAndMeasure("Adding elements to container", add);
        doTestAndMeasure("Clearing elements from container", container::clear);
    }

    private static void runTest(String name, Container container) {
        System.out.println();
        System.out.println("Testing " + name + ":");
        System.out.println("-".repeat(("Testing " + name + ":").length()));
        testOperations(container);
    }

    public static void main(String[] args) {
        runTest("Vector", new Vector());
        runTest("List", new List());
        runTest("OptimizedVector", new OptimizedVector());
        runTest("OptimizedList", new OptimizedList());
    }
}