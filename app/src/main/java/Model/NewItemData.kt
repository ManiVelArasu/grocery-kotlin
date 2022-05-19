package io.a70mm.utils.Model

class NewItemData (s: String) {
    private var item: String? = null
    private var image = 0

    fun NewItemData(item: String?, image: Int) {
        this.item = item
        this.image = image
    }

    fun getItem(): String? {
        return item
    }

    fun setItem(item: String?) {
        this.item = item
    }

    fun getImage(): Int {
        return image
    }

    fun setImage(image: Int) {
        this.image = image
    }
}