package IngSisParser.modules.lexer.token;


import java.util.regex.Pattern;

public class AndToken extends Token {
    public AndToken() {
        super(Pattern.compile("&&", Pattern.MULTILINE));
    }

    public AndToken(String value) {
        super(Pattern.compile("&&", Pattern.MULTILINE), value);
    }

    @Override
    public Token withValue(String value) {
        return new AndToken(value);
    }

    @Override
    public void accept(TokenVisitor visitor) {
        visitor.visit(this);
    }
}
