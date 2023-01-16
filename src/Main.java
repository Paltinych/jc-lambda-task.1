import java.util.function.*;

public class Main {
    public static void main(String[] args) {
        Calculator calc = Calculator.instance.get();

        int a = calc.plus.apply(1, 2);
        int b = calc.minus.apply(1, 1); // здесь получаем b = 0
        int c = calc.devide.apply(a, b);

        calc.println.accept(c);
    }
}

class Calculator {
    static Supplier<Calculator> instance = Calculator::new;

    BinaryOperator<Integer> plus = (x, y) -> x + y;
    BinaryOperator<Integer> minus = (x, y) -> x - y;
    BinaryOperator<Integer> multiply = (x, y) -> x * y;
//    BinaryOperator<Integer> devide = (x, y) -> x / y;  // т.к. b = 0 получаем ошибку, поскольку на 0 делить нельзя

    BinaryOperator<Integer> devide = (x, y) -> y != 0 ? x / y : y;

/*  полноценный многострочный блок кода
    BinaryOperator<Integer> devide = new BinaryOperator<Integer>() {
    @Override
    public Integer apply(Integer x, Integer y) {
        if (y != 0) {
            return x / y;
        } else {
            return y;
        }
    }
};*/

    UnaryOperator<Integer> pow = x -> x * x;
    UnaryOperator<Integer> abs = x -> x > 0 ? x : x * -1;

    Predicate<Integer> isPositive = x -> x > 0;

    Consumer<Integer> println = System.out::println;
}