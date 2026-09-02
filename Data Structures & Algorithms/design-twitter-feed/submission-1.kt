class Twitter {
    private val posts = ArrayDeque<Pair<Int,Int>>()
    private val followerToFollowees = mutableMapOf<Int,MutableSet<Int>>()

    fun postTweet(userId: Int, tweetId: Int) {
        posts.addFirst(userId to tweetId)
    }

    fun getNewsFeed(userId: Int): List<Int> {
        val folowees = followerToFollowees[userId]
        
        val feed = mutableListOf<Int>()
        var count = 0
        
        for ((postUserId, postId) in posts) {
            if (folowees != null && postUserId in folowees || userId == postUserId) {
                feed.add(postId)
                if (++count == 10) break
            }
        }

        return feed
    }

    fun follow(followerId: Int, followeeId: Int) {
        followerToFollowees.getOrPut(followerId) { mutableSetOf<Int>() }.add(followeeId)
    }

    fun unfollow(followerId: Int, followeeId: Int) {
        followerToFollowees[followerId]?.remove(followeeId)
    }
}
