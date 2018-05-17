
package com.example.demo;

import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '('|| c == '[' || c =='{'){
                stack.push(c);
            }else{
                if (stack.isEmpty())
                    return false;
                char e = stack.pop();
                if(e =='(' && c != ')')
                    return false;
                if(e =='[' && c != ']')
                    return false;
                if(e =='{' && c != '}')
                    return false;
            }
        }
        return stack.isEmpty();
    }
}