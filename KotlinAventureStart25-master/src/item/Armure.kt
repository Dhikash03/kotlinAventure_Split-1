package item

import personnage.Personnage

class Armure(nom : String, description : String, var typeArmure: TypeArmure,var qualite: Qualite) : Item(nom,description) {

    fun calculProtection() : Int{
        return this.typeArmure.bonusType + this.qualite.bonusRarete
    }
    override fun utiliser(personnage: Personnage) : Unit{



    }
}




