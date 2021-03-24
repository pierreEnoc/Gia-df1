package br.com.pierreDesafio.DesafioGiaB

import br.com.pierreDesafio.DesafioGiaB.entities.Transacao
import br.com.pierreDesafio.DesafioGiaB.entities.TrasacaoData
import br.com.pierreDesafio.DesafioGiaB.resources.TransacaoResource
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import java.util.concurrent.ConcurrentHashMap

@SpringBootApplication
class DesafioGiaBApplication {
	companion object {
		val initialTransacoes = arrayOf(
			TrasacaoData(1,"test1",230321900,99999),
			TrasacaoData(2,"test1",230321900,99999),
			TrasacaoData(3,"test1",230321900,99999)
			//Transacao(1001,"tet2",240321900,99999, 21, 4),
		//	Transacao(1002,"tet3",250321900,99999, 21, 3),
		//	Transacao(1003,"tet4",260321900,99999, 21, 2),
			//Transacao(1004,"tet5",270321900,99999, 21, 3)
		)
	}
	@Bean
	fun transacoes() =
		ConcurrentHashMap<Long, TrasacaoData>(initialTransacoes.associateBy(TrasacaoData::id))
	}


fun main(args: Array<String>) {
	runApplication<DesafioGiaBApplication>(*args)
}
