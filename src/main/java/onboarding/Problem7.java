package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>(Collections.emptyList());
        Map<String, Integer> mapping = new HashMap<>();
        List<List<String>> cmp=new ArrayList<>();
        int e = -500000;
        int limit = -300000;
        mapping.put(user,e);
        for(int i=0; i<friends.size(); i++){
            String A = friends.get(i).get(0);
            String B = friends.get(i).get(1);

            if(A.equals(user)){
                mapping.put(B,e);
                continue;
            }
            if(B.equals(user)){
                mapping.put(A,e);
                continue;
            }
            cmp.add(friends.get(i));
        }
        for(int i=0; i<cmp.size(); i++){
            String A = cmp.get(i).get(0);
            String B = cmp.get(i).get(1);
            boolean A_flag = mapping.containsKey(A);
            boolean B_flag = mapping.containsKey(B);

            if(A_flag&&B_flag){
                int A_score = mapping.get(A);
                int B_score = mapping.get(B);
                if(A_score<limit&&B_score>limit){
                    mapping.replace(B,B_score+10);
                }
                else if(B_score<limit&&A_score>limit){
                    mapping.replace(A,A_score+10);
                }
            }
            else if(A_flag){
                int A_score = mapping.get(A);
                if(A_score<limit){
                    mapping.put(B,10);
                }
            }
            else if(B_flag){
                int B_score = mapping.get(B);
                if(B_score<limit){
                    mapping.put(A,10);
                }
            }
            else{
                mapping.put(A,0);
                mapping.put(B,0);
            }
        }
        for(int i=0; i<visitors.size(); i++){
            String name = visitors.get(i);
            if(mapping.containsKey(name)){
                mapping.replace(name,mapping.get(name)+1);
            }
            else{
                mapping.put(name,1);
            }
        }
        List<Map.Entry<String, Integer>> entryList = getEntries(mapping);
        List<String> support = new ArrayList<>();
        int tmp = entryList.get(0).getValue();
        for(Map.Entry<String, Integer> entry : entryList){
            int value = entry.getValue();
            if(tmp>0){
                if(value==tmp){
                    support.add(entry.getKey());
                }
                else{
                    Collections.sort(support);
                    answer.addAll(support);
                    support.clear();
                    support.add(entry.getKey());
                    tmp=value;
                }
            }
            else{
                break;
            }
        }

        return answer;
    }

    private static List<Map.Entry<String, Integer>> getEntries(Map<String, Integer> mapping) {
        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(mapping.entrySet());
        entryList.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        return entryList;
    }
}
