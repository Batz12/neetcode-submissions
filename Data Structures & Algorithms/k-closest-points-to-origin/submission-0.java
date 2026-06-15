class Solution {
    class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public double getDistance(int x, int y) {
        return Math.sqrt(Math.pow(x,2) + Math.pow(y, 2));
    }

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Point> maxHeap = new PriorityQueue<Point>((p1, p2) -> Double.compare(getDistance(p2.x, p2.y), getDistance(p1.x, p1.y)));

        for(int[] point : points) {
            Point selectedPoint = new Point(point[0], point[1]);

            maxHeap.add(selectedPoint);

            if(maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        int[][] result = new int[k][2];
        int pointIndex = 0;

        while(!maxHeap.isEmpty()) {
            Point resultPoint = maxHeap.poll();
            result[pointIndex][0] = resultPoint.x;
            result[pointIndex][1] = resultPoint.y;

            pointIndex++;
        }


        return result;
    }
}
