package lexer.tokens;

import java.util.regex.Pattern;
import lexer.TokenVisitor;

public class MayorIgualComparisonToken extends Token {

  public MayorIgualComparisonToken() {
    super(Pattern.compile(">=", Pattern.MULTILINE));
  }

  public MayorIgualComparisonToken(String value) {
    super(Pattern.compile(">=", Pattern.MULTILINE), value);
  }

  @Override
  public Token withValue(String value) {
    return new MayorIgualComparisonToken(value);
  }

  @Override
  public void accept(TokenVisitor visitor) {
    visitor.visit(this);
  }
}
