
//Listas
val listaIngredientes:List<String> = listOf<String>("Agua", "Leche", "Carne", "Verduras", "Frutas", "Cereal", "Huevos", "Aceite")
var listaRecetas:HashMap<String, List<String>> = hashMapOf()

val menu:String = """
        Selecciona la opción deseada
        1. Hacer una receta
        2. Ver mis recetas
        3. Salir
    """.trimIndent()

fun main (args:Array<String>){

    //Empieza el programa

    println("\n:: Bienvenido a Recipe Maker ::\n")

    do {

        println(menu)

        val opcion:String = readLine()?:"DSC"

        when(opcion){
            "1" -> {
                makeRecipe()

            }

            "2" -> {
                viewRecipe()
            }

            "3" -> println("Saliendo del Programa")
            else -> print("La opción no es valida\n")
        }

    }while (!opcion.equals("3"))

}

fun makeRecipe(){

    //Variables
    var nombreReceta:String
    var seguir:String = "N"
    var ingrediente:String

    //Proceso
    do {
        println("Escribe el nombre para la receta")
        nombreReceta = readLine()?:"DSC"

        if (nombreReceta.isNullOrEmpty()) {
            println("No has escrito nada, escribe un nombre para la receta")
        }
    } while (nombreReceta.isNullOrEmpty())

    println("El nombre de la receta es $nombreReceta")

    var ingredientesReceta:List<String> = listOf<String>()

    do{
        do {
            println("Elige los ingredientes:\n")
            var num = 1
            for(ingredientes in listaIngredientes){
                println("$num. $ingredientes")
                num++
            }

            ingrediente = readLine()?:"DSC"

            if (ingrediente.isNotEmpty()) {

                ingredientesReceta += listaIngredientes.get(ingrediente.toInt() - 1)

                println("El ingrediente ${listaIngredientes.get(ingrediente.toInt() - 1)} se ha añadido a la lista")
                println("La lista contiene $ingredientesReceta")
                println("¿Deseas añadir otro ingrediente? S o N")

                seguir = readLine()?:"DSC"

            } else {
                println("El ingrediente añadido no esta en la lista")
            }
        } while (seguir.equals("S") || seguir.equals("s"))

        listaRecetas.put(nombreReceta, ingredientesReceta)

    } while (ingredientesReceta.isNullOrEmpty() && ingrediente.isNullOrEmpty())
}

fun viewRecipe(){

    if (listaRecetas.isNullOrEmpty()){
        println("No hay recetas en la lista\n")
    }else {
        for(auxReceta in listaRecetas){
            println("Nombre de la receta: ${auxReceta.key}")
            println("Ingredientes: ${auxReceta.value} \n")
        }
    }
}

