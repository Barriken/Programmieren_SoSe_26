package de.tha.prog2.container;

abstract public class AbstractContainer implements Container {
    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Container)) {
            return false;
        }
        Container c = (Container) obj;
        if(this.size() != c.size()) {
            return false;
        }
        for (int i = 0; i < this.size(); i++) {
            if(!this.get(i).equals(c.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < this.size(); i++) {
            str.append(this.get(i).toString());
            str.append("\n");
        }
        return str.toString();
    }
}
