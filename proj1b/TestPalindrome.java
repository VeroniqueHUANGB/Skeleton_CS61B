import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testIsPalindrome(){
        assertFalse(palindrome.isPalindrome(""));
        assertFalse(palindrome.isPalindrome("cat"));
        assertTrue(palindrome.isPalindrome("noon"));
        assertTrue(palindrome.isPalindrome("A"));
        assertFalse(palindrome.isPalindrome(null));
    }
//    @Test
//    public void testIsPalindromeOffByOne(){
//        CharacterComparator cc = new OffByOne();
//        assertTrue(palindrome.isPalindrome("a", cc));
//        assertFalse(palindrome.isPalindrome("ac", cc));
//    }
    @Test
    public void testPalindromeOffByN(){
        CharacterComparator cc = new OffByN(2);
        assertTrue(palindrome.isPalindrome("ac", cc));
        assertTrue(palindrome.isPalindrome("adb", cc));
        assertFalse(palindrome.isPalindrome("adgjfb", cc));
    }
}