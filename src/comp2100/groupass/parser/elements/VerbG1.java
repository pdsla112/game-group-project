package comp2100.groupass.parser.elements;

public class VerbG1 extends Sentence {

    public String word;

    public VerbG1(String word) {
        this.word = word;
    }

    @Override
    public String show() {
        return word;
    }

}
