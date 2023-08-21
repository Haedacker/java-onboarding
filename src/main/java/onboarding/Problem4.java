package onboarding;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder answer = new StringBuilder();
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            int ascii = (int)ch;
            if(65<=ascii && ascii<=90){
                if(ascii<=77){
                    ascii=((78-ascii)+77);
                }
                else{
                    ascii=(78-(ascii-77));
                }
                answer.append((char) ascii);
            }
            else if(97<=ascii && ascii<=122){
                if(ascii<=109){
                    ascii=((110-ascii)+109);
                }
                else{
                    ascii=(110-(ascii-109));
                }
                answer.append((char) ascii);
            }
            else{
                answer.append(ch);
            }
        }

        return answer.toString();
    }
}
