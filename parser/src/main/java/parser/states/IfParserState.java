package parser.states;

import lexer.tokens.OpenBracketToken;
import lexer.tokens.OpenParenthesisToken;
import parser.nodes.ASTNode;
import parser.nodes.ExpressionNode;
import parser.nodes.IfNode;
import parser.nodes.ProgramNode;

public class IfParserState extends AbstractParserState {

    private IfNode ifNode;

    public IfParserState() {
        this.ifNode = new IfNode();
    }

    @Override
    public ASTNode getNode() {
        return this.ifNode;
    }

    @Override
    public void visit(OpenParenthesisToken token) {
        getTokenProvider().next();
        this.ifNode.setCondition((ExpressionNode) new OpenParenthesisParserState().parse(getTokenProvider()));
        getTokenProvider().get().accept(this);
    }

    @Override
    public void visit(OpenBracketToken token) {
        getTokenProvider().next();
        this.ifNode.setProgram((ProgramNode) new OpenBracketParserState().parse(getTokenProvider()));
    }
}
