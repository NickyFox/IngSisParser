package lexer.tokenParserFactory;

import lexer.tokenParser.BaseTokenParser;
import lexer.tokenParser.TokenParser;
import lexer.tokenParser.TokenParserDecorator;
import lexer.tokenizer.Tokenizer;

import java.util.Stack;

public class TokenParserFactory {

    public static TokenParser buildTokens() {
        return buildTokensHelper(Tokenizer.getTokens(), new BaseTokenParser());
    }

    private static TokenParser buildTokensHelper(Stack<Tokenizer> tokenizers, TokenParser prevTokenParser) {
        if (tokenizers.isEmpty()) return prevTokenParser;
        TokenParser newTokenParser = new TokenParserDecorator(tokenizers.pop(), prevTokenParser);
        return buildTokensHelper(tokenizers, newTokenParser);
    }
}
