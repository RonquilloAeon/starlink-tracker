package com.github.ronquilloaeon

enum class SatelliteClassification(val code: String) {
    CLASSIFIED("C"),
    SECRET("S"),
    UNCLASSIFIED("U");

    companion object {
        private val map = values().associateBy(SatelliteClassification::code)
        operator fun get(code: String) = map[code]
    }
}

data class Satellite(
    val name: String,
    val catalogNumber: String,
    val classification: SatelliteClassification
)

class TLEParser(lines: List<String>) {
    var satellites: MutableMap<String, Satellite> = mutableMapOf()
        private set

    init {
        loadSatellite(lines)
    }

    private fun loadSatellite(lines: List<String>) {
        // See https://en.wikipedia.org/wiki/Two-line_element_set#Format
        for (i in lines.chunked(3)) {
            if (i.size != 3) continue

            val name = i[0].trim()
            val catalogNumber = i[1].subSequence(2, 7).toString()

            satellites[name] = Satellite(
                name, catalogNumber, SatelliteClassification[i[1][7].toString()]!!
            )
        }
    }
}
