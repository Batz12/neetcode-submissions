class CountSquares {
    class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            if(this == obj) {
                return true;
            }

            if(!(obj instanceof Point)) {
                return false;
            }

            Point other = (Point) obj;
            return (this.x == other.x) && (this.y == other.y);
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }


    HashMap<Point, Integer> points;

    public CountSquares() {
        points = new HashMap<Point, Integer>();
    }
    
    public void add(int[] point) {
        Point p = new Point(point[0], point[1]);

        points.put(p, points.getOrDefault(p, 0) + 1);
    }

    private int getCount(Point p) {
        return points.getOrDefault(p, 0);
    }
    
    public int count(int[] point) {
        int x = point[0];
        int y = point[1];

        int result = 0;

        for(Point p : points.keySet()) {
            int x2 = p.x;
            int y2 = p.y;

            if(x2 == x && y2 == y) {
                continue;
            }

            if(Math.abs(x2 - x) != Math.abs(y2 - y)) {
                continue;
            }

            result += (points.get(p) * getCount(new Point(x, y2)) * getCount(new Point(x2, y))); 
        }
        
        return result;
    }
}
