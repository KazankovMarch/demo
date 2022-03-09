package ru.akazankov.demo.rest

import org.springframework.web.bind.annotation.*
import ru.akazankov.demo.service.NameService
import javax.servlet.http.HttpServletRequest

@RestController
@RequestMapping("/greeting")
class GreetingsController(
    val nameService: NameService
) {

    @GetMapping()
    fun greeting(
        request: HttpServletRequest
    ): String {
        val name = nameService.getName(request.remoteAddr!!)

        return "Hello ${name ?: "World"}!"
    }

    @PostMapping("/name")
    fun setGreetingName(
        @RequestBody name: String,
        request: HttpServletRequest
    ): String {
        val remoteAddr = request.remoteAddr!!
        val previousName = nameService.getName(remoteAddr)
        nameService.saveName(remoteAddr, name)
        return if (previousName != null) {
            "old name was $previousName, new name is $name"
        } else {
            "new name is $name"
        }
    }

}