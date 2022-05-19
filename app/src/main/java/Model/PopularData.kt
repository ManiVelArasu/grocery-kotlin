package io.a70mm.utils.Model

class PopularData(title: String?) {
    private var title: String

    init {
        this.title = title!!

    }
    fun getTitle(): String? {
        return title
    }
    fun setTitle(name: String?) {
        title = name!!
    }

}