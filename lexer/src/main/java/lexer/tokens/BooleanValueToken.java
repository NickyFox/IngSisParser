package lexer.tokens;



import lexer.TokenVisitor;

import java.util.regex.Pattern;

public class BooleanValueToken extends Token {
    public BooleanValueToken() {
        super(Pattern.compile("true|false", Pattern.MULTILINE));
    }

    public BooleanValueToken(String value) {
        super(Pattern.compile("true|false", Pattern.MULTILINE), value);
    }

    @Override
    public Token withValue(String value) {
        return new BooleanValueToken(value);
    }

    @Override
    public void accept(TokenVisitor visitor) {
        visitor.visit(this);
    }
}
