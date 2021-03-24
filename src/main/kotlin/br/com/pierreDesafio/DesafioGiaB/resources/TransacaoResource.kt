package br.com.pierreDesafio.DesafioGiaB.resources

import br.com.pierreDesafio.DesafioGiaB.entities.Transacao
import br.com.pierreDesafio.DesafioGiaB.entities.TrasacaoData
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.ConcurrentHashMap

@RestController
//@RequestMapping(value = ["/{id}"], method = arrayOf(RequestMethod.GET))
class TransacaoResource {
    
    @Autowired
    lateinit var transacoes: ConcurrentHashMap<Long, TrasacaoData>
    
    @RequestMapping(value = ["/{id}"], method = arrayOf(RequestMethod.GET))
    fun sayHello(): String {
      return ("Hello word")
    }
    
    @RequestMapping(value = ["/transacoes"], method = arrayOf(RequestMethod.GET))
    fun getAllTransacao() =  transacoes.entries
    
    
    @RequestMapping(value = ["/transacoes/{id}"], method = arrayOf(RequestMethod.GET))
    fun transacaGetById(@PathVariable id:Long) =  transacoes[id]
}