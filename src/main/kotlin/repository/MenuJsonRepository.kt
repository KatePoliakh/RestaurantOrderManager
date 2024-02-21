package repository

import entity.MenuItem
//import kotlinx.serialization.json.Json
import java.io.File
import java.util.*

class MenuJsonRepository : JsonRepository<MenuItem>() {
    //private val json = Json { prettyPrint = true }
    override fun serialize(data: List<MenuItem>): String {
    //    return json.encodeToString(data)
        return ""
    }

    override fun deserialize(data: String): List<MenuItem> {
     //   return json.decodeFromString(data)
        return emptyList()
    }

}