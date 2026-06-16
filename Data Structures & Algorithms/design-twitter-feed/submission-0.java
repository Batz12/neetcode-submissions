class Twitter {
    class TweetInfo {
        int time;
        int tweetId;

        public TweetInfo(int time, int tweetId) {
            this.time = time;
            this.tweetId = tweetId;
        }
    } 

    public HashMap<Integer, HashSet<Integer>> followMap;
    public HashMap<Integer, List<TweetInfo>> tweetMap;
    public int time;

    public Twitter() {
        followMap = new HashMap<Integer, HashSet<Integer>>();
        tweetMap = new HashMap<Integer, List<TweetInfo>>();
        time = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        List<TweetInfo> tweetInfoList = tweetMap.getOrDefault(userId, new ArrayList<TweetInfo>());
        TweetInfo tweetInfo = new TweetInfo(time++, tweetId);
        tweetInfoList.add(tweetInfo);
        tweetMap.put(userId, tweetInfoList);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<TweetInfo> maxHeap = new PriorityQueue<TweetInfo>((a, b) -> b.time - a.time);

        Set<Integer> usersList = new HashSet<Integer>();
        usersList.addAll(followMap.getOrDefault(userId, new HashSet<Integer>()));
        usersList.add(userId);

        for(Integer user : usersList) {
            List<TweetInfo> userTweets = tweetMap.get(user);

            if(userTweets != null) {
                maxHeap.addAll(userTweets);
            }
        }

        List<Integer> tweetList = new ArrayList<Integer>();

        while(!maxHeap.isEmpty() && tweetList.size() < 10) {
            TweetInfo tweetInfo = maxHeap.poll();
            tweetList.add(tweetInfo.tweetId);
        }

        return tweetList;
    }
    
    public void follow(int followerId, int followeeId) {
        HashSet<Integer> followerList = followMap.getOrDefault(followerId, new HashSet<Integer>());
        followerList.add(followeeId);
        followMap.put(followerId, followerList);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followMap.containsKey(followerId)) {
            followMap.get(followerId).remove(followeeId);
        }
    }
}
