package br.com.pierreDesafio.DesafioGiaB.entities

data class Transacao (
    val id: Long,
    val descricao: String,
    val data: Long,
    val valor: Int,
    val ano: Int,
    val mes: Int
)
