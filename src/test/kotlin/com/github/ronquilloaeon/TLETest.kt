package com.github.ronquilloaeon

import java.io.File
import org.junit.Test
import kotlin.test.assertEquals

const val STARLINK_FILE = "src/test/res/starlink.txt"

class TLETest {
    @Test fun testTLEParser() {
        val parser = TLEParser(File(STARLINK_FILE).readLines())
        val satellitesToCheck = parser.satellites.values.filter {satellite ->
            satellite.name == "STARLINK-31" || satellite.name == "STARLINK-1111" || satellite.name == "STARLINK-1517"
        }.sortedBy { satellite -> satellite.name }

        assertEquals(3, satellitesToCheck.size)

        // STARLINK-1111
        assertEquals("44924", satellitesToCheck[0].catalogNumber)
        assertEquals(SatelliteClassification.UNCLASSIFIED, satellitesToCheck[0].classification)

        // STARLINK-1517
        assertEquals("45787", satellitesToCheck[1].catalogNumber)
        assertEquals(SatelliteClassification.UNCLASSIFIED, satellitesToCheck[1].classification)

        // STARLINK-31
        assertEquals("44235", satellitesToCheck[2].catalogNumber)
        assertEquals(SatelliteClassification.UNCLASSIFIED, satellitesToCheck[2].classification)
    }
}
