package parser.states;

import common.provider.Provider;
import lexer.tokens.VisitableToken;
import parser.nodes.ASTNode;

public interface ParserState {
    ASTNode parse(Provider<VisitableToken> input);
}
