package lexer.tokens;

import java.util.regex.Pattern;
import lexer.TokenVisitor;

public class OpenBracketToken extends Token {

  public OpenBracketToken() {
    super(Pattern.compile("\\{", Pattern.MULTILINE));
  }

  public OpenBracketToken(String value) {
    super(Pattern.compile("\\{", Pattern.MULTILINE), value);
  }

  @Override
  public Token withValue(String value) {
    return new OpenBracketToken(value);
  }

  @Override
  public void accept(TokenVisitor visitor) {
    visitor.visit(this);
  }
}
