package br.com.pierreDesafio.DesafioGiaB.exception

import br.com.pierreDesafio.DesafioGiaB.error.ErrorMessage
import java.lang.Exception

class TransacaoNotFoundException (message: String) : Exception(message) {
}