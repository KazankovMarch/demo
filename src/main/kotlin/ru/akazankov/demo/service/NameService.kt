package ru.akazankov.demo.service

import org.springframework.stereotype.Service
import ru.akazankov.demo.model.RemoteName
import ru.akazankov.demo.repo.NameRepository

@Service
class NameService(
    val nameRepository: NameRepository
) {

    fun saveName(remoteAddress: String, name: String) {
        nameRepository.save(
            RemoteName(
                id = remoteAddress,
                name = name
            )
        )
    }

    fun getName(remoteAddress: String): String? {
        val optionalName = nameRepository.findById(remoteAddress)
        return if (optionalName.isPresent) {
            optionalName.get().name
        } else {
            null
        }
    }


}
