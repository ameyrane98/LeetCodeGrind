import java.util.*;

class Twitter {
    class TweetNode {
        int id;
        long time;
        TweetNode next;

        TweetNode(int id, long time, TweetNode next) {
            this.id = id;
            this.time = time;
            this.next = next;
        }
    }

    HashMap<Integer, Set<Integer>> followees;
    HashMap<Integer, TweetNode> head;
    long clock;

    public Twitter() {
        followees = new HashMap<>();
        head = new HashMap<>();
        clock = 0;
    }

    public void postTweet(int userId, int tweetId) {
        TweetNode h = head.getOrDefault(userId, null);
        TweetNode node = new TweetNode(tweetId, ++clock, h);
        head.put(userId, node);

        // ensure user follows themselves
        followees.putIfAbsent(userId, new HashSet<>());
        followees.get(userId).add(userId);
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> feed = new ArrayList<>(10);

        PriorityQueue<TweetNode> pq = new PriorityQueue<>(
            (a, b) -> Long.compare(b.time, a.time) // max-heap by time
        );

        // candidates = self + followees (if any)
        Set<Integer> candidates = new HashSet<>();
        candidates.add(userId);
        Set<Integer> follows = followees.get(userId);
        if (follows != null) candidates.addAll(follows);

        // seed heap with newest tweet of each candidate
        for (int u : candidates) {
            TweetNode h = head.get(u);
            if (h != null) pq.offer(h);
        }

        // pop up to 10 most recent
        while (!pq.isEmpty() && feed.size() < 10) {
            TweetNode top = pq.poll();
            feed.add(top.id);
            if (top.next != null) pq.offer(top.next);
        }

        return feed;
    }

    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) return; // skip self
        followees.putIfAbsent(followerId, new HashSet<>());
        followees.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (followerId == followeeId) return; // don’t remove self
        if (followees.containsKey(followerId)) {
            followees.get(followerId).remove(followeeId);
        }
    }
}
