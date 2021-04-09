package lexer.tokens;


import lexer.TokenVisitor;

import java.util.regex.Pattern;

public class BooleanTypeToken extends Token {
    public BooleanTypeToken() {
        super(Pattern.compile("boolean", Pattern.MULTILINE));
    }

    public BooleanTypeToken(String value) {
        super(Pattern.compile("boolean", Pattern.MULTILINE), value);
    }

    @Override
    public Token withValue(String value) {
        return new BooleanTypeToken(value);
    }

    @Override
    public void accept(TokenVisitor visitor) {
        visitor.visit(this);
    }
}
