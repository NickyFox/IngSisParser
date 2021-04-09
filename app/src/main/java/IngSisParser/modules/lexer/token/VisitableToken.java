package IngSisParser.modules.lexer.token;

public interface VisitableToken {
    void accept(TokenVisitor visitor);
}
