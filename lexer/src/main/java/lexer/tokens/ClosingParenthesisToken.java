package lexer.tokens;

import java.util.regex.Pattern;
import lexer.TokenVisitor;

public class ClosingParenthesisToken extends Token {

  public ClosingParenthesisToken() {
    super(Pattern.compile("\\)", Pattern.MULTILINE));
  }

  public ClosingParenthesisToken(String value) {
    super(Pattern.compile("\\)", Pattern.MULTILINE), value);
  }

  @Override
  public Token withValue(String value) {
    return new ClosingParenthesisToken(value);
  }

  @Override
  public void accept(TokenVisitor visitor) {
    visitor.visit(this);
  }
}
