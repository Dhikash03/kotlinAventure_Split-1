package personnage

import item.Armes
import item.Armure
import item.Item
import jeu.TirageDes

class Voleur(nom : String, pointDeVie: Int, pointDeVieMax: Int, attaque: Int, defense: Int, endurance: Int, vitesse: Int, armePrincipal : Armes,armure : Armure,inventaire : MutableList<Item>) : Personnage(nom,pointDeVie,pointDeVieMax,attaque,defense,endurance,
    vitesse,armePrincipal,armure,inventaire) {

    override fun toString(): String {
        return "Voleur ${super.toString()} "
    }

    fun volerItem(victime: Personnage, voleur: Voleur) {
        if (victime.inventaire.isEmpty() == false) {
            var indexAvoler: Int = TirageDes(1,victime.inventaire.size).lance()
            var objet = victime.inventaire[indexAvoler]
            if (objet  == victime.armure) {
                victime.armure = null
                victime.inventaire.remove(objet)
                voleur.armure = armure
                voleur.inventaire.add(objet)
            } else if (objet is Armes) {
                victime.armePrincipal = null
                victime.inventaire.remove(objet)
                voleur.armePrincipal = armePrincipal
                voleur.inventaire.add(objet)
            } else {
                victime.inventaire.remove(objet)
                voleur.inventaire.add(objet)
            }
            println("Le voleur vous à volez $objet")
        }
        else {
            println("L'inventaire de la victime est vide.")
        }
    }
}