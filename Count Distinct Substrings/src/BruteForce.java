import java.util.HashSet;
import java.util.Set;

public class BruteForce {
    public static int countDistinctSubstrings(String s) {
        Set<String> st=new HashSet<>();
        for (int i=0;i<s.length();i++){
            String str="";
            for (int j=i;j<s.length();j++){
                str+=s.charAt(j);
            }
            st.add(str);
        }
        return st.size();
    }
    public static void main(String[] args) {
        String s="abc";
        System.out.println(countDistinctSubstrings(s));
    }
}
