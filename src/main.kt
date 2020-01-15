import model.Alimento

//Listas
var listaIngredientes:List<Alimento> = listOf<Alimento>()
var listaRecetas:HashMap<String, List<Alimento>> = hashMapOf()
var listaGruposNoRepes:HashMap<Int, String> = hashMapOf()
var listaTempIngredientes:List<Alimento> = listOf()

val menu:String = """
        Selecciona la opción deseada
        1. Hacer una receta
        2. Ver mis recetas
        3. Salir
    """.trimIndent()

fun main (args:Array<String>){

    crearAlimentosIniciales()

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
    var ingrediente:String = "SinIngrediente"
    var grupo:String = "SinGrupo"

    //Proceso
    do {
        println("Escribe el nombre para la receta")
        nombreReceta = readLine()?:"DSC"

        if (nombreReceta.isNullOrEmpty()) {
            println("No has escrito nada")
        }else if(listaRecetas.containsKey(nombreReceta)){
            println("Ya existe una receta con ese nombre")
        }
    } while (nombreReceta.isNullOrEmpty() || listaRecetas.containsKey(nombreReceta))

    println("El nombre de la receta es $nombreReceta")

    var ingredientesReceta:List<Alimento> = listOf<Alimento>()

    do{
        do {
            println("Elige el grupo de alimento:")
            var num = 1
            for(grupoLista in listaIngredientes) {
                if (!listaGruposNoRepes.containsValue(grupoLista.grupo)) {
                    listaGruposNoRepes[num] = grupoLista.grupo
                    println("$num. ${grupoLista.grupo}")
                    num++
                }
            }
            var grupo = readLine()?:"DSC"

            if (grupo.isNotEmpty()) {

                println("Elige un ingrediente:")
                var num = 1
                for(ingredientes in listaIngredientes){
                    if (ingredientes.grupo == listaGruposNoRepes[grupo.toInt()]) {
                        listaTempIngredientes += ingredientes
                        println("$num. ${ingredientes.nombre}")
                        num++
                    }
                }

                ingrediente = readLine()?: "DSC"

                if (ingrediente.isNotEmpty()) {

                    ingredientesReceta += listaTempIngredientes[ingrediente.toInt() - 1]

                    println("El ingrediente ${listaTempIngredientes[ingrediente.toInt() - 1].nombre} se ha añadido a la lista")
                    println("¿Deseas añadir otro ingrediente? S o N")

                    seguir = readLine() ?: "DSC"

                } else if(ingrediente.isEmpty() || ingrediente.toInt() >= listaTempIngredientes.size){
                    println("El ingrediente seleccionado no esta en la lista")
                }
            }else{
                println("El grupo seleccionado no esta en la lista")
            }
            listaGruposNoRepes.clear()
            listaTempIngredientes = emptyList()
        } while (seguir.equals("S") || seguir.equals("s"))

    } while (ingredientesReceta.isNullOrEmpty() && ingrediente.isNullOrEmpty())

    listaRecetas.put(nombreReceta, ingredientesReceta)
    ingredientesReceta = emptyList()
}

fun viewRecipe(){

    if (listaRecetas.isNullOrEmpty()){
        println("No hay recetas en la lista\n")
    }else {
        println("Lista de recetas")
        for(auxReceta in listaRecetas){
            println("Nombre de la receta: ${auxReceta.key}")
            for (j: Int in 0..(auxReceta.value.size -1)) {
                println("Ingrediente $j:  ${auxReceta.value[j].nombre}")
            }
            print("\n")
        }
    }
}

fun crearAlimentosIniciales(){
    var auxAlimento = Alimento("Agua", 0, "litros", "Agua")
    listaIngredientes += auxAlimento
    auxAlimento = Alimento("Leche", 0, "litros","Lacteos")
    listaIngredientes += auxAlimento
    auxAlimento = Alimento("Carne", 0, "kilogramos", "Carnes")
    listaIngredientes += auxAlimento
    auxAlimento = Alimento("Lechuga", 0, "kilogramos", "Verduras")
    listaIngredientes += auxAlimento
    auxAlimento = Alimento("Fresa", 0, "kilogramos","Frutas")
    listaIngredientes += auxAlimento
    auxAlimento = Alimento("Plátano", 0, "kilogramos","Frutas")
    listaIngredientes += auxAlimento
    auxAlimento = Alimento("Uva", 0, "kilogramos","Frutas")
    listaIngredientes += auxAlimento
    auxAlimento = Alimento("Manzana", 0, "kilogramos","Frutas")
    listaIngredientes += auxAlimento
    auxAlimento = Alimento("Naranja", 0, "kilogramos","Frutas")
    listaIngredientes += auxAlimento
    auxAlimento = Alimento("Pera", 0, "kilogramos","Frutas")
    listaIngredientes += auxAlimento
    auxAlimento = Alimento("Cereza", 0, "kilogramos","Frutas")
    listaIngredientes += auxAlimento
    auxAlimento = Alimento("Avena", 0,"gramos", "Cereales")
    listaIngredientes += auxAlimento
    auxAlimento = Alimento("Trigo", 0, "gramos", "Cereales")
    listaIngredientes += auxAlimento
    auxAlimento = Alimento("Arroz", 0, "gramos", "Cereales")
    listaIngredientes += auxAlimento
    auxAlimento = Alimento("Maiz", 0, "gramos", "Cereales")
    listaIngredientes += auxAlimento
    auxAlimento = Alimento("Huevo", 0, "unidades", "Huevos")
    listaIngredientes += auxAlimento
    auxAlimento = Alimento("Aceite", 0, "litros", "Aceites")
    listaIngredientes += auxAlimento
}

