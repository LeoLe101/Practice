public class MiniDomino {

    // Son Tran's version
    public int minDominoRotations(int[] A, int[] B) {
        Map<Integer, Integer> ma = new HashMap<>();
        Map<Integer, Integer> mb = new HashMap<>();

        // Syntax for lambda from Max to Min in comparison
        PriorityQueue<Map.Entry<Integer, Integer>> pqb = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        PriorityQueue<Map.Entry<Integer, Integer>> pqa = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());

        for (int a : A) {
            ma.put(a, ma.getOrDefault(a, 0) + 1); // Clean code for putting in code and change it. IF the map does not
                                                  // have this key, use 0 + 1 as value.
        }
        for (int b : B) {
            mb.put(b, mb.getOrDefault(b, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> e : ma.entrySet()) { // Entry Set doesn't return order, it will go random
            pqa.add(e); // Once put in Priority Queue, it will order the key buy value as defined above when init
        }
        for (Map.Entry<Integer, Integer> e : mb.entrySet()) {
            pqb.add(e);
        }
        int resa = Integer.MAX_VALUE;
        while (!pqa.isEmpty()) {
            Map.Entry<Integer, Integer> e = pqa.poll();
            int cur = e.getKey();
            int temp = 0;
            boolean possible = true;
            for (int i = 0; i < A.length; i++) {
                if (A[i] != cur && B[i] == cur) {
                    temp += 1;
                } else if (A[i] != cur && B[i] != cur) {
                    possible = false;
                    break;
                }
            }
            if (possible) {
                resa = Math.min(resa, temp);
            }
        }
        int resb = Integer.MAX_VALUE;
        while (!pqb.isEmpty()) {
            Map.Entry<Integer, Integer> e = pqb.poll();
            int cur = e.getKey();
            int temp = 0;
            boolean possible = true;
            for (int i = 0; i < B.length; i++) {
                if (B[i] != cur && A[i] == cur) {
                    temp += 1;
                } else if (A[i] != cur && B[i] != cur) {
                    possible = false;
                    break;
                }
            }
            if (possible) {
                resb = Math.min(resb, temp);
            }
        }
        int res = Math.min(resa, resb);
        return (res == Integer.MAX_VALUE) ? -1 : res;
    }
}
