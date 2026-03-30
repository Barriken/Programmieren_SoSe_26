package de.tha.prog2.test;

import de.tha.prog2.Container;
import de.tha.prog2.Vector;

class VectorTest extends ContainerBasicTest {

    @Override
    protected Container createContainer() {
        return new Vector();
    }
}