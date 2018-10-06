package mobi.hsz.idea.packagessearch.models

import com.github.kittinunf.fuel.core.ResponseDeserializable
import com.google.gson.Gson

abstract class Model<P> where P : Package {
    abstract fun deserializer(): ResponseDeserializable<Response<P>>

    abstract fun url(query: String): String

    class Deserializer<P : Package, R : Response<P>>(private val clazz: Class<R>) : ResponseDeserializable<R> {
        override fun deserialize(content: String) = Gson().fromJson(content, clazz)!!
    }
}
