package com.didi.pk.learn.alg.algs4th.ch01;

import com.didi.pk.learn.alg.algs4th.StdOut;

/**
 * @author pengkai
 * @date 2019-08-10
 */
public class Evaluate {
    public static void evaluate(String str) {
        Stack<String> ops = new BasicStack<>();
        Stack<Double> vals = new BasicStack<>();

        String[] tokens = str.split(" ");
        for (String token : tokens) {
            if (token.equals("(")) ;
            else if ("+-*/sqrt".contains(token)) {
                ops.push(token);
            } else if (token.equals(")")) {
                String op = ops.pop();
                double v = vals.pop();
                switch (op) {
                    case "+":
                        v = vals.pop() + v;
                        break;
                    case "-":
                        v = vals.pop() - v;
                        break;
                    case "*":
                        v = vals.pop() * v;
                        break;
                    case "/":
                        v = vals.pop() / v;
                    case "sqrt":
                        v = Math.sqrt(v);
                }
                vals.push(v);
            } else {
                vals.push(Double.parseDouble(token));
            }
        }
        StdOut.println(vals.pop());
    }

    public static void main(String[] args) {
        evaluate("( 1 + 2 )");
    }
}
