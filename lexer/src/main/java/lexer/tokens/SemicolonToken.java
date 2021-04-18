package lexer.tokens;

import java.util.regex.Pattern;
import lexer.TokenVisitor;

public class SemicolonToken extends Token {

  public SemicolonToken() {
    super(Pattern.compile(";", Pattern.MULTILINE));
  }

  public SemicolonToken(String value) {
    super(Pattern.compile(";", Pattern.MULTILINE), value);
  }

  @Override
  public Token withValue(String value) {
    return new SemicolonToken(value);
  }

  @Override
  public void accept(TokenVisitor visitor) {
    visitor.visit(this);
  }
}
