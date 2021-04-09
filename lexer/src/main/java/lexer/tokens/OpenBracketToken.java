package lexer.tokens;

import lexer.TokenVisitor;

import java.util.regex.Pattern;

public class OpenBracketToken extends Token {

    public OpenBracketToken() {
        super(Pattern.compile("\\{", Pattern.MULTILINE));
    }

    public OpenBracketToken(String value) {
        super(Pattern.compile("\\{", Pattern.MULTILINE), value);
    }

    @Override
    public Token withValue(String value) {
        return new OpenBracketToken(value);
    }

    @Override
    public void accept(TokenVisitor visitor) {
        visitor.visit(this);
    }
}
