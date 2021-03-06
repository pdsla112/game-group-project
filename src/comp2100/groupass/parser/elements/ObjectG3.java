package comp2100.groupass.parser.elements;

public class ObjectG3 extends Sentence {

    public Sentence determinerG2;
    public Sentence nounG3;

    public ObjectG3(Sentence determinerG2, Sentence nounG3) {
        this.determinerG2 = determinerG2;
        this.nounG3 = nounG3;
    }

    @Override
    public String show() {
        return (determinerG2 == null ? "" : determinerG2.show() + " ") + nounG3.show();
    }

}
