package ru.akazankov.demo.repo

import org.springframework.data.jpa.repository.JpaRepository
import ru.akazankov.demo.model.RemoteName

interface NameRepository: JpaRepository<RemoteName, String> {

}
