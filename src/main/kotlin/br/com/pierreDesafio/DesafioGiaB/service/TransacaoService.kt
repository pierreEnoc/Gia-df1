package br.com.pierreDesafio.DesafioGiaB.service

import br.com.pierreDesafio.DesafioGiaB.entities.TrasacaoData
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service

interface TransacaoService {
    //fun getAll(): List<TrasacaoData>
    fun getById(id: Long): TrasacaoData?
    fun searchByDescricao(descricao: String): List<TrasacaoData>
}