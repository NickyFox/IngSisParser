package lexer.tokens;


import lexer.TokenVisitor;

import java.util.regex.Pattern;

public class PlusToken extends Token {

    public PlusToken() {
        super(Pattern.compile("\\+", Pattern.MULTILINE));
    }

    public PlusToken(String value) {
        super(Pattern.compile("\\+", Pattern.MULTILINE), value);
    }

    @Override
    public Token withValue(String value) {
        return new PlusToken(value);
    }

    @Override
    public void accept(TokenVisitor visitor) {
        visitor.visit(this);
    }

}
