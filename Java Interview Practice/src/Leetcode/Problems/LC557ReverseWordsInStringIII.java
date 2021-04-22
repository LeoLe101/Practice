public class LC557ReverseWordsInStringIII {

    /**
     * Space (1) since we know the amount of string from split 
     * 
     * Time (N * M) loop thru whole string and loop reversively for each word
     */
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder(s.length());
        String[] arr = s.split(" ");
        int len = 0;
        for (String str : arr) {
            len = str.length() - 1;
            while (len >= 0) {
                sb.append(str.charAt(len));
                len--;
            }
            sb.append(" ");
        }
        return sb.toString().trim(); // trim last space
    }

    public String reverseWordsV2(String s) {
        String[] str = s.split(" ");
        // reverse each words from splitted arr
        for (int i = 0; i < str.length; i++)
            str[i] = new StringBuilder(str[i]).reverse().toString();

        // add space and the reversed word
        StringBuilder result = new StringBuilder();
        for (String st : str)
            result.append(st + " ");
        
        // trim last space 
        return result.toString().trim();
    }

}
