package InterpreterPattern;

public class Main {
    public static void main(String[] args) {
        Expression ex_A = new TerminalExpression("A");
        Expression ex_B = new TerminalExpression("B");
        Expression orExpression = new OrExpression(ex_A, ex_B);

        Expression ex_C = new TerminalExpression("C");
        Expression ex_D = new TerminalExpression("D");
        Expression andExpression = new AndExpression(ex_C, ex_D);

        System.out.println(orExpression.interpreter("A"));
        System.out.println(orExpression.interpreter("B"));
        System.out.println(orExpression.interpreter("E"));

        System.out.println(andExpression.interpreter("D, C"));
        System.out.println(andExpression.interpreter("F, C"));
    }
}
