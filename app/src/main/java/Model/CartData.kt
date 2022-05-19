package io.a70mm.utils.Model

class CartData(s: String) {
    private var item: String? = null
    private var price: String? = null

    fun CartData(item: String?, price: String?) {
        this.item = item
        this.price = price
    }

    fun getItem(): String? {
        return item
    }

    fun setItem(item: String?) {
        this.item = item
    }

    fun getPrice(): String? {
        return price
    }

    fun setPrice(price: String?) {
        this.price = price
    }
}