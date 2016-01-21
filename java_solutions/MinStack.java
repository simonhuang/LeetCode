package leetCode;

import java.util.Stack;

public class MinStack {
	Stack <Integer> main_stack;
	Stack <Integer> min_stack;

	public MinStack(){
		main_stack = new Stack<Integer>();
		min_stack = new Stack<Integer>();
	}
	
	public void push(int x) {
		main_stack.push(x);
		if (min_stack.isEmpty()){
			min_stack.push(x);
		} else if (x <= min_stack.peek()){
			min_stack.push(x);
		}
    }

    public void pop() {
    	int popped = main_stack.pop();
    	if (popped == min_stack.peek()){
    		min_stack.pop();
    	}
    }

    public int top() {
    	return main_stack.peek();
    }

    public int getMin() {
    	return min_stack.peek();
    }
}
