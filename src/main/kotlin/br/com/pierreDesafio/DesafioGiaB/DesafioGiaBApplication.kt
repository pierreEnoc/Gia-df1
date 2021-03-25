package br.com.pierreDesafio.DesafioGiaB

import br.com.pierreDesafio.DesafioGiaB.entities.Transacao
import br.com.pierreDesafio.DesafioGiaB.entities.TrasacaoData
import br.com.pierreDesafio.DesafioGiaB.resources.TransacaoResource
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import java.util.concurrent.ConcurrentHashMap

@SpringBootApplication
class DesafioGiaBApplication

fun main(args: Array<String>) {
	runApplication<DesafioGiaBApplication>(*args)
}
