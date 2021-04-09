package IngSisParser.modules.lexer.token;

import java.util.regex.Pattern;

public class OrToken extends Token {
    public OrToken() {
        super(Pattern.compile("\\|\\|", Pattern.MULTILINE));
    }

    public OrToken(String value) {
        super(Pattern.compile("\\|\\|", Pattern.MULTILINE), value);
    }

    @Override
    public Token withValue(String value) {
        return new OrToken(value);
    }

    @Override
    public void accept(TokenVisitor visitor) {
        visitor.visit(this);
    }
}
