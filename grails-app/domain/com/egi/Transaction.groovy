package com.egi

class Transaction {
    String code
    // static hasOne = [cart: Cart]
    Integer total
    String status

    static constraints = {
        code size: 1..40, blank: false, unique: true
        total min: 0
    }

    static mapping = {
        status defaultValue: "'unpaid'"
    }
}
