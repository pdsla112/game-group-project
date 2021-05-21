package comp2100.groupass.parser.elements;

public class IncorrectSentence extends Sentence {

    public Sentence s1;

    public IncorrectSentence(Sentence s1) {
        this.s1 = s1;
    }

    @Override
    public String show() {
        String rtn = "";
        if (s1 != null && s1 instanceof Unknown) {
            rtn += "Unexpected: " + s1.show();
        } else {
            rtn += "Incorrect sentence structure.";
        }
        rtn += "\nType \"h\" for a list of commands.\n";
        return rtn;

    }

}
