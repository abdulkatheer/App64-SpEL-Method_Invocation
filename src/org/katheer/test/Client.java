package org.katheer.test;

import org.katheer.bean.Calculator;
import org.katheer.bean.MyString;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.lang.reflect.Method;

public class Client {
    public static void main(String[] args) throws Exception {
        //Accessing static method
        System.out.println("Accessing Static Methods");
        System.out.println("------------------------");
        StandardEvaluationContext context = new StandardEvaluationContext();
        ExpressionParser parser = new SpelExpressionParser();

        //1. Getting method object
        Class calculatorClass = Calculator.class;
        Method add = calculatorClass.getDeclaredMethod("add",
                new Class[] {int.class, int.class});
        Method sub = calculatorClass.getDeclaredMethod("sub",
                new Class[] {int.class, int.class});
        Method mul = calculatorClass.getDeclaredMethod("mul",
                new Class[] {int.class, int.class});
        Method div = calculatorClass.getDeclaredMethod("div",
                new Class[] {int.class, int.class});
        Method mod = calculatorClass.getDeclaredMethod("mod",
                new Class[] {int.class, int.class});
        Method pow = calculatorClass.getDeclaredMethod("pow",
                new Class[] {int.class, int.class});
        Method sqrt = calculatorClass.getDeclaredMethod("sqrt",
                new Class[] {int.class});

        //2. Registering method with a logical name in context
        context.registerFunction("add", add);
        context.registerFunction("sub", sub);
        context.registerFunction("mul", mul);
        context.registerFunction("divide", div);
        context.registerFunction("modulo", mod);
        context.registerFunction("pow", pow);
        context.registerFunction("sqrt", sqrt);

        //3. Creating variables for parameters in context
        context.setVariable("num1", 23);
        context.setVariable("num2", 12);

        //4. Invoking method from context
        System.out.println("Add     : " + parser.parseExpression(
                "#add(#num1, #num2)").getValue(context));
        System.out.println("Sub     : " + parser.parseExpression(
                "#sub(#num1, #num2)").getValue(context));
        System.out.println("Mul     : " + parser.parseExpression(
                "#mul(#num1, #num2)").getValue(context));
        System.out.println("Div     : " + parser.parseExpression(
                "#divide(#num1, #num2)").getValue(context));
        System.out.println("Mod     : " + parser.parseExpression(
                "#modulo(#num1, #num2)").getValue(context));
        System.out.println("Pow     : " + parser.parseExpression(
                "#pow(#num1, #num2)").getValue(context));
        System.out.println("Sqrt    : " + parser.parseExpression(
                "#sqrt(#num1)").getValue(context));
        System.out.println();

        //Accessing instance methods
        System.out.println("Accessing Instance Methods");
        System.out.println("--------------------------");
        MyString string = new MyString("Ultron Tech Pvt Ltd");
        StandardEvaluationContext stringContext =
                new StandardEvaluationContext(string);
        System.out.println(parser.parseExpression("reverseString()").getValue(stringContext));

        /*
        Only static methods can be registered and accessed via context
        Instance methods can be accessed only by above approach.
        The following approach will raise an RT Exception

        Class stringClass = MyString.class;
        Method reverse = stringClass.getDeclaredMethod("reverseString");
        stringContext.registerFunction("reverse", reverse);
        System.out.println(parser.parseExpression("#reverse()").getValue(stringContext));
        */
    }
}
