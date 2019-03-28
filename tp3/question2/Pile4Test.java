package question2;

/**
 * Classe-test Pile4Test.
 * 
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 * 
 *          Les classes-test sont documentées ici :
 *          http://junit.sourceforge.net/javadoc/junit/framework/TestCase.html
 *          et sont basées sur le document © 2002 Robert A. Ballance intitulé
 *          «JUnit: Unit Testing Framework».
 * 
 *          Les objets Test (et TestSuite) sont associés aux classes à tester
 *          par la simple relation yyyTest (e.g. qu'un Test de la classe
 *          Name.java se nommera NameTest.java); les deux se retrouvent dans le
 *          même paquetage. Les "engagements" (anglais : "fixture") forment un
 *          ensemble de conditions qui sont vraies pour chaque méthode Test à
 *          exécuter. Il peut y avoir plus d'une méthode Test dans une classe
 *          Test; leur ensemble forme un objet TestSuite. BlueJ découvrira
 *          automatiquement (par introspection) les méthodes Test de votre
 *          classe Test et générera la TestSuite conséquente. Chaque appel d'une
 *          méthode Test sera précédé d'un appel de setUp(), qui réalise les
 *          engagements, et suivi d'un appel à tearDown(), qui les détruit.
 */
public class Pile4Test extends junit.framework.TestCase {
	// Définissez ici les variables d'instance nécessaires à vos engagements;
	// Vous pouvez également les saisir automatiquement du présentoir
	// à l'aide du menu contextuel "Présentoir --> Engagements".
	// Notez cependant que ce dernier ne peut saisir les objets primitifs
	// du présentoir (les objets sans constructeur, comme int, float, etc.).

	/**
	 * Constructeur de la classe-test Pile4Test
	 */
	public Pile4Test() {
	}

	/**
	 * Met en place les engagements.
	 * 
	 * Méthode appelée avant chaque appel de méthode de test.
	 */
	protected void setUp() // throws java.lang.Exception
	{
		// Initialisez ici vos engagements

	}

	/**
	 * Supprime les engagements
	 * 
	 * Méthode appelée après chaque appel de méthode de test.
	 */
	protected void tearDown() // throws java.lang.Exception
	{
		// Libérez ici les ressources engagées par setUp()
	}


    public void testMontest() throws Exception
    {
        question2.Pile4 pile41 = new question2.Pile4();
        question2.Pile4 pile42 = new question2.Pile4();
        pile41.empiler(1);
        pile41.empiler(2);
        pile42.empiler(1);
        assertEquals(2, pile41.taille());
        assertEquals(false, pile41.equals(pile42));
        pile42.empiler(2);
        assertEquals(true, pile42.equals(pile41));
        assertEquals(2, pile41.depiler());
        assertEquals(true, pile41.equals(pile41));
    }
}

