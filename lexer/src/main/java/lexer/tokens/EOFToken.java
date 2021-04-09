package lexer.tokens;


import lexer.TokenVisitor;

import java.util.regex.Pattern;

public class EOFToken extends Token {

    public EOFToken() {
        super(Pattern.compile("EOF", Pattern.MULTILINE));
    }

    public EOFToken(String value) {
        super(Pattern.compile("EOF", Pattern.MULTILINE), value);
    }

    @Override
    public Token withValue(String value) {
        return new EOFToken(value);
    }

    @Override
    public void accept(TokenVisitor visitor) {
        visitor.visit(this);
    }
}
