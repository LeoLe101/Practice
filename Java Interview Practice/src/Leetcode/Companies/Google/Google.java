package src.Leetcode.Companies.Google;

import java.util.*;

public class Google {

    // #region --------------- 929. Unique Email Addresses ---------------
    // Got from LEETCODE Submission. This is the fastest solution yet
    public int numUniqueEmailsFastest(String[] emails) {
        if (emails == null || emails.length == 0)
            return 0;

        Set<String> uniqueEmails = new HashSet();

        for (String email : emails) {
            uniqueEmails.add(formatEmail(email));
        }
        return uniqueEmails.size();
    }

    private String formatEmail(String email) {
        int n = email.length();
        char[] formattedEmail = new char[n];
        int readIdx = 0, writeIdx = 0;
        char ch;

        while ((ch = email.charAt(readIdx)) != '@') {
            if (ch == '.') {
                //
            } else if (ch == '+') {
                break;
            } else {
                formattedEmail[writeIdx++] = ch;
            }
            readIdx++;
        }

        while ((ch = email.charAt(readIdx)) != '@') {
            readIdx++;
        }

        while (readIdx < n) {
            formattedEmail[writeIdx++] = email.charAt(readIdx);
            readIdx++;
        }

        return new String(formattedEmail, 0, writeIdx);
    }

    // Use Java String function, but this will not be very good if there's a lot of
    // '.' within the local name due to constant replace()
    // Space (N) Time (N)
    public int numUniqueEmailsOptimized(String[] emails) {
        // Init var
        Set<String> emailSet = new HashSet<>();

        // Loop through email arr
        for (String email : emails) {
            // Get Domain and Local name
            String[] parseEmail = email.split("@");

            // Parse Local name and remove '+' afterward
            String[] localNames = parseEmail[0].split("\\+");

            // ignore all '.' in local name
            String localName = localNames[0].replace(".", "");

            // Put into set to check
            emailSet.add(localName + "@" + parseEmail[1]);
        }
        return emailSet.size();
    }

    // MY SOLUTION: Space (N) Time (N * M) where M is the amount of time to reach @
    // char if + is met (Might work, but will cost alot of time exceeded)
    // Give an arr of email with '.' and '+' within the email.
    // If the '.' and '+' exist in the local name, '.' will be ignored and any
    // letter after '+' will be ignored
    public int numUniqueEmails(String[] emails) {
        // Init var
        int result = 0;
        HashSet<String> emailSet = new HashSet<>();

        // Loop emails[]
        for (String email : emails) {
            // Parse email and put check if it is a dup
            email = parseEmail(email);

            if (!emailSet.contains(email)) {
                emailSet.add(email);
                result++;
            }
        }

        return result;
    }

    private String parseEmail(String email) {
        String result = null;
        char currChar;
        int size = email.length();
        boolean domainFlag = false;

        if (size < 1)
            return email;

        for (int i = 0; i < size;) {
            currChar = email.charAt(i);

            if (!domainFlag) {
                if (currChar != '.' && currChar != '+')
                    result += currChar;

                if (currChar == '.') {
                    i++;
                    continue;
                }

                if (currChar == '+') {
                    while (currChar != '@') {
                        i++;
                        currChar = email.charAt(i);
                    }
                    domainFlag = !domainFlag;
                }
            } else {
                result += currChar;
                i++;
            }
        }
        return result;
    }

    // #endregion --------------- 929. Unique Email Addresses ---------------

    // #region --------------- 1021. Remove Outermost Parentheses ---------------

    public String removeOuterParentheses(String S) {
        String result = "";

        return result;
    }

    // #endregion --------------- 1021. Remove Outermost Parentheses ---------------

}
