class Solution {
    class TaskInfo {
        int freq;
        int time;

        public TaskInfo(int freq, int time) {
            this.freq = freq;
            this.time = time;
        }
    }


    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> freqTable = new HashMap<Character, Integer>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
        Queue<TaskInfo> coolDownQueue = new LinkedList<TaskInfo>();

        for(char task : tasks) {
            freqTable.put(task, freqTable.getOrDefault(task, 0) + 1);
        }

        for(int freq : freqTable.values()) {
            maxHeap.add(freq);
        }

        int time = 0;

        while(!maxHeap.isEmpty() || !coolDownQueue.isEmpty()) {
            time++;

            if(!maxHeap.isEmpty()) {
                int freq = maxHeap.poll();
                freq--;

                if(freq != 0) {
                    coolDownQueue.add(new TaskInfo(freq, time + n));
                }
            }

            if(!coolDownQueue.isEmpty()){ 
                TaskInfo taskInfo = coolDownQueue.peek();
                if(taskInfo.time <= time) {
                    coolDownQueue.poll();
                    maxHeap.add(taskInfo.freq); // The task after the time specified, will be processed next
                }
            }
        }

        return time;
    }
}
