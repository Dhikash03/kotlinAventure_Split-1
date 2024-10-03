package personnage

import item.Armes
import item.Armure
import item.Item

class Mage(nom : String,
           pointDeVie: Int,
           pointDeVieMax: Int,
           attaque: Int,
           defense: Int,
           endurance: Int,
           vitesse: Int,
           armePrincipal : Armes,
           armure : Armure,
           inventaire : MutableList<Item>,
           var grimoire : MutableList<Sort >) :Personnage(nom, pointDeVie, pointDeVieMax, attaque,defense, endurance, vitesse, armePrincipal, armure, inventaire) {

    override fun toString(): String {
        return "Mage ${super.toString()} (nombre de sorts dans le grimoire ${grimoire.size})"
    }
               fun afficherGrimoire(){
                   var i = 0
                   for(element in grimoire){
                       println(" $i => $element ")
                       i++
                   }
               }


                fun choisirEtLancerSort(){
                    var lancerSort = afficherGrimoire()

                    if (grimoire!=null){

                        println(lancerSort)
                        var choix_sort = readln().toInt()

                        when(choix_sort){

                            1 -> "Boule de feu"
                            2 -> "Sort de soin"
                        }

                        if (choix_sort == 1 || choix_sort == 2){
                            when
                        }



                    }
                }



}