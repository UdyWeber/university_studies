public class Circle extends Marker {
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        return obj.getClass().getName().equals(this.getClass().getName());
    }

    @Override
    public String toString() {
        return "()";
    }
}
