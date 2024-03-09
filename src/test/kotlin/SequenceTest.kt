import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe

class SequenceTest : ShouldSpec({
    context("having a counter") {
        val counter = Counter(3)
        should("return  1 to 3") {
            counter.next() shouldBe 1
            counter.next() shouldBe 2
            counter.next() shouldBe 3
            counter.next() shouldBe null
        }
    }

    context("a sequence based on a counter") {
        val counter = Counter(5)
        val counterSequence = generateSequence { counter.next() }
        should("have a sequence from 1 to 5") {
            counterSequence.toList() shouldBe listOf(1, 2, 3, 4, 5)
        }
    }
})

class Counter(val upTo: Int) {
    var count = 0

    fun next() = if (count >= upTo) null
        else {
            count++
            count
        }
}