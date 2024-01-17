public class Main {
    static class Node{
        Node[] link=new Node[26];
        boolean flag=false;
        boolean containsKey(char ch){
            return (link[ch-'a']!=null);
        }
        Node get(char ch){
            return link[ch-'a'];
        }
        void put(char ch,Node node){
            link[ch-'a']=node;
        }
        void setEnd(){
            flag=true;
        }
        boolean isEnd(){
            return flag;
        }
    }
    public static class Trie {
        public Node root;
        public Trie() {
            root=new Node();
        }
        public void insert(String word) {
            Node node=root;
            for (int i=0;i<word.length();i++){
                if (!node.containsKey(word.charAt(i))) node.put(word.charAt(i),new Node());
                node=node.get(word.charAt(i));
            }
            node.setEnd();
        }
        public boolean search(String word) {
            Node node=root;
            for (int i=0;i<word.length();i++){
                if (!node.containsKey(word.charAt(i))) return false;
                node=node.get(word.charAt(i));
            }
            return node.isEnd();
        }
        public boolean startsWith(String prefix) {
            Node node=root;
            for (int i=0;i<prefix.length();i++){
                if (!node.containsKey(prefix.charAt(i))) return false;
                node=node.get(prefix.charAt(i));
            }
            return true;
        }
    }
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));   // return True
        System.out.println(trie.search("app"));     // return False
        System.out.println(trie.startsWith("app")); // return True
        trie.insert("app");
        System.out.println(trie.search("app"));
    }
}