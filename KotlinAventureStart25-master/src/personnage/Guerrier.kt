package personnage

import eppe1
import item.Armes
import item.Armure
import item.Item

class Guerrier (
    nom: String,
    pointDeVie: Int,
    pointDeVieMax: Int,
    attaque: Int,
    defense: Int,
    endurance: Int,
    vitesse: Int,
    armePrincipal: Armes,
    armure: Armure,
    inventaire: MutableList<Item>,
    var armeSeconde : Armes
): Personnage(nom,pointDeVie,pointDeVieMax,attaque,defense,endurance,
    vitesse,armePrincipal,armure,inventaire) {
    fun afficherArmes() {}

    override fun equipeArmes(armes: Armes) {

        println("Choisissez votre emplacement : \n 1=> Principal, \n 2 => Secondaire")

        var choix = readln().toInt()// j'adore le caca
        do {


            when (choix) {
                1 -> {
                    this.armePrincipal = armes
                    println("${armes.nom} est equiper en arme principale")
                }

                2 -> {
                    this.armeSeconde = armes
                    println("${armes.nom} est equiper en arme secondaire")
                }

                else -> println(" Ereur choix imposible")
            }
        } while (choix > 2 || choix < 1)
    }


    override fun attaque(adversaire: Personnage) {

        var degat = 1
        var bonusAttaque = attaque/2
        var defCible= adversaire.calculeDefense()

        if(armeSeconde!=null){

            armeSeconde.calculDegat()
            degat+=bonusAttaque+ defCible
        }
        else {
            degat+=bonusAttaque-defCible
        }

        if (degat>1){
            degat=1
        }
        var degatfin= degat-defCible
        println("$nom inflige $degat à ${adversaire.nom}")
    }

    }



