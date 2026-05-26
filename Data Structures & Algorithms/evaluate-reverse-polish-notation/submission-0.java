class Solution {
    public int calculate(int a, int b, String op) {
        switch(op) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                return a / b;
            default:
                return 0;
        }
    }


    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();
        List<String> operands = List.of("+", "-", "*", "/");

        for(String token : tokens) {
            if(operands.contains(token)) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(calculate(a, b, token));
            } else {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }
}
