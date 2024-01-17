class Node {
    Node[] link=new Node[26];
    boolean containsKey(char ch){
        return (link[ch-'a']!=null);
    }
    Node get(char ch){
        return link[ch-'a'];
    }
    void put(char ch,Node node){
        link[ch-'a']=node;
    }
}
public class Main {
    public static int countDistinctSubstrings(String s) {
        Node root=new Node();
        int n=s.length();
        int cnt=0;
        for (int i=0;i<n;i++){
            Node node=root;
            for (int j=i;j<n;j++){
                if (!node.containsKey(s.charAt(j))){
                    node.put(s.charAt(j),new Node());
                    cnt++;
                }
                node=node.get(s.charAt(j));
            }
        }
        return cnt+1;
    }
    public static void main(String[] args) {
        String s="abc";
        System.out.println(countDistinctSubstrings(s));
    }
}