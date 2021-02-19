package src.Leetcode.Problems;

import java.util.*;

public class LC359LoggerRateLimiter {
    private HashMap<String, Integer> msgDict;

    /** Initialize your data structure here. */
    public LC359LoggerRateLimiter() {
        msgDict = new HashMap<String, Integer>();
    }

    /**
     * Returns true if the message should be printed in the given timestamp,
     * otherwise returns false.
     */
    public boolean shouldPrintMessage(int timestamp, String message) {

        // Put the new log in and return true
        if (!this.msgDict.containsKey(message)) {
            this.msgDict.put(message, timestamp);
            return true;
        }

        // Change the timeStamp of the old log that passed 10s mark
        Integer oldTimestamp = this.msgDict.get(message);
        if (timestamp - oldTimestamp >= 10) {
            this.msgDict.put(message, timestamp);
            return true;
        }
        // If this log still not passed 10s mark, return false
        else
            return false;
    }

}

/**
 * Your Logger object will be instantiated and called as such: Logger obj = new
 * Logger(); boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */