package leetCode;
import java.util.*;
public class WordDictionary {
	class Node{
		char c;
		boolean end;
		List<Node> children;
		public Node(char c){
			this.c = c;
			children = new ArrayList<Node>();
			end = false;
		}
		public void insert(String s){
			if (s.length() == 0){
				return;
			}
			char c = s.charAt(0);
			for (Node n : children){
				if (n.c == c){
					n.insert(s.substring(1));
					if (s.length() == 1){
						n.end = true;
					}
					return;
				}
			}
			Node n = new Node(c);
			children.add(n);
			if (s.length() == 1){
				n.end = true;
			}
			n.insert(s.substring(1));
		}
		public boolean search(String s){
			if (s.length() == 0 && children.size() == 0){
				return true;
			} if (s.length() == 0){
				return false;
			}
			char c = s.charAt(0);
			if (this.c == c || c == '.'){
				if (s.length() == 1){
					return end;
				} else {
					for (Node n : children){
						if (n.search(s.substring(1))){
							return true;
						}
					}
				}
			}
			return false;
		}
	}
	
	List<Node> nodes;
	public WordDictionary () { nodes = new ArrayList<Node>(); }
    // Adds a word into the data structure.
    public void addWord(String s) {
		if (s.length() == 0){
			return;
		}
		char c = s.charAt(0);
		for (Node n : nodes){
			if (n.c == c){
				n.insert(s.substring(1));
				if (s.length() == 1){
					n.end = true;
				}
				return;
			}
		}
		Node n = new Node(c);
		nodes.add(n);
		if (s.length() == 1){
			n.end = true;
		}
		n.insert(s.substring(1));
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String s) {
        for (Node n : nodes){
        	if (n.search(s)){
        		return true;
        	}
        }
        return false;
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");
