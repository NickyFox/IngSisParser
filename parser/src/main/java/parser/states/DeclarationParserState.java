package parser.states;

import lexer.tokens.IdentifierToken;
import parser.nodes.ASTNode;
import parser.nodes.DeclarationNode;
import parser.nodes.ExpressionNode;
import parser.nodes.IdentifierNode;


public class DeclarationParserState extends AbstractParserState {

    private DeclarationNode declarationNode;

    @Override
    public ASTNode getNode() {
        return this.declarationNode;
    }

    @Override
    public void visit(IdentifierToken token) {
        getTokenProvider().next();
        TypeAssignationParserState state = new TypeAssignationParserState();
        ExpressionNode type = (ExpressionNode) state.parse(getTokenProvider());

        this.declarationNode = new DeclarationNode(
                new IdentifierNode(token.getValue()),
                state.getType(),
                type);
    }
}
