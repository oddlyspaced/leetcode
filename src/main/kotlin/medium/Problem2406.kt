package medium

import java.util.*

class Problem2406 {
    fun minGroups(intervals: Array<IntArray>): Int {
        intervals.sortBy { it[0] }
        val pq = PriorityQueue<Int>()
        for (interval in intervals) {
            if (pq.isNotEmpty() && pq.peek() < interval[0]) {
                pq.poll()
            }
            pq.add(interval[1])
        }
        return pq.size
    }
}

fun main() {
    println(
        Problem2406().minGroups(
            arrayOf(
                intArrayOf(5, 10), intArrayOf(6, 8), intArrayOf(1, 5), intArrayOf(2, 3), intArrayOf(1, 10)
            )
        )
    )
    println(
        Problem2406().minGroups(
            arrayOf(
                intArrayOf(1, 3), intArrayOf(5, 6), intArrayOf(8, 10), intArrayOf(11, 13)
            )
        )
    )
    println(
        Problem2406().minGroups(
            arrayOf(
                intArrayOf(229966, 812955),
                intArrayOf(308778, 948377),
                intArrayOf(893612, 952735),
                intArrayOf(395781, 574123),
                intArrayOf(478514, 875165),
                intArrayOf(766513, 953839),
                intArrayOf(460683, 491583),
                intArrayOf(133951, 212694),
                intArrayOf(376149, 838265),
                intArrayOf(541380, 686845),
                intArrayOf(461394, 568742),
                intArrayOf(804546, 904032),
                intArrayOf(422466, 467909),
                intArrayOf(557048, 758709),
                intArrayOf(680460, 899053),
                intArrayOf(110928, 267321),
                intArrayOf(470258, 650065),
                intArrayOf(534607, 921875),
                intArrayOf(292993, 994721),
                intArrayOf(645020, 692560),
                intArrayOf(898840, 947977),
                intArrayOf(33584, 330630),
                intArrayOf(903142, 970252),
                intArrayOf(17375, 626775),
                intArrayOf(804313, 972796),
                intArrayOf(582079, 757160),
                intArrayOf(785002, 987823),
                intArrayOf(599263, 997719),
                intArrayOf(486500, 527956),
                intArrayOf(566481, 813653),
                intArrayOf(211239, 863969),
                intArrayOf(808577, 883125),
                intArrayOf(21880, 516436),
                intArrayOf(264747, 412144),
                intArrayOf(327175, 772333),
                intArrayOf(984807, 988224),
                intArrayOf(758172, 916673),
                intArrayOf(23583, 406006),
                intArrayOf(954674, 956043),
                intArrayOf(379202, 544291),
                intArrayOf(688869, 785368),
                intArrayOf(841735, 983869),
                intArrayOf(99836, 916620),
                intArrayOf(332504, 740696),
                intArrayOf(740840, 793924),
                intArrayOf(896607, 920924),
                intArrayOf(868540, 922727),
                intArrayOf(125849, 550941),
                intArrayOf(433284, 685766)
            )
        )
    )
}