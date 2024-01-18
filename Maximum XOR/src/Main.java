import java.util.ArrayList;
class Node {
    Node[] links=new Node[2];
    boolean containsKey(int ind){
        return (links[ind]!=null);
    }
    Node get(int ind){
        return links[ind];
    }
    void put(int ind,Node node){
        links[ind]=node;
    }
}
class Trie {
    Node root;
    Trie() {
        root=new Node();
    }
    void insert(int n){
        Node node=root;
        for (int i=31;i>=0;i--){
            int bit=(n>>i)&1;
            if (!node.containsKey(bit)) node.put(bit,new Node());
            node=node.get(bit);
        }
    }
    int getMax(int n){
        Node node=root;
        int maxNum=0;
        for (int i=31;i>=0;i--){
            int bit=(n>>i)&1;
            if (node.containsKey(1-bit)) {
                maxNum =maxNum | (1<<i);
                node=node.get(1-bit);
            }
            else node=node.get(bit);
        }
        return maxNum;
    }
}
public class Main {
    public static int maxXOR(int n, int m, ArrayList<Integer> arr1, ArrayList<Integer> arr2) {
        Trie trie = new Trie();
        for (int i=0;i<n;i++) trie.insert(arr1.get(i));
        int max=0;
        for (int i=0;i<m;i++) max=Math.max(max, trie.getMax(arr2.get(i)));
        return max;
    }
    public static void main(String[] args) {
        int n=7,m=7;
        ArrayList<Integer> arr1=new ArrayList<>();
        arr1.add(6);
        arr1.add(6);
        arr1.add(0);
        arr1.add(6);
        arr1.add(8);
        arr1.add(5);
        arr1.add(6);
        ArrayList<Integer> arr2=new ArrayList<>();
        arr2.add(1);
        arr2.add(7);
        arr2.add(1);
        arr2.add(7);
        arr2.add(8);
        arr2.add(0);
        arr2.add(2);
        System.out.println(maxXOR(n,m,arr1,arr2));
    }
}