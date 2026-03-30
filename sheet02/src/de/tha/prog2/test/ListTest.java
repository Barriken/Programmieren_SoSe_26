package de.tha.prog2.test;

import de.tha.prog2.Container;
import de.tha.prog2.List;

class ListTest extends ContainerBasicTest{

    @Override
    protected Container createContainer() {
        return new List();
    }
}