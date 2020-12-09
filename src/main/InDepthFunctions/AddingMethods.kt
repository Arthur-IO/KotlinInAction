package main.InDepthFunctions

// This file demonstrates how to add methods to pre-existing classes

/**
 * Returns the last character within a string
 */
fun String.lastChar(): Char = this.get(this.length - 1)