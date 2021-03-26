package com.egi

class Item {
    static belongsTo = [cart: Cart]
    String name
    Integer price
    Integer quantity
    String description

    static constraints = {
        name size: 5..40, blank: false
        price min: 0
        quantity min: 0
        description size: 5..500, blank: false
    }

    String toString() {
    name
    }
}
