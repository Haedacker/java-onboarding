package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";
        Stack<Character> s = new Stack<>();
        Stack<Character> tmp = new Stack<>();
        for(int i=0; i<cryptogram.length(); i++){
            char cmp = cryptogram.charAt(i);
            if(s.empty()){
                s.push(cmp);
                continue;
            }
            char ch = s.peek();
            if(ch==cmp){
                s.pop();
            }
            else{
                s.push(cmp);
            }
        }
        while(!s.empty()){
            tmp.push(s.pop());
        }
        StringBuilder str = new StringBuilder();
        while(!tmp.empty()){
            str.append(tmp.pop());
        }
        answer= str.toString();
        return answer;
    }
}
