package comp2100.groupass.parser.elements;

public class Unknown extends Sentence {

    private String word;

    public Unknown(String word) {
        this.word = word;
    }

    @Override
    public String show() {
        return word;
    }

}
