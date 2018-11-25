package com.samples.fileflux

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class FileFluxApplication

fun main(args: Array<String>) {
    runApplication<FileFluxApplication>(*args)
}
