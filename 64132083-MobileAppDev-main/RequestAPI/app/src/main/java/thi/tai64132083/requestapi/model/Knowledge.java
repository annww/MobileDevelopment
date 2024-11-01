package thi.tai64132083.requestapi.model;

public class Knowledge {
    private String fact;
    private int length;

    public Knowledge(String fact, int length) {
        this.fact = fact;
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getFact() {
        return fact;
    }

    public void setFact(String fact) {
        this.fact = fact;
    }
}
