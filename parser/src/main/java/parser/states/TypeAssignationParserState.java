package parser.states;

import common.exeptions.IllegalGrammarException;
import lexer.tokens.BooleanTypeToken;
import lexer.tokens.NumberTypeToken;
import lexer.tokens.StringTypeToken;
import lexer.tokens.TypeAssignationToken;
import parser.nodes.ASTNode;
import parser.nodes.ExpressionNode;

public class TypeAssignationParserState extends AbstractParserState {

    private String type;
    private ExpressionNode expressionNode;
    private boolean hasTypeAssignation;

    public TypeAssignationParserState() {
        this.hasTypeAssignation = false;
    }

    @Override
    public ASTNode getNode() {
        return this.expressionNode;
    }

    @Override
    public void visit(TypeAssignationToken token) {
        getTokenProvider().next();
        this.hasTypeAssignation = true;
        getTokenProvider().get().accept(this);
    }

    @Override
    public void visit(NumberTypeToken token) {
        this.parseType("number");
    }

    @Override
    public void visit(StringTypeToken token) {
        this.parseType("string");
    }

    @Override
    public void visit(BooleanTypeToken token) {
        this.parseType("boolean");
    }

    public void parseType(String type) {
        if (!hasTypeAssignation) {
            throw new IllegalGrammarException();
        }

        getTokenProvider().next();
        this.type = type;
        this.expressionNode = (ExpressionNode) new AssignationParserState().parse(getTokenProvider());
    }

    public String getType() {
        return this.type;
    }

}
