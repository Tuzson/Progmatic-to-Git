package com.company;

import java.util.Stack;

public class Queue {
    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();



    public Stack<Integer> getStack1() {
        return stack1;
    }

    public void setStack1(Stack<Integer> stack1) {
        this.stack1 = stack1;
    }

    public Stack<Integer> getStack2() {
        return stack2;
    }

    public void setStack2(Stack<Integer> stack2) {
        this.stack2 = stack2;
    }

    public Stack<Integer> add(Integer whichStack, Integer nrToAdd) {
        if (whichStack == 1) {
            stack1.push(nrToAdd);
            return stack1;
        }
        if (whichStack == 2) {
            stack2.push(nrToAdd);
        }
        return stack2;
    }

    public Stack<Integer> poll(Integer whichStack) {
        if (whichStack == 1) {
            stack1.pop();
            return stack1;
        }
        if (whichStack == 2) {
            stack2.pop();
        }
        return stack2;
    }

    public Integer peek(Integer whichStack) {
        if (whichStack == 1) {
            return stack1.peek();
        }
        if (whichStack == 2) {
            return stack2.peek();
        }
        return -1;

    }

    public Integer size(Integer whichStack) {
        if (whichStack == 1) {
            return stack1.size();
        }
        if (whichStack == 2) {
            return stack2.size();
        }
        return -1;

    }

    @Override
    public String toString() {
        return "Queue{" +
                "stack1=" + stack1 +
                ", stack2=" + stack2 +
                '}';
    }
}