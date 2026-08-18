class LRUCache(capacity: Int) {
    private val map = object : LinkedHashMap<Int,Int>(16, 0.75f, true) {
        override fun removeEldestEntry(eldest: Map.Entry<Int?, Int?>?): Boolean {
            return size > capacity
        }
    }


    fun get(key: Int): Int {
        return map[key] ?: -1
    }

    fun put(key: Int, value: Int) {
        map[key] = value
    }
}