package personnage

import eppe1
import eppe2
import item.Armes
import item.Armure
import item.Item
import item.Potion
import item.Bombe
import item.TypeArmure
import jeu.Jeu
import java.security.Principal
import kotlin.math.min

open class Personnage(
    val nom: String,
    var pointDeVie: Int,
    val pointDeVieMax: Int,
    var attaque: Int,
    var defense: Int,
    var endurance: Int,
    var vitesse: Int,
    var armePrincipal: Armes?,
    var armure: Armure?,
    var inventaire : MutableList<Item> = mutableListOf<Item>()
) {

    fun calculeDefense(): Int {

        var defenseTotal = defense

        if (this.armure != null) {
            defenseTotal += this.armure!!.calculProtection()
        }
        //TODO Mission 4.2

        return defenseTotal;
    }

    // Méthode pour attaquer un adversaire
    open fun attaque(adversaire: Personnage) {
        if (this.armePrincipal != null) {
            attaque += armePrincipal!!.calculDegat()
        }
        val degats = this.attaque / 2
        adversaire.pointDeVie -= degats
        println("$nom attaque ${adversaire.nom} avec une attaque de base et inflige $degats points de dégâts.")
    }

    open fun equipeArmes(armes: Armes) {

        if (armes in this.inventaire) {
            armePrincipal = armes
        }
        println("$nom equipe $armes")
    }

    fun equipeArmure(armures: Armure) {

        if (armures in this.inventaire) {
            armure = armures
        }
        println("$nom equipe $armure")
    }

    fun avoirPotion(): Boolean {
        var resultat = false
        for (item in inventaire) {
            if (item is Potion)
                resultat = true
        }
        return resultat
    }

    fun avoirBombe(): Boolean {
        var resultat = false
        for (item in inventaire) {
            if (item is Bombe)
                resultat = true
        }
        return resultat
    }

    fun boirePotion() {
        var laPotion: Potion ?= null
        var hpT0 = this.pointDeVie

        if (avoirPotion() == true) {
            for (item in inventaire) {
                if (item is Potion) {
                    laPotion = item
                    break
                }
            }

            var hp = this.pointDeVie + laPotion!!.soin

            if (hp > this.pointDeVieMax)
                hp = this.pointDeVieMax - hpT0
            else
                hp -= hpT0

            this.pointDeVie += laPotion!!.soin
            this.pointDeVie = min(this.pointDeVie,this.pointDeVieMax)
            for (item in inventaire) {
                if (item is Potion) {
                    this.inventaire.remove(item)
                    break
                }
            }

            println("Vous avez bu ${laPotion.nom}, +${hp}pv récupéré")
        }
        else {
            println("Vous n'avez pas de potion dans l'inventaire.")
        }
    }

    fun afficheInventaire(){
        var i = 0
        for (element in inventaire){
            println("$i => $element")
            i++
        }
    }

    override fun toString(): String {
        return "$nom (PV: $pointDeVie/$pointDeVieMax, Attaque: $attaque, Défense: $defense, Endurance: $endurance, Vitesse: $vitesse)"
    }


}