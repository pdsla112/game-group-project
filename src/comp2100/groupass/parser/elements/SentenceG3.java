package comp2100.groupass.parser.elements;

public class SentenceG3 extends Sentence{

    public Sentence verbG3;
    public Sentence objectG3;

    public SentenceG3(Sentence verbG3, Sentence objectG3) {
        this.verbG3 = verbG3;
        this.objectG3 = objectG3;
    }

    @Override
    public String show() {
        return verbG3.show() + " " + objectG3.show();
    }

}
