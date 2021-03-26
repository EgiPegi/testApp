package com.egi

class Cart {
    String code
    static hasMany = [item: Item]

    static constraints = {
        code size: 1..40, blank: false, unique: true
    }
    String toString() {
    code
    }
}
