package lexer.tokens;

import java.util.regex.Pattern;
import lexer.TokenVisitor;

public class ElseToken extends Token {
  public ElseToken() {
    super(Pattern.compile("else", Pattern.MULTILINE));
  }

  public ElseToken(String value) {
    super(Pattern.compile("else", Pattern.MULTILINE), value);
  }

  @Override
  public Token withValue(String value) {
    return new ElseToken(value);
  }

  @Override
  public void accept(TokenVisitor visitor) {
    visitor.visit(this);
  }
}
