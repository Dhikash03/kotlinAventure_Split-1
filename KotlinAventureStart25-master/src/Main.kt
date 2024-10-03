import item.Armes
import item.Armure
import item.Bombe
import item.Potion
import item.Qualite
import item.TypeArme
import item.TypeArmure
import jeu.Jeu
import personnage.Personnage

//Créattion des qualités des objets
val qualiteCommun = Qualite("commun", 0, "\u001B[32m")
val qualiteRare = Qualite("rare", 1, couleur = "\u001B[34m")
val qualiteEpic = Qualite("epic", 2, "\u001B[35m")
val qualiteLegendaire = Qualite("legendaire", 3, "\u001B[33m")

val typeEppe1 = TypeArme(1,8,5,5)
val typeEppe2 = TypeArme(1,8,3,20)
val eppe1 = Armes("Epée Longue ", "Une épee longue tranchante",typeEppe1,qualiteCommun)
val eppe2 = Armes("Hache ", "Une grosse hachee",typeEppe2,qualiteCommun)
var typeArmure1 = TypeArmure("Pectoral",5)
var typeArmure2 = TypeArmure("chemise à chaîne",4)
val armure1 = Armure("Cotte de mailles en adamantine +1", "Cotte de mailles plus lourde mais aussi plus solide",typeArmure1,qualiteEpic)
val armure2 = Armure("Le manteau de la nuit", "Une armure en cuir obscure",typeArmure2,qualiteLegendaire)
val potion1 = Potion(20, "Potion de soins" , "potion qui soigne")
val potion2 = Potion(30, "Grande Potion de soins", "grande potion qui soigne")
val bombe1 = Bombe(4,6,"feu grégois", "bomme explosif")
//TODO Sprint 1 Mission 2A et 2B Création des types d'armes/armures

//TODO Sprint 2 : Création de sorts

fun main(args: Array<String>) {
    // TODO Intemission 4 : Création des items ( armes, armures potions, bombes )

    //Création des monstres
    val gobelin = Personnage(
        "Gob le gobelin",
        pointDeVie = 20,
        pointDeVieMax = 20,
        attaque = 5,
        defense = 4,
        vitesse = 11,
        endurance = 6,
        armePrincipal = eppe1,
        armure = armure1)

    val Kraken = Personnage(
        "Kraken",
        pointDeVie = 152,
        pointDeVieMax = 472,
        attaque = 18,
        defense = 15,
        vitesse = 14,
        endurance = 22,
        armePrincipal = eppe2,
        armure = armure1)

    val Flagelleur  = Personnage(
        "Flagelleur mental",
        pointDeVie = 50,
        pointDeVieMax = 71,
        attaque = 15,
        defense = 7,
        vitesse = 12,
        endurance = 10,
        armePrincipal = eppe1,
        armure = armure1)

    // TODO Intermission 1 : Ajouter d'autres monstres

    //TODO On ajoute les monstres a la liste de monstres du jeu
    val jeu = Jeu(listOf( gobelin,Kraken,Flagelleur))
    //Lancement du jeu
    jeu.lancerCombat()
}