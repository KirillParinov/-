public class Main {
    public static void main(String[] args) {
        System.out.println(Calcul.ExpressiontoRPN("(2+2)*2"));
        System.out.println(Calcul.RPNtoAnswer(Calcul.ExpressiontoRPN("(2+2)*2")));
    }
}