package ru.akazankov.demo.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

@Entity
class RemoteName(
    @Id
    var id: String? = null,

    @Column
    var name: String? = null
) {
}
