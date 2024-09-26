package jeu

import armure1
import eppe
import eppe1
import eppe2
import item.Armes
import item.Armure
import personnage.Personnage



class Jeu(monstres: List<Personnage>) {
    //Le personage du joueur
    lateinit var joueur: Personnage
    //La liste des monstre a combatre
     var combats: MutableList<Combat> = mutableListOf()
    //Le score
    var score: Int = 0

    // Corps du constructeur
    init {
        // Lancement de la création du personage du joueur
        this.creerPersonnage()
        // Pour chaque monstre dans la liste de monstres
        for (unMonstre in monstres){
            // On créer un combat
            val unCombat= Combat(this,unMonstre)
            combats.add(unCombat)
        }
    }

    fun lancerCombat() {
        for (unCombat in this.combats) {
            unCombat.executerCombat()
            // Mettre à jour le score en fonction du nombre de tours
            val tours = unCombat.nombreTours
            score += calculerScore(tours)
        }
        println("Score final du joueur: $score")
    }

    private fun calculerScore(tours: Int): Int {
        // Par exemple, vous pouvez attribuer plus de points pour moins de tours
        return 500 - tours * 10
    }

    /**
     *  Méthode pour créer le personnage du joueur en demandant les informations à l'utilisateur
     *
     */
    fun creerPersonnage(): Personnage {
        println("Création de votre personnage:")
        println()

        val pointsTotal = 40
        var nomPersonnage: String
        var scoresAttaque: Int
        var scoresDefense: Int
        var scoresEndurance: Int
        var scoresVitesse: Int
       

        do {
            var pointsRestants = pointsTotal

            println("Saisissez le nom de votre personnage:")
            nomPersonnage = readLine()?.trim() ?: "Sans nom"

            println("Saisissez le score d'attaque (points restants: $pointsRestants):")
            scoresAttaque = readLine()?.toIntOrNull() ?: 0
            pointsRestants -= scoresAttaque

            println("Saisissez le score de défense (points restants: $pointsRestants):")
            scoresDefense = readLine()?.toIntOrNull() ?: 0
            pointsRestants -= scoresDefense

            println("Saisissez le score d'endurance (points restants: $pointsRestants):")
            scoresEndurance = readLine()?.toIntOrNull() ?: 0
            pointsRestants -= scoresEndurance

            println("Saisissez le score de vitesse (points restants: $pointsRestants):")
            scoresVitesse = readLine()?.toIntOrNull() ?: 0
            pointsRestants -= scoresVitesse

            if (pointsRestants < 0) {
                println("Erreur : Vous devez utiliser exactement $pointsTotal points. Veuillez recommencer.")
            }

        } while (pointsRestants < 0)

        var pointEndurance = 50+(scoresEndurance * 10)



        val hero = Personnage(nomPersonnage, pointEndurance, pointEndurance, scoresAttaque, scoresDefense, scoresEndurance, scoresVitesse,eppe1,armure1,eppe2,arm)
        this.joueur = hero
        return this.joueur
    }

}