class Solution {
    class Car {
        public int position;
        public int speed;

        public Car(int position, int speed) {
            this.position = position;
            this.speed = speed;
        } 
    }

    public int carFleet(int target, int[] position, int[] speed) {
        Stack<Double> stack = new Stack<Double>();
        List<Car> carList = new ArrayList<Car>();

        for(int i = 0; i < position.length; i++) {
            carList.add(new Car(position[i], speed[i]));
        }

        Collections.sort(carList, (a, b) ->  Integer.compare(a.position, b.position));

        // As list is sorting in ascending order, we go backwards
        for(int i = position.length - 1; i >= 0; i--) {
            double time = (double) (target - carList.get(i).position) / carList.get(i).speed;
            if(!stack.isEmpty() && time <= stack.peek()) {
                // This car is part of same fleet
            } else {
                stack.push(time);
            }

        }

        return stack.size();
    }
}
