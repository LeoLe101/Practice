package src.Leetcode.Problems;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class LC341FlattenNeestedListIterator {

    /**
     * // This is the interface that allows for creating nested lists. // You should
     * not implement it, or speculate about its implementation public interface
     * NestedInteger {
     *
     * // @return true if this NestedInteger holds a single integer, rather than a
     * nested list. public boolean isInteger();
     *
     * // @return the single integer that this NestedInteger holds, if it holds a
     * single integer // Return null if this NestedInteger holds a nested list
     * public Integer getInteger();
     *
     * // @return the nested list that this NestedInteger holds, if it holds a
     * nested list // Return empty list if this NestedInteger holds a single integer
     * public List<NestedInteger> getList(); }
     */

    public interface NestedInteger {
        public boolean isInteger();

        public Integer getInteger();

        public List<NestedInteger> getList();
    }

    public class NestedIterator implements Iterator<Integer> {

        private List<NestedInteger> list;
        private int currPtr;

        public NestedIterator(List<NestedInteger> nestedList) {
            currPtr = 0;
            list = new LinkedList<NestedInteger>();
            helper(nestedList);
        }

        @Override
        public Integer next() {
            int temp = list.get(currPtr).getInteger();
            if (currPtr < list.size())
                currPtr++;
            return temp;
        }

        @Override
        public boolean hasNext() {
            return currPtr < list.size();
        }

        private void helper(List<NestedInteger> nestedList) {
            // Loop thru the list
            for (NestedInteger i : nestedList) {
                // if this element is an integer, add to list
                if (i.isInteger()) {
                    list.add(i);
                }
                // Else, recur down and check all the element again
                else {
                    helper(i.getList());
                }
            }
            return;
        }
    }

    /**
     * Your NestedIterator object will be instantiated and called as such:
     * NestedIterator i = new NestedIterator(nestedList); while (i.hasNext()) v[f()]
     * = i.next();
     */

}
