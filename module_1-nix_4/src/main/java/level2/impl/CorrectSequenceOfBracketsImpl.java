package level2.impl;

import level2.CorrectSequenceOfBrackets;

import java.util.LinkedList;

public class CorrectSequenceOfBracketsImpl implements CorrectSequenceOfBrackets {

    @Override
    public boolean isRightSequence(String s) {

        LinkedList stack = new LinkedList<Character>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            switch (ch) {
                case '(':
                    stack.push(')');
                    break;
                case '[':
                    stack.push(']');
                    break;
                case '{':
                    stack.push('}');
                    break;
                case ')':
                case ']':
                case '}':
                    if (stack.isEmpty()) {
                        return false;
                    }
                    char top = (char) stack.pop();
                    if (top != ch) {
                        return false;
                    }
            }
        }
        return stack.isEmpty();
    }

}



