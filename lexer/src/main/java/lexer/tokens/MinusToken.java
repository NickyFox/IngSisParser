package lexer.tokens;

import java.util.regex.Pattern;
import lexer.TokenVisitor;

public class MinusToken extends Token {

  public MinusToken() {
    super(Pattern.compile("-", Pattern.MULTILINE));
  }

  public MinusToken(String value) {
    super(Pattern.compile("-", Pattern.MULTILINE), value);
  }

  @Override
  public Token withValue(String value) {
    return new MinusToken(value);
  }

  @Override
  public void accept(TokenVisitor visitor) {
    visitor.visit(this);
  }
}
