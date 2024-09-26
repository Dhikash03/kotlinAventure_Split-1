package item

import jeu.TirageDes
import personnage.Personnage
import item.Armure
import kotlin.io.path.fileVisitor




class Bombe(var nombreDeDes : Int, var maxDe : Int, nom : String, description : String) : Item(nom, description)  {

    override fun utiliser(cible: Personnage) {

        fun utiliser(personnage: Personnage) {
            var degat = TirageDes(this.nombreDeDes, this.maxDe).lance()

            degat = degat - personnage.calculeDefense()
            if (degat < 1) {
                degat = 1
            }
            var nombreDePointDegats = personnage.pointDeVie - degat
            println(" points de dégâts la bombe a fait à la cible ${nombreDePointDegats}")


        }
    }
}