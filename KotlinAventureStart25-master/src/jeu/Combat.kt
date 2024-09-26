package jeu

import personnage.Personnage
import kotlin.math.ln

class Combat(
    val jeu: Jeu,
    val monstre: Personnage
) {
    var nombreTours: Int = 1

    // Méthode pour simuler un tour de combat du joueur
    fun tourDeJoueur() {
        println("\u001B[31m---Tour de ${this.jeu.joueur.nom} (pv: ${this.jeu.joueur.pointDeVie}) ---")
        println("Chosir une action : ")
        println("1 -> Attaquer \n 2 -> passer")
        var choix = readln().toInt()

        when (choix) {
            1 -> " ${this.jeu.joueur.attaque(monstre)}"
            2 -> "${this.jeu.joueur}passe son tour"
            else -> "${this.jeu.joueur} n'a rien choisit"
        }


        println("\u001b[0m")
    }

        // Méthode pour simuler un tour de combat du monstre
        fun tourDeMonstre() {
            println("\u001B[31m---Tour de ${monstre.nom} (pv: ${monstre.pointDeVie}) ---")
            println("Chosir une action : ")

            val nbAlea = (1..100).random()

            if (nbAlea <= 70) {
                monstre.attaque(this.jeu.joueur)
            } else {
                println("${monstre.nom} passe son tour")
            }
            println("\u001b[0m")
                                        //TODO Mission 1.3
        }
        // Méthode pour exécuter le combat complet

        fun executerCombat() {
            println("Début du combat : ${this.jeu.joueur.nom} vs ${monstre.nom}")
            //La vitesse indique qui commence
            var tourJoueur = this.jeu.joueur.vitesse >= this.monstre.vitesse
            //Tant que le joueur et le monstre sont vivants
            while (this.jeu.joueur.pointDeVie > 0 && monstre.pointDeVie > 0) {
                println("Tours de jeu : ${nombreTours}")
                if (tourJoueur) {
                    tourDeJoueur()
                } else {
                    tourDeMonstre()
                }
                nombreTours++
                tourJoueur = !tourJoueur // Alternance des tours entre le joueur et le monstre
                println("${this.jeu.joueur.nom}: ${this.jeu.joueur.pointDeVie} points de vie | ${monstre.nom}: ${monstre.pointDeVie} points de vie")
                println("")
            }

            if (this.jeu.joueur.pointDeVie <= 0) {
                println("Game over ! ${this.jeu.joueur.nom} a été vaincu !")
                println("Le combat recommence")

                this.jeu.joueur.pointDeVie = this.jeu.joueur.pointDeVieMax
                this.monstre.pointDeVie = this.monstre.pointDeVieMax
                this.executerCombat()
            } else {
                println("BRAVO ! ${monstre.nom} a été vaincu !")
            }
        }
    }



