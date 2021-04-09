package parser.states;

import lexer.tokens.AssignationToken;
import parser.nodes.ASTNode;
import parser.nodes.ExpressionNode;

public class AssignationParserState extends AbstractParserState {

    private ExpressionNode expressionNode;

    @Override
    public ASTNode getNode() {
        return this.expressionNode;
    }

    @Override
    public void visit(AssignationToken token) {
        getTokenProvider().next();
        this.expressionNode = (ExpressionNode) new ExpressionParserState().parse(getTokenProvider());
    }
}
