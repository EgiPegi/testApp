package com.egi

class Cart {
    String code
    static hasMany = [item: Item]
    static belongsTo = [transaction: Transaction]
    Integer quantity
    Integer price

    static constraints = {
        code size: 1..40, blank: false, unique: true
        quantity min: 0
        price min: 0
    }
    String toString() {
    code
    }
}
