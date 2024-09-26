package item

import personnage.Personnage

class Potion (var soin : Int, nom : String, description : String) : Item(nom,description){

    override fun utiliser(personnage: Personnage) : Unit{



    }

}