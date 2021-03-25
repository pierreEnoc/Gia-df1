package br.com.pierreDesafio.DesafioGiaB.service.impl

import br.com.pierreDesafio.DesafioGiaB.entities.TrasacaoData
import br.com.pierreDesafio.DesafioGiaB.service.TransacaoService
import org.springframework.stereotype.Component
import java.util.concurrent.ConcurrentHashMap

@Component
class TransacaoImpl: TransacaoService {
    
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
      var transacoes =
        ConcurrentHashMap<Long, TrasacaoData>(initialTransacoes.associateBy(TrasacaoData::id))
        
    override fun getById(id: Long): TrasacaoData? {
       return transacoes[id]
    }
    
    override fun searchByDescricao(descricao: String): List<TrasacaoData> =
        transacoes.filter {
            it.value.descricao.contains(descricao, true)
        }.map (Map.Entry<Long, TrasacaoData>::value).toList()
}