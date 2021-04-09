package lexer;

import lexer.tokens.*;

public interface TokenVisitor {
    void visit(AssignationToken token);
    void visit(BooleanTypeToken token);
    void visit(BooleanValueToken token);
    void visit(ClosingParenthesisToken token);
    void visit(DivisionToken token);
    void visit(EOFToken token);
    void visit(IdentifierToken token);
    void visit(LetToken token);
    void visit(MinusToken token);
    void visit(MultiplicationToken token);
    void visit(NumberValueToken token);
    void visit(NumberTypeToken token);
    void visit(OpenParenthesisToken token);
    void visit(PlusToken token);
    void visit(PrintToken token);
    void visit(SemicolonToken token);
    void visit(StringValueToken token);
    void visit(StringTypeToken token);
    void visit(TypeAssignationToken token);
    void visit(AndToken token);
    void visit(OrToken token);
    void visit(IfToken token);
    void visit(OpenBracketToken token);
    void visit(ClosingBracketToken token);

}
