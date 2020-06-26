package com.github.ronquilloaeon

import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.core.subcommands
import com.github.ajalt.clikt.parameters.options.option

/*
 * Basic usage: ./starlink above --api-key
 *              ./starlink nearest --api-key
 * CLI needs to have config command: ./starlink config coordinates [LAT] [LONG]
 *
 */
class StarlinkTracker: CliktCommand() {
    override fun run() = Unit
}

class Above: CliktCommand(help = "See what Starlink satellites are visible from your location") {
    val apiKey by option(help = "N2YO API Key")

    override fun run() {
        echo("Ah yeah! $apiKey")
    }
}

fun main(args: Array<String>) = StarlinkTracker().subcommands(Above()).main(args)
