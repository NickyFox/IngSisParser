package lexer.tokens;

import lexer.TokenVisitor;

import java.util.regex.Pattern;

public class TypeAssignationToken extends Token {

    public TypeAssignationToken() {
        super(Pattern.compile(":", Pattern.MULTILINE));
    }

    public TypeAssignationToken(String value) {
        super(Pattern.compile(":", Pattern.MULTILINE), value);
    }

    @Override
    public Token withValue(String value) {
        return new TypeAssignationToken(value);
    }

    @Override
    public void accept(TokenVisitor visitor) {
        visitor.visit(this);
    }

}
