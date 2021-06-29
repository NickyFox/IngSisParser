package parser.states;

import common.exeptions.IllegalGrammarException;
import java.util.List;
import lexer.tokens.*;
import parser.nodes.*;

public class ProgramParserState extends AbstractParserState {

  private ProgramNode programNode;

  public ProgramParserState() {
    this.programNode = new ProgramNode();
  }

  @Override
  public ASTNode getNode() {
    return this.programNode;
  }

  @Override
  public void visit(EOFToken token) {}

  @Override
  public void visit(IdentifierToken token) {
    getTokenProvider().next();

    programNode.add(
        new AssigmentNode(
            new IdentifierNode(token.getValue()),
            (ExpressionNode) new AssignationParserState().parse(getTokenProvider())));

    getTokenProvider().get().accept(this);
  }

  @Override
  public void visit(LetToken token) {
    getTokenProvider().next();
    programNode.add(new DeclarationParserState(false).parse(getTokenProvider()));
    getTokenProvider().get().accept(this);
  }

  @Override
  public void visit(ConstToken token) {
    getTokenProvider().next();
    programNode.add(new DeclarationParserState(true).parse(getTokenProvider()));
    getTokenProvider().get().accept(this);
  }

  @Override
  public void visit(PrintToken token) {
    getTokenProvider().next();
    programNode.add(new PrintParserState().parse(getTokenProvider()));
    getTokenProvider().get().accept(this);
  }

  @Override
  public void visit(IfToken token) {
    getTokenProvider().next();
    programNode.add(new IfElseParserState().parse(getTokenProvider()));
    getTokenProvider().get().accept(this);
  }

  @Override
  public void visit(ElseToken token) {
    getTokenProvider().next();

    List<ASTNode> nodes = programNode.getNodes();
    ASTNode ifNode = nodes.get(nodes.size() - 1);

    if (!(ifNode instanceof IfNode)) {
      throw new IllegalGrammarException("No if statement");
    }

    ((IfNode) ifNode)
        .setElseNode(((IfNode) new IfElseParserState().parse(getTokenProvider())).getProgram());

    getTokenProvider().get().accept(this);
  }

  @Override
  public void visit(SemicolonToken token) {
    getTokenProvider().next();
    getTokenProvider().get().accept(this);
  }
}
