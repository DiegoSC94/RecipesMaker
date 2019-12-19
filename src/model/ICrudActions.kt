package model

interface ICrudActions {

    fun añadir(nombreReceta: String, alimento: Alimento, receta: HashMap<String, Alimento>){
        receta.put(nombreReceta, alimento)
        println("El alimento ${alimento.nombre} se ha añadido a la receta $nombreReceta")
    }

    fun listarReceta(receta: List<Alimento>): String{
        return receta.toString()
    }
}