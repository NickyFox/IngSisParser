package lexer.tokens;


import lexer.TokenVisitor;

import java.util.regex.Pattern;

public class ClosingBracketToken extends Token {

    public ClosingBracketToken() {
        super(Pattern.compile("}", Pattern.MULTILINE));
    }

    public ClosingBracketToken(String value) {
        super(Pattern.compile("}", Pattern.MULTILINE), value);
    }

    @Override
    public Token withValue(String value) {
        return new ClosingBracketToken(value);
    }

    @Override
    public void accept(TokenVisitor visitor) {
        visitor.visit(this);
    }
}
