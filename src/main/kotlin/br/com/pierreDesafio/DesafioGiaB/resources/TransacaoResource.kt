package br.com.pierreDesafio.DesafioGiaB.resources

import br.com.pierreDesafio.DesafioGiaB.entities.TrasacaoData
import br.com.pierreDesafio.DesafioGiaB.exception.TransacaoNotFoundException
import br.com.pierreDesafio.DesafioGiaB.service.TransacaoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(value = ["/transacoes"])
class TransacaoResource {
    
    @Autowired
    lateinit var service: TransacaoService
    
    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): ResponseEntity<TrasacaoData?> {
        var transacao = service.getById(id) ?:
            throw TransacaoNotFoundException("transacao ${id} nao localizada")
        return ResponseEntity(transacao, HttpStatus.OK)
    }
    
    @RequestMapping
    fun getAllTransacao(@RequestParam(required = false, defaultValue = "") descricaoFilter: String):
            ResponseEntity<List<TrasacaoData>> {
        var status = HttpStatus.OK
        val listTrasacoes = service.searchByDescricao(descricaoFilter)
        if (listTrasacoes.size == 0) {
            status = HttpStatus.NOT_FOUND
        }
        return ResponseEntity(listTrasacoes, status)
    }
   
}