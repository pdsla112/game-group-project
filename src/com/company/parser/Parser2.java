package com.company.parser;


/*
   sentence = verb [preposition] object
   verb = "get" | "use" | "look" | "examine" | "exit" | "save" | "talk"
   preposition = "for" | "to"
   object = ["the"] [adjective] noun
   adjective = "your"
   noun = "items" | "game" | "help" | "stats" | "you"

   synonyms:
   verb:
   exit - quit, leave
   look - glance
   examine - check, inspect, get
   use -
   save -
   talk - speak

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
   nounG3 = item name e.g. medkit
   nounG4 = furniture


   e.g.
   exit the game
   save the game
   examine your surroundings
   examine your stats
   examine your items
   examine your medkit
   use your medkit
   look below the table


   */

public class Parser2 {

    Tokenizer _tokenizer;


    public Parser2(Tokenizer tokenizer) {
        _tokenizer = tokenizer;
    }

    public Sentence parseSentence() {
        Token.Type verbType = _tokenizer.current().type();
        Sentence verb = parseVerb();

        if (_tokenizer.current() != null) {
            if (verbType == Token.Type.VERBG1) {
                return new SentenceG1(verb, parseObject());
            }
            if (verbType == Token.Type.VERBG2) {
                return new SentenceG2(verb, parseObject());
            }
            if (verbType == Token.Type.VERBG3) {
                return new SentenceG3(verb, parseObject());
            }
            if (verbType == Token.Type.VERBG4) {
                return new SentenceG4(verb, parsePreposition(), parseObject());
            }
        }
        return new UnknownSentence();
    }

    public Sentence parseVerb() {
        if (_tokenizer.current() != null) {
            if (_tokenizer.current().type() == Token.Type.VERBG1) {
                _tokenizer.next();
                return new VerbG1(_tokenizer.current().token());
            }
            if (_tokenizer.current().type() == Token.Type.VERBG2) {
                _tokenizer.next();
                return new VerbG2(_tokenizer.current().token());
            }
            if (_tokenizer.current().type() == Token.Type.VERBG3) {
                _tokenizer.next();
                return new VerbG3(_tokenizer.current().token());
            }
            if (_tokenizer.current().type() == Token.Type.VERBG4) {
                _tokenizer.next();
                return new VerbG4(_tokenizer.current().token());
            }
        }
        return new UnknownSentence();
    }

    public Sentence parseObject() {
        Token.Type determinerType = _tokenizer.current().type();
        Sentence determiner = parseDeterminer();

        if (_tokenizer.current() != null) {
            Token.Type nounType = _tokenizer.current().type();
            Sentence noun = parseNoun();

            if (determinerType == Token.Type.DETERMINERG1) {
                if (nounType == Token.Type.NOUNG1) {
                    return new ObjectG1(determiner, noun);
                }
            }
            if (determinerType == Token.Type.DETERMINERG2) {
                if (nounType == Token.Type.NOUNG2) {
                    return new ObjectG2(determiner, noun);
                }
                if (nounType == Token.Type.NOUNG3) {
                    return new ObjectG3(determiner, noun);
                }
                if (nounType == Token.Type.NOUNG4) {
                    return new ObjectG4(determiner, noun);
                }
            }
        }
        return new UnknownSentence();

    }

    public Sentence parseDeterminer() {
        if (_tokenizer.current() != null) {
            if (_tokenizer.current().type() == Token.Type.DETERMINERG1) {
                _tokenizer.next();
                return new DeterminerG1(_tokenizer.current().token());
            }
            if (_tokenizer.current().type() == Token.Type.DETERMINERG2) {
                _tokenizer.next();
                return new DeterminerG2(_tokenizer.current().token());
            }

        }
        return new UnknownSentence();

    }

    public Sentence parseNoun() {
        if (_tokenizer.current() != null) {
            if (_tokenizer.current().type() == Token.Type.NOUNG1) {
                _tokenizer.next();
                return new NounG1(_tokenizer.current().token());
            }
            if (_tokenizer.current().type() == Token.Type.NOUNG2) {
                _tokenizer.next();
                return new NounG2(_tokenizer.current().token());
            }
            if (_tokenizer.current().type() == Token.Type.NOUNG3) {
                _tokenizer.next();
                return new NounG3(_tokenizer.current().token());
            }
            if (_tokenizer.current().type() == Token.Type.NOUNG4) {
                _tokenizer.next();
                return new NounG4(_tokenizer.current().token());
            }
        }
        return new UnknownSentence();

    }

    public Sentence parsePreposition() {
        if (_tokenizer.current() != null) {
            if (_tokenizer.current().type() == Token.Type.PREPOSITIONG1) {
                _tokenizer.next();
                return new PrepositionG1(_tokenizer.current().token());
            }
        }
        return new UnknownSentence();

    }




}
