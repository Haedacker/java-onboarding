package onboarding;

import java.util.List;

import static java.lang.Math.*;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        if(pobi.get(1)- pobi.get(0)!=1 || crong.get(1)- crong.get(0)!=1){
            answer=-1;
        }
        else{
            int Max_pobi = Integer.MIN_VALUE;
            int Max_crong = Integer.MIN_VALUE;
            int cmp_left, cmp_right, cmp_plus=0, cmp_mul=1;
            int tmp_left= pobi.get(0);
            int tmp_right= pobi.get(1);
            while(tmp_left>0){
                cmp_plus+=(tmp_left%10);
                cmp_mul*=(tmp_left%10);
                tmp_left/=10;
            }
            cmp_left= max(cmp_plus, cmp_mul);
            cmp_plus=0;
            cmp_mul=1;
            while(tmp_right>0){
                cmp_plus+=(tmp_right%10);
                cmp_mul*=(tmp_right%10);
                tmp_right/=10;
            }
            cmp_right= max(cmp_plus, cmp_mul);
            Max_pobi= max(cmp_left,cmp_right);

            cmp_plus=0; cmp_mul=1;
            tmp_left= crong.get(0);
            tmp_right= crong.get(1);
            while(tmp_left>0){
                cmp_plus+=(tmp_left%10);
                cmp_mul*=(tmp_left%10);
                tmp_left/=10;
            }
            cmp_left= max(cmp_plus, cmp_mul);
            cmp_plus=0;
            cmp_mul=1;
            while(tmp_right>0){
                cmp_plus+=(tmp_right%10);
                cmp_mul*=(tmp_right%10);
                tmp_right/=10;
            }
            cmp_right= max(cmp_plus, cmp_mul);
            Max_crong= max(cmp_left,cmp_right);

            if(Max_pobi>Max_crong){
                answer=1;
            }
            else if(Max_pobi<Max_crong){
                answer=2;
            }
            else{
                answer=0;
            }
        }
        return answer;
    }
}