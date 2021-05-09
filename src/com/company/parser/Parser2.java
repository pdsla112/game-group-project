package com.company.parser;

public class Parser2 {

    Tokenizer _tokenizer;

    public Parser2(Tokenizer tokenizer) {
        _tokenizer = tokenizer;
    }

    public Exp parseExp() {
        Exp command = parseCommand();

        if (_tokenizer.current() != null) {

        }
        return command;
    }

    public Exp parseCommand() {
        Exp subject = parseSubject();
        if (_tokenizer.current() != null) {
            Token.Type command = _tokenizer.current().type();
            if (command == Token.Type.USE) {
                if (_tokenizer.hasNext()) {
                    _tokenizer.next();
                    return new UseExp(parseSubject());

                }
            }
        }
        return subject;
    }

    public Exp parseSubject() {
        Token current = _tokenizer.current();
        if (current.type() == Token.Type.EXIT) {
            _tokenizer.next();
            return new ExitExp();
        }
        if (current.type() == Token.Type.ITEM) {
            _tokenizer.next();
            return new ItemExp(Integer.parseInt(current.token()));
        }
        if (current.type() == Token.Type.HELP) {
            _tokenizer.next();
            return new HelpExp();
        }

        return new UnknownExp();
    }
}
