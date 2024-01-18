import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Node {
    Node[] links = new Node[2];
    boolean containsKey(int ind) {
        return (links[ind] != null);
    }
    Node get(int ind) {
        return links[ind];
    }
    void put(int ind, Node node) {
        links[ind] = node;
    }
}
class Trie {
    Node root;
    Trie() {
        root = new Node();
    }
    void insert(int num) {
        Node node = root;
        for(int i = 31;i>=0;i--) {
            int bit = (num >> i) & 1;
            if(!node.containsKey(bit)) {
                node.put(bit, new Node());
            }
            node = node.get(bit);
        }
    }

    int getMax(int num) {
        Node node = root;
        int maxNum = 0;
        for(int i = 31;i>=0;i--) {
            int bit = (num >> i) & 1;
            if(node.containsKey(1 - bit)) {
                maxNum = maxNum | (1<<i);
                node = node.get( 1 - bit);
            }
            else {
                node = node.get(bit);
            }
        }
        return maxNum;
    }
}
public class Main {
    public static ArrayList<Integer> maxXorQueries(ArrayList<Integer> arr, ArrayList<ArrayList<Integer>> queries) {
        Collections.sort(arr);
        ArrayList<ArrayList<Integer>> offlineQueries = new ArrayList<>();
        int m = queries.size();
        for(int i = 0;i<m;i++) {
            ArrayList<Integer> temp = new ArrayList<Integer>();
            temp.add(queries.get(i).get(1));
            temp.add(queries.get(i).get(0));
            temp.add(i);
            offlineQueries.add(temp);
        }
        Collections.sort(offlineQueries, new Comparator<> () {
            @Override
            public int compare(ArrayList<Integer> a, ArrayList<Integer> b) {
                return a.get(0).compareTo(b.get(0));
            }
        });
        int ind = 0;
        int n = arr.size();
        Trie trie = new Trie();
        ArrayList<Integer> ans = new ArrayList<>(m);
        for(int i = 0;i<m;i++) ans.add(-1);
        for(int i = 0;i<m;i++) {
            while(ind<n && arr.get(ind) <= offlineQueries.get(i).get(0)) {
                trie.insert(arr.get(ind));
                ind++;
            }
            int queryInd = offlineQueries.get(i).get(2);
            if(ind!=0) ans.set(queryInd, trie.getMax(offlineQueries.get(i).get(1)));
            else ans.set(queryInd, -1);
        }
        return ans;
    }
    public static void main(String[] args) {
        ArrayList<Integer> arr=new ArrayList<>();
        arr.add(0);
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        ArrayList<ArrayList<Integer>> queries=new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(3);
        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(5);
        list2.add(6);
        queries.add(list1);
        queries.add(list2);
        ArrayList<Integer> ans=maxXorQueries(arr,queries);
        System.out.println(ans);
    }
}