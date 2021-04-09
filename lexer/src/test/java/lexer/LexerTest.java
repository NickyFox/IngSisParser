package lexer;

import lexer.provider.TokenProvider;
import lexer.tokenizer.Tokenizer;
import lexer.tokenizer.state.InvalidState;
import lexer.tokenizer.state.TokenizerState;
import lexer.tokenizer.state.ValidState;
import lexer.tokens.Token;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class LexerTest {

    Lexer lexer = new DefaultLexer();
    String declaration = "let str: string = \"some string\";";
    List<Token> tokens = lexer.lex(declaration);

    @Test
    public void createLexer() {
        Lexer lexer = new DefaultLexer();
        assertNotNull(lexer);
    }

    @Test
    public void lex() {
        for (Token x : tokens) {
            System.out.println(x.getValue());
        }
        System.out.println(tokens);
        Assert.assertEquals(tokens.size(), 8);
    }

    @Test
    public void invalidStateToString() {
        System.out.println(tokens.get(0).toString());
        Assert.assertEquals(new InvalidState(tokens.get(0)).toString(), "InvalidState{token=let}");
    }

    @Test
    public void validStateToString() {
        TokenizerState state = new ValidState(tokens.get(0));
        Tokenizer tknzr = new Tokenizer(state);
        Assert.assertNotNull(tknzr.toString());
    }

    @Test
    public void lexerTokenProvider() {
        TokenProvider tp = new TokenProvider(tokens);
        Assert.assertTrue(tp.hasNext());
        Assert.assertEquals(tp.get(), tokens.get(0));
        tp.next();
        Assert.assertEquals(tp.get(), tokens.get(1));
    }

    @Test
    public void lexDifferentDeclarations() {
        String declaration1 = "let str: string = \"some string\";";
        List<Token> tokens1 = lexer.lex(declaration1);
        Assert.assertEquals(tokens1.size(), 8);

        String declaration2 = "let bool: boolean = true;";
        List<Token> tokens2 = lexer.lex(declaration2);
        Assert.assertEquals(tokens2.size(), 8);

        String declaration3 = "let bool: boolean = (2-2) != 0;";
        List<Token> tokens3 = lexer.lex(declaration3);
        Assert.assertEquals(tokens3.size(), 12);


        String declaration4 = "let str: string = \"some string\" + \"some string\";";
        List<Token> tokens4 = lexer.lex(declaration4);
        Assert.assertEquals(tokens4.size(), 10);

        String declaration5 = "let bool: boolean = true || true;";
        List<Token> tokens5 = lexer.lex(declaration5);
        Assert.assertEquals(tokens5.size(), 10);

        String declaration6 = "let bool: boolean = true && true;";
        List<Token> tokens6 = lexer.lex(declaration6);
        Assert.assertEquals(tokens6.size(), 10);

        String declaration7 = "let num: number = (1 * 2)/ 2;";
        List<Token> tokens7 = lexer.lex(declaration7);
        Assert.assertEquals(tokens7.size(), 14);

        String declaration8 = "if(true) {print(\"some string\");};";
        List<Token> tokens8 = lexer.lex(declaration8);
        List<Token> expectedResult = new ArrayList<>();
        Assert.assertEquals(tokens8.size(), 13);

    }
}
