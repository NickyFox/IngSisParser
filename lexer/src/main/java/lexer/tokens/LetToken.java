package lexer.tokens;

import lexer.TokenVisitor;

import java.util.regex.Pattern;

public class LetToken extends Token {

    public LetToken() {
        super(Pattern.compile("let", Pattern.MULTILINE));
    }

    public LetToken(String value) {
        super(Pattern.compile("let", Pattern.MULTILINE), value);
    }

    @Override
    public Token withValue(String value) {
        return new LetToken(value);
    }

    @Override
    public void accept(TokenVisitor visitor) {
        visitor.visit(this);
    }

}
