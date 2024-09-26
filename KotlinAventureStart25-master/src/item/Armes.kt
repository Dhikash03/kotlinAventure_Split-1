package item

import com.sun.jdi.Type
import jeu.TirageDes
import personnage.Personnage

class Armes(nom : String, description : String,var type: TypeArme,var qualite: Qualite) : Item(nom,description) {
    fun calculDegat(): Int {
        var lanceDes = TirageDes(this.type.nombreDes,this.type.valeurDeMax).lance()

        var degat = lanceDes

        if (lanceDes >= this.type.activationCritique){
            degat = degat * this.type.multiplicateurCritique
            println("Coup critique !")
        }

        degat = degat + this.qualite.bonusRarete

        return degat


    }


    override fun utiliser(personnage: Personnage){
    }



}


