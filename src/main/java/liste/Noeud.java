package liste;
/**
 * Représente un noeud.
 */
public class Noeud {
    private Object element;
    private Noeud suivant;

    /**
     * Description de la méthode
     * constructeur du noeud
     * @param e l'élément à stocker dans le noeud
     * @param suivant le noeud suivant
     */
    public Noeud(int e, Noeud suivant) {
        element = e;
        this.suivant = suivant;
    }

    /**
     * Description de la méthode
     * recupére l'element du noeud
     * @return element l'élément à recup
     */
    public Object getElement() {
        return element;
    }

    /**
     * Description de la méthode
     * ajoute/change un element dans le noeud
     * @param element l'élément à définir
     */
    public void setElement(Object element) {
        this.element = element;
    }

    /**
     * Description de la méthode
     * recupére le noeud suivant
     * @return suivant noeud suivant
     */
    public Noeud getSuivant() {
        return suivant;
    }

    /**
     * Description de la méthode
     * ajoute/change un noeud suivant du noeud
     * @param suivant le noeud suivant à définir
     */
    public void setSuivant(Noeud suivant) {
        this.suivant = suivant;
    }

    /**
     * Description de la méthode
     * affiche le noeud sous la forme d'un string
     * @return le Noeud sous forme de string
     */
    public String toString() {
        return "Noeud(" + element + ")";
    }
}
