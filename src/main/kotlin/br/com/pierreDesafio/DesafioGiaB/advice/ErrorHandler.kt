package br.com.pierreDesafio.DesafioGiaB.advice

import br.com.pierreDesafio.DesafioGiaB.error.ErrorMessage
import br.com.pierreDesafio.DesafioGiaB.exception.TransacaoNotFoundException
import com.fasterxml.jackson.annotation.JsonFormat
import org.springframework.boot.json.JsonParseException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.multipart.support.AbstractMultipartHttpServletRequest
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@ControllerAdvice
class ErrorHandler {
    @ExceptionHandler(JsonParseException::class)
    fun JsonParseExceptionHandler(servletRequest: HttpServletRequest, servletResponse: HttpServletResponse, exception:
        Exception): ResponseEntity<ErrorMessage> {
         return  ResponseEntity(ErrorMessage("Json Error", exception.message ?: "Invalid Json"), HttpStatus.BAD_REQUEST)
        }
    
        @ExceptionHandler(TransacaoNotFoundException::class)
        fun transacaoNotFoundExceptionHandler(servletRequest: HttpServletRequest, servletResponse:
        HttpServletResponse, exception: Exception): ResponseEntity<ErrorMessage> {
            return ResponseEntity(ErrorMessage("Transacao Nao Localizada", exception.message !!), HttpStatus.NOT_FOUND)
        }
    }