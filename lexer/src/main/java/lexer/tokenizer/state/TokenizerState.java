package lexer.tokenizer.state;

import lexer.tokenizer.ITokenizer;

public interface TokenizerState extends ITokenizer {
    boolean isValid();
    TokenizerState change(String str);
}
