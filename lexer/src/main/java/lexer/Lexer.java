package lexer;

import lexer.tokens.Token;

import java.util.List;

public interface Lexer {
    List<Token> lex(String str);
}
