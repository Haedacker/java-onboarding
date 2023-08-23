package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        Map<String, String> m = new HashMap<>();
        for(int i=0; i<forms.size(); i++){
            String email = forms.get(i).get(0);
            String name = forms.get(i).get(1);
            for(int j=0; j<name.length()-1; j++){
                String cmp = "";
                cmp+=name.charAt(j);
                cmp+=name.charAt(j+1);
                if(m.containsKey(cmp)){
                    answer.add(email);
                    answer.add(m.get(cmp));
                }
                else{
                    m.put(cmp,email);
                }
            }
        }
        answer=answer.stream().distinct().collect(Collectors.toList());
        Collections.sort(answer);
        return answer;
    }
}
