package comp2100.groupass.parser.elements;

public class NounG4 extends Sentence {

    public String word;

    public NounG4(String word) {
        this.word = word;
    }

    @Override
    public String show() {
        return word;
    }

}
