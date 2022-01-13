public class Palindrome extends OffByOne{
    public Deque<Character> wordToDeque(String word){
        Deque<Character> res = new LinkedListDeque<Character>();

        for (int i = 0; i < word.length(); i++){
            Character c = word.charAt(i);
            res.addLast(c);
        }
        return res;
    }

    public boolean isPalindrome(String word){
        if (word == null){
            return false;
        }
        Deque<Character> wordDeque = wordToDeque(word);
        if(wordDeque.isEmpty()){
            return false;
        }
        if (wordDeque.size() == 1){
            return true;
        }
        while (wordDeque.size() > 1){
            Character head = wordDeque.removeFirst();
            Character tail = wordDeque.removeLast();
            if (head != tail){
                return false;
            }
        }
        return true;
    }
    public boolean isPalindrome(String word, CharacterComparator cc){
        if (word == null) return false;
        Deque<Character> wordDeque = wordToDeque(word);
        if (wordDeque.isEmpty()) return false;
        if(wordDeque.size() == 1) return true;
        while (wordDeque.size() > 1){
            Character head = wordDeque.removeFirst();
            Character tail = wordDeque.removeLast();
            if (cc.equalChars(head, tail) == false){
                return false;
            }
        }
        return true;
    }

}
