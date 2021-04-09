package lexer.tokens;

import lexer.TokenVisitor;

import java.util.regex.Pattern;

public class IfToken extends Token {
    public IfToken() {
        super(Pattern.compile("if", Pattern.MULTILINE));
    }

    public IfToken(String value) {
        super(Pattern.compile("if", Pattern.MULTILINE), value);
    }

    @Override
    public Token withValue(String value) {
        return new IfToken(value);
    }

    @Override
    public void accept(TokenVisitor visitor) {
        visitor.visit(this);
    }
}
