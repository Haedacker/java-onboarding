package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for(int i=1; i<=number; i++){
            int num=i;
            while(num>0){
                int cmp = num%10;
                if(cmp%3==0 && cmp!=0){
                    answer++;
                }
                num/=10;
            }
        }
        return answer;
    }
}
