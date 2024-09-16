package Persistencia

import Beans.Usuarios
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class OpenHelper(context:Context):SQLiteOpenHelper(
    context,"usuarios2.db",null,1
) {
    override fun onCreate(db: SQLiteDatabase?) {
        val query="create table users(_ID integer primary key autoincrement, " +
                "nombre text, edad integer, mail text)"
        db!!.execSQL(query)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        val query2="drop table users"
        db!!.execSQL(query2)
        onCreate(db)
    }

    fun nuevoUser(u:Usuarios){
        val datos=ContentValues()
        datos.put("nombre",u.nombre)
        datos.put("edad",u.edad)
        datos.put("mail",u.mail)
        val db=this.writableDatabase.insert("users",null,datos)
    }
    fun leerData():MutableList<Usuarios> {
        val db = this.readableDatabase
        val query = "select * from users"
        val result = db.rawQuery(query, null)
        val listaU = mutableListOf<Usuarios>()
        if(result.moveToFirst()){
            do{
                listaU.add(
                    Usuarios(
                        result.getInt(0), result.getString(1),
                        result.getInt(2), result.getString(3),
                    )
                )
            }while (result.moveToNext())
        }
        result.close()
        db.close()
        return listaU
    }

    fun deleteData(id:Int){
        val db=this.writableDatabase
        val contentValues=ContentValues()
        contentValues.put("_ID",id)
        db.delete("users","_ID="+id,null)
    }

    fun updateData(u:Usuarios){
        val db=this.writableDatabase
        val contentValues=ContentValues()
        contentValues.put("nombre",u.nombre)
        contentValues.put("edad",u.edad)
        contentValues.put("mail",u.mail)
        db.update("users",contentValues,"_ID="+u.cod,null)
    }

}