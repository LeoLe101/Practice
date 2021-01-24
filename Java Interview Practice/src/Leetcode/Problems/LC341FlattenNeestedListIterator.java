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

        public NestedIterator(List<NestedInteger> nestedList) {
            list = new LinkedList<NestedInteger>();
            helper(nestedList);
        }

        @Override
        public Integer next() {

        }

        @Override
        public boolean hasNext() {

        }

        private void helper(List<NestedInteger> nestedList) {
            for (NestedInteger i: nestedList) {
                if (i.isInteger()) {
                    list.add(i);
                } else {

                }

            }

        }
    }

    /**
     * Your NestedIterator object will be instantiated and called as such:
     * NestedIterator i = new NestedIterator(nestedList); while (i.hasNext()) v[f()]
     * = i.next();
     */

}
