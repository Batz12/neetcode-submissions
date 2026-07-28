class CountSquares {
    HashMap<Integer, HashMap<Integer, Integer>> points;

    public CountSquares() {
        points = new HashMap<Integer, HashMap<Integer, Integer>>();
    }
    
    public void add(int[] point) {
        int x = point[0];
        int y = point[1];

        points.putIfAbsent(x, new HashMap<Integer, Integer>());

        points.get(x).put(y, points.get(x).getOrDefault(y, 0) + 1);
    }

    private int getCount(int x, int y) {
        if(!points.containsKey(x)) {
            return 0;
        }

        return points.get(x).getOrDefault(y, 0);
    }
    
    public int count(int[] point) {
        int x = point[0];
        int y = point[1];

        int result = 0;

        if(!points.containsKey(x)) {
            return 0;
        }

        for(int x2 : points.keySet()) {
            if(x2 == x) {
                continue;
            }

            int side = x2 - x;

            int y1 = y + side;
            int y2 = y - side;

            // Upward square
            result += getCount(x2, y) * getCount(x, y1) * getCount(x2, y1);

            // Downward square
            result += getCount(x2, y) * getCount(x, y2) * getCount(x2, y2);
        }
        
        return result;
    }
}
