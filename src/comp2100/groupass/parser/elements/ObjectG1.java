package comp2100.groupass.parser.elements;

public class ObjectG1 extends Sentence {

    public Sentence determinerG1;
    public Sentence nounG1;

    public ObjectG1(Sentence determinerG1, Sentence nounG1) {
        this.determinerG1 = determinerG1;
        this.nounG1 = nounG1;
    }

    @Override
    public String show() {
        return (determinerG1 == null ? "" : determinerG1.show() + " ") + nounG1.show();
    }

}
