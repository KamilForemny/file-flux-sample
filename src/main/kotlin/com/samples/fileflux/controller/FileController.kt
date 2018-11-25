package com.samples.fileflux.controller

import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import java.time.Duration


@RestController
@RequestMapping
class FileController {

    @GetMapping("/files", produces = [MediaType.APPLICATION_STREAM_JSON_VALUE])
    fun getFilesAsFlux(): Flux<Path> {
        return Flux.fromStream(Files.list((Paths.get("package/images")))).delayElements(Duration.ofSeconds(1L))
    }

}