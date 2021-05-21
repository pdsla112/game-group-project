package comp2100.groupass.parser.elements;

public class ObjectG4 extends Sentence {

    public Sentence determinerG2;
    public Sentence nounG4;

    public ObjectG4(Sentence determinerG2, Sentence nounG4) {
        this.determinerG2 = determinerG2;
        this.nounG4 = nounG4;
    }

    @Override
    public String show() {
        return (determinerG2 == null ? "" : determinerG2.show() + " ") + nounG4.show();
    }

}
