package co.hisabsoftware.polling.webback.entities

import javax.persistence.*

@Entity
data class Poll (
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  var id: Int,

  @Column(nullable = false)
  var title: String,

  var description: String?,

  var active: Boolean,

  var shared: Boolean
);