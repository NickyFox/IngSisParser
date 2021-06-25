package lexer.tokens;

import java.util.regex.Pattern;
import lexer.TokenVisitor;

public class PrintToken extends Token {

  public PrintToken() {
    super(Pattern.compile("println", Pattern.MULTILINE));
  }

  public PrintToken(String value) {
    super(Pattern.compile("println", Pattern.MULTILINE), value);
  }

  @Override
  public Token withValue(String value) {
    return new PrintToken(value);
  }

  @Override
  public void accept(TokenVisitor visitor) {
    visitor.visit(this);
  }
}
