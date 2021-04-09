package parser;

import parser.nodes.*;

public interface ASTVisitor {
    void visit(ProgramNode node);
    void visit(AssigmentNode node);
    void visit(AdditionNode node);
    void visit(SubtractionNode node);
    void visit(DivisionNode node);
    void visit(MultiplicationNode node);
    void visit(StringNode node);
    void visit(IntegerNode node);
    void visit(IdentifierNode node);
    void visit(ExpressionNode node);
    void visit(DeclarationNode node);
    void visit(PrintNode node);
    void visit(BooleanNode node);
    void visit(AndNode node);
    void visit(OrNode node);
    void visit(IfNode node);
}
