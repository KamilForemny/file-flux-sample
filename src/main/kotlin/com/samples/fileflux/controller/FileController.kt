package com.samples.fileflux.controller

import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import java.nio.file.Files
import java.nio.file.Paths
import java.time.Duration

const val FILES_MAPPING = "/files"
const val IMAGES_PATH = "package/images"

@RestController
@RequestMapping
class FileController {

    @GetMapping(FILES_MAPPING, produces = [MediaType.APPLICATION_STREAM_JSON_VALUE])
    fun getFilesAsFlux() = Flux
            .fromStream(Files.list((Paths.get(IMAGES_PATH))))
            .delayElements(Duration.ofSeconds(1L))

}