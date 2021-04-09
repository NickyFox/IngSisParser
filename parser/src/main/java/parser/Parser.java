package parser;

import common.provider.Provider;
import lexer.tokens.VisitableToken;
import parser.nodes.ASTNode;
import parser.states.ParserState;
import parser.states.ProgramParserState;

public class Parser implements ParserState {

    private ParserState state;

    public Parser() {
        this.state = new ProgramParserState();
    }

    @Override
    public ASTNode parse(Provider<VisitableToken> input) {
        return this.state.parse(input);
    }

}
