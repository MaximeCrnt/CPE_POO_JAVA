package model.agents;

import java.awt.Point;
import java.lang.Math;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

import model.comportements.Hebergeur;

/**
 * Cette classe modélise un Animal dans la simulation
 * @author bruno
 *
 */
public class Animal extends Agent {
	
	/** état de santé de l'animal */
	protected Etat etat;
	protected Sexe sexe;
	
	private Hebergeur hebergement = null;
	
	/* 
	 * constructeurs 
	 */
	
	public Animal(Sexe sexe, Point coord) {
		id = Animal.getUniqueId();
		age = 0;
		this.etat = Etat.Normal; //on prefere initialiser etat ici.
		this.sexe = sexe;
		//this.coord=coord;
		this.coord=new Point(coord);
	}
	
	public Animal(Sexe sexe) {
		/* crée un animal avec le sexe passé en paramètre, à la position (0;0), d'âge 0 et lui attribue un id unique
		 * une bonne manière de faire 
		 * en utilisant ce qui existe déjà, une moins bonne
		 */
		this(sexe, new Point(0,0));
		
	}
	
	public Animal() {
		/* crée un animal de sexe femelle, à la position (0;0), d'âge 0 et lui attribue un id unique
		 * une bonne manière de faire 
		 * en utilisant ce qui existe déjà, une moins bonne
		 */
		this(Sexe.Femelle); //Pas besoin de new Point(0,0) car on appelle le constructeur precedent
	}
	
	/*
	 *  Accesseurs et mutateurs
	 */
	
	public Sexe getSexe() {
		return sexe;
	}

	public Etat getEtat() {
		return etat;
	}

	public void setEtat(Etat etat) {
		if(etat != Etat.Mourant) {
			this.etat = etat;
		}
	}
	
	public Hebergeur getHebergement() {
		return hebergement;
	}

	public void setHebergement(Hebergeur hebergement) {
		this.hebergement = hebergement;
	}
	
	/*
	 * Redéfinitions de méthodes d'object
	 */
	
	public boolean equals(Animal animal) {
		//Auto-generated method stub
		return this.age == animal.getAge() && 
				this.sexe == animal.getSexe() &&
				this.etat == animal.getEtat();
	}
	
	
	@Override
	public String toString() {
		return super.toString()+" "+this.sexe;
	}
	
	/* 
	 * comportements d'instance
	 */


	private int random1() {
		//return -1, 0 ou 1
		//random : double [0,1[
		double i_rand = Math.random();
		return (int) (-1+i_rand*3);
	}

	public void seDeplacer() {
		//utiliser Math.random() pour choisir une direction de déplacement
		//On se deplace de -1,0  ou 1 

		this.coord.x += random1();
		this.coord.y += random1();
	}

	public void rencontrer(Animal a) {
		//TODO
	}
	
	public void seNourrir() {
		LinkedList<Etat> liste = new LinkedList<Etat>(Arrays.asList(Etat.values()));
		Iterator<Etat> it = liste.listIterator(liste.indexOf(etat));
		
		if(it.hasNext()) {etat = it.next();}
	}
	
	public static void main(String args[]) {
		//tests unitaires de la classe Animal
		//décommentez les lignes pour approfondir le test unitaire
		//complétez la méthode pour tester les nouvelles fonctionnalités que vous allez implémenter
		Animal a = new Animal();
		Animal b = new Animal(Sexe.Male);
		//Animal c = new Animal(Sexe.Assexue);
		Animal d = new Animal(Sexe.Femelle,new Point(25,30));
		Animal e = new Animal(Sexe.Femelle,new Point(25,30));
		
		/*
		 * les lignes suivantes doivent afficher à terme: NomDeLaClasse n° id_animal(sexe, (position x; position y)).
		 * ex: 28 (FEMELLE, (25;30))
		 */
		System.out.println("*** Animaux créés: **********");
		System.out.println(a);
		System.out.println(a.toString());
		System.out.println(b);
		//System.out.println(c);
		System.out.println(d);
		
		System.out.println("*** Getters et setters **********");
		
		System.out.println(d.getSexe());
		Sexe ss = d.getSexe();
		ss=Sexe.Male;
		System.out.println(d.getSexe());
		
		//les lignes suivantes devraient afficher la même chose....
		
		System.out.println(d.getCoord());
		Point pt = d.getCoord();
		pt.x=50;
		System.out.println(d.getCoord());
		
		
		//ajoutez vos propres tests de getters et setters
		System.out.println(d.getAge());
		d.setAge(8);

		//test vieillir
		System.out.println(d.getAge());
		d.vieillir();
		System.out.println(d.getAge());
		
		//test seDeplacer
		System.out.println("Deplacement");
		System.out.println(d.getCoord());
		d.seDeplacer();
		System.out.println(d.getCoord());
		
		//test id
		
		System.out.println(a.getId());
		System.out.println(b.getId());

		
		/*
		 * Test comparaison
		 */
		
		System.out.println("test");
		System.out.println(e);
		
		Animal ab = new Animal();
		Animal ac = new Animal();
		
		System.out.println(ab==ac);
		System.out.println(d.equals(d));
		
		System.out.println(d==e);
		System.out.println(d.equals(e));
		System.out.println("Bonjour"=="Bonjour");
		System.out.println("Bonjour".equals("Bonjour"));
		
	}



}
