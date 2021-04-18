package lexer;

import java.util.List;
import lexer.tokens.Token;

public interface Lexer {
  List<Token> lex(String str);
}
