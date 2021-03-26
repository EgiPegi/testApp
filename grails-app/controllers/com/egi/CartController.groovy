package com.egi

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class CartController {

    CartService cartService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond cartService.list(params), model:[cartCount: cartService.count()]
    }

    def show(Long id) {
        respond cartService.get(id)
    }

    def create() {
        respond new Cart(params)
    }

    def save(Cart cart) {
        if (cart == null) {
            notFound()
            return
        }

        try {
            cartService.save(cart)
        } catch (ValidationException e) {
            respond cart.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'cart.label', default: 'Cart'), cart.id])
                redirect cart
            }
            '*' { respond cart, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond cartService.get(id)
    }

    def update(Cart cart) {
        if (cart == null) {
            notFound()
            return
        }

        try {
            cartService.save(cart)
        } catch (ValidationException e) {
            respond cart.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'cart.label', default: 'Cart'), cart.id])
                redirect cart
            }
            '*'{ respond cart, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        cartService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'cart.label', default: 'Cart'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'cart.label', default: 'Cart'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
