package com.company.parser;

import com.company.parser.elements.*;

/**
 * for parsing tokens
 */
public class TokenParser {

    /*
    Production Rules:
   sentence = verbG1 objectG1 | verbG2 objectG2 | verbG3 objectG3 | verbG4 prepositionG1 objectG4
   verbG1 = "exit" | "save"
   verbG2 = "examine"
   verbG3 = "use"
   verbG4 = "look"
   prepositionG1 = "above" | "below" | "inside" (get options from levelnode)
   objectG1 = determinerG1 nounG1
   objectG2 = determinerG2 nounG2
   objectG3 = determinerG2 nounG3
   objectG4 = determinerG2 nounG4
   determinerG1 = "the"
   determinerG2 = "your"
   nounG1 = "game"
   nounG2 = "items" | "stats" | "surroundings"
   nounG3 = medkit (get items from player)
   nounG4 = furniture

   e.g. commands:
   exit the game
   save the game
   examine your surroundings
   examine your stats
   examine your items
   examine your medkit
   use your medkit
   look below the table

   */

    Tokenizer _tokenizer;

    public TokenParser(Tokenizer tokenizer) {
        _tokenizer = tokenizer;
    }

    /**
     * parse sentence using production rules above
     * @return
     */
    public Sentence parseSentence() {
        Token.Type verbType = _tokenizer.current().type();

        Sentence verb = parseVerb();

        if (_tokenizer.current() != null) {
            if (verbType == Token.Type.VERBG1) {
                Sentence object = parseObjectG1();
                if (object instanceof IncorrectSentence) {
                    return object;
                }
                if (object instanceof Unknown) {
                    return new IncorrectSentence(object);
                }
                return new SentenceG1(verb, object);
            }
            if (verbType == Token.Type.VERBG2) {
                Sentence object = parseObjectG2();
                if (object instanceof IncorrectSentence) {
                    return object;
                }
                if (object instanceof Unknown) {
                    return new IncorrectSentence(object);
                }
                return new SentenceG2(verb, object);
            }
            if (verbType == Token.Type.VERBG3) {
                Sentence object = parseObjectG3();
                if (object instanceof IncorrectSentence) {
                    return object;
                }
                if (object instanceof Unknown) {
                    return new IncorrectSentence(object);
                }
                return new SentenceG3(verb, object);
            }
            if (verbType == Token.Type.VERBG4) {
                Sentence preposition = parsePrepositionG1();
                if (preposition instanceof IncorrectSentence) {
                    return preposition;
                }
                if (preposition instanceof Unknown) {
                    return new IncorrectSentence(preposition);
                }
                Sentence object = parseObjectG4();
                if (object instanceof IncorrectSentence) {
                    return object;
                }
                if (object instanceof Unknown) {
                    return new IncorrectSentence(object);
                }
                return new SentenceG4(verb, preposition, object);
            }
        }
        return new IncorrectSentence(verb);
    }

    /**
     * parse verb
     * @return
     */
    public Sentence parseVerb() {
        if (_tokenizer.current() != null) {
            Token current = _tokenizer.current();
            if (_tokenizer.current().type() == Token.Type.VERBG1) {
                _tokenizer.next();
                return new VerbG1(current.token());
            }
            if (_tokenizer.current().type() == Token.Type.VERBG2) {
                _tokenizer.next();
                return new VerbG2(current.token());
            }
            if (_tokenizer.current().type() == Token.Type.VERBG3) {
                _tokenizer.next();
                return new VerbG3(current.token());
            }
            if (_tokenizer.current().type() == Token.Type.VERBG4) {
                _tokenizer.next();
                return new VerbG4(current.token());
            }
            return new Unknown(current.token());
        }
        return null;
    }

    /**
     * parse objectG1
     * @return
     */
    public Sentence parseObjectG1() {
        Sentence determiner = parseDeterminerG1();

        if (_tokenizer.current() != null) {
            if (determiner instanceof Unknown) {
                return new IncorrectSentence(determiner);
            }
            Sentence noun = parseNounG1();
            if (noun instanceof Unknown) {
                return noun;
            }
            return new ObjectG1(determiner, noun);
        }
        return new IncorrectSentence(determiner);

    }

    /**
     * parse objectG2
     * @return
     */
    public Sentence parseObjectG2() {
        Sentence determiner = parseDeterminerG2();

        if (_tokenizer.current() != null) {
            if (determiner instanceof Unknown) {
                return new IncorrectSentence(determiner);
            }
            Sentence noun = parseNounG2();
            if (noun instanceof Unknown) {
                return noun;
            }
            return new ObjectG2(determiner, noun);
        }
        return new IncorrectSentence(determiner);

    }

    /**
     * parse ObjectG3
     * @return
     */
    public Sentence parseObjectG3() {

        Sentence determiner = parseDeterminerG2();

        if (_tokenizer.current() != null) {
            if (determiner instanceof Unknown) {
                return new IncorrectSentence(determiner);
            }
            Sentence noun = parseNounG3();
            if (noun instanceof Unknown) {
                return noun;
            }
            return new ObjectG3(determiner, noun);
        }
        return new IncorrectSentence(determiner);

    }

    /**
     * parse ObjectG4
     * @return
     */
    public Sentence parseObjectG4() {
        Sentence determiner = parseDeterminerG1();

        if (_tokenizer.current() != null) {
            if (determiner instanceof Unknown) {
                return new IncorrectSentence(determiner);
            }
            Sentence noun = parseNounG4();
            if (noun instanceof Unknown) {
                return noun;
            }
            return new ObjectG4(determiner, noun);
        }
        return new IncorrectSentence(determiner);

    }

    public Sentence parseDeterminerG1() {
        if (_tokenizer.current() != null) {
            Token current = _tokenizer.current();
            if (current.type() == Token.Type.DETERMINERG1) {
                _tokenizer.next();
                return new DeterminerG1(current.token());
            }
            return new Unknown(current.token());

        }
        return new IncorrectSentence(new Unknown("Expecting determiner (G1)."));

    }
    public Sentence parseDeterminerG2() {
        if (_tokenizer.current() != null) {
            Token current = _tokenizer.current();
            if (current.type() == Token.Type.DETERMINERG2) {
                _tokenizer.next();
                return new DeterminerG2(current.token());
            }
            return new Unknown(current.token());

        }
        return new IncorrectSentence(new Unknown("Expecting determiner (G2)."));

    }

    public Sentence parseNounG1() {
        if (_tokenizer.current() != null) {
            Token current = _tokenizer.current();
            if (current.type() == Token.Type.NOUNG1) {
                _tokenizer.next();
                return new NounG1(current.token());
            }
            return new Unknown(current.token());
        }
        return new IncorrectSentence(new Unknown("Expecting noun (G1)."));

    }
    public Sentence parseNounG2() {
        if (_tokenizer.current() != null) {
            Token current = _tokenizer.current();
            if (current.type() == Token.Type.NOUNG2) {
                _tokenizer.next();
                return new NounG2(current.token());
            }
            return new Unknown(current.token());
        }
        return new IncorrectSentence(new Unknown("Expecting noun (G2)."));

    }

    public Sentence parseNounG3() {
        if (_tokenizer.current() != null) {
            Token current = _tokenizer.current();
            if (current.type() == Token.Type.NOUNG3) {
                _tokenizer.next();
                return new NounG3(current.token());
            }
            return new Unknown(current.token());
        }
        return new IncorrectSentence(new Unknown("Expecting noun (G3)."));

    }

    public Sentence parseNounG4() {
        if (_tokenizer.current() != null) {
            Token current = _tokenizer.current();
            if (current.type() == Token.Type.NOUNG4) {
                _tokenizer.next();
                return new NounG4(current.token());
            }
            return new Unknown(current.token());
        }
        return new IncorrectSentence(new Unknown("Expecting noun (G4)."));

    }


    public Sentence parsePrepositionG1() {
        if (_tokenizer.current() != null) {
            Token current = _tokenizer.current();
            if (current.type() == Token.Type.PREPOSITIONG1) {
                _tokenizer.next();
                return new PrepositionG1(current.token());
            }
        }
        return new IncorrectSentence(new Unknown("Expecting preposition (G1)."));

    }






}
