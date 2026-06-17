class Twitter {
    class Node {
        TweetInfo tweet;
        int userId;
        int index;

        public Node(TweetInfo tweet, int userId, int index) {
            this.tweet = tweet;
            this.userId = userId;
            this.index = index;
        }
    }


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
        PriorityQueue<Node> maxHeap = new PriorityQueue<Node>((a, b) -> b.tweet.time - a.tweet.time);

        Set<Integer> usersList = new HashSet<Integer>();
        usersList.addAll(followMap.getOrDefault(userId, new HashSet<Integer>()));
        usersList.add(userId);

        for(Integer user : usersList) {
            List<TweetInfo> userTweets = tweetMap.get(user);

            if(userTweets != null && !userTweets.isEmpty()) {
                int lastIndex = userTweets.size() - 1;
                Node node = new Node(userTweets.get(lastIndex), user, lastIndex); // Pushing only latest tweet of user
                maxHeap.add(node);
            }
        }

        List<Integer> tweetList = new ArrayList<Integer>();

        while(!maxHeap.isEmpty() && tweetList.size() < 10) {
            Node node = maxHeap.poll();
            tweetList.add(node.tweet.tweetId);

            int nextIndex = node.index - 1;

            if(nextIndex >= 0) {
                List<TweetInfo> nextTweets = tweetMap.get(node.userId);
                Node nextNode = new Node(nextTweets.get(nextIndex), node.userId, nextIndex);
                maxHeap.add(nextNode);
            }
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
