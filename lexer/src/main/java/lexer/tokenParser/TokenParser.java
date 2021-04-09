package lexer.tokenParser;

import lexer.tokens.Token;

public interface TokenParser {
    public Token getToken(String str);
}
