package parser.nodes;


import parser.ASTVisitor;

public interface ASTNode {
    void accept(ASTVisitor visitor);
}
