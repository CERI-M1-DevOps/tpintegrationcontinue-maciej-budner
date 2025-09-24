package liste;
/**
 * Représente une liste chaînée simple.
 */
public class ListeSimple {
    private long size;
    Noeud tete;

    /**
     * Description de la méthode
     * recupére la longueur de la liste
     * @return taille de la liste
     */
    public long getSize() {
        return size;
    }

    /**
     * Description de la méthode
     * ajoute un noeud dans la list
     * @param element l'élément à rajouter
     */
    public void ajout(int element) {
        tete = new Noeud(element, tete);
        size++;
    }

    /**
     * Description de la méthode
     * modifie le premier noeud qui a l'element que l'on a donner
     * @param element l'élément à rechercher
     * @param nouvelleValeur la nouvelle valeur à mettre
     */
    public void modifiePremier(Object element, Object nouvelleValeur) {
        Noeud courant = tete;
        while (courant != null && courant.getElement() != element){
            courant = courant.getSuivant();
        }
        if (courant != null){
            courant.setElement(nouvelleValeur);
        }
    }

    /**
     * Description de la méthode
     * modifie toute les element des noeud qui sont egal a l'element rentré
     * @param element l'élément à rechercher
     * @param nouvelleValeur la nouvelle valeur à mettre
     */
    public void modifieTous(Object element, Object nouvelleValeur) {
        Noeud courant = tete;
        while (courant != null) {
            if (courant.getElement() == element)
                courant.setElement(nouvelleValeur);
            courant = courant.getSuivant();
        }
    }

    /**
     * Description de la méthode
     * affiche la liste sous forme d'un string
     * @return la Liste sous forme de string
     */
    public String toString() {
        StringBuilder sb = new StringBuilder("ListeSimple(");
        Noeud n = tete;
        while (n != null) {
            sb.append(n);
            n = n.getSuivant();
            if (n != null)
                sb.append(", ");
        }
        sb.append(")");
        return sb.toString();
    }

    /**
     * Description de la méthode
     * suprime le premier noeud de la tete
     * @param element supprime le premier maillon qui a cet élément
     */
    public void supprimePremier(Object element) {
        if (tete != null) {
            if (tete.getElement() == element) {
                tete = tete.getSuivant();
                size--;
                return;
            }
            Noeud precedent = tete;
            Noeud courant = tete.getSuivant();
            while (courant != null && courant.getElement() != element) {
                precedent = precedent.getSuivant();
                courant = courant.getSuivant();
            }
            if (courant != null) {
                precedent.setSuivant(courant.getSuivant());
                size--;
            }
        }
    }

    /**
     * Description de la méthode
     * inisialise la supresion de tout la liste recurcivement
     * @param element supprime tous les maillons qui ont cet élément
     */
    public void supprimeTous(int element) {
        tete = supprimeTousRecurs(element, tete);
    }

    /**
     * Description de la méthode
     * suprime tout les noeud de la liste recurcivement
     * @param element l'élément à supprimer
     * @param tete la tête de la sous-liste
     * @return le maillon suivant ou null
     */
    public Noeud supprimeTousRecurs(Object element, Noeud tete) {
        if (tete != null) {
            Noeud suiteListe = supprimeTousRecurs(element, tete.getSuivant());
            if (tete.getElement() == element) {
                size--;
                return suiteListe;
            } else {
                tete.setSuivant(suiteListe);
                return tete;
            }
        } else return null;
    }

    /**
     * Description de la méthode
     * recupére l'avant dernier noeud de la liste
     * @return le maillon avant dernier maillon
     */
    public Noeud getAvantDernier() {
        if (tete == null || tete.getSuivant() == null)
            return null;
        else {
            Noeud courant = tete;
            Noeud suivant = courant.getSuivant();
            while (suivant.getSuivant() != null) {
                courant = suivant;
                suivant = suivant.getSuivant();
            }
            return courant;
        }
    }

    /**
     * Description de la méthode
     * inverse l'ordre de la liste
     */
    public void inverser() {
        Noeud precedent = null;
        Noeud courant = tete;
        while (courant != null) {
            Noeud next = courant.getSuivant();
            courant.setSuivant(precedent);
            precedent = courant;
            courant = next;
        }
        tete = precedent;
    }

    /**
     * Description de la méthode
     * recupére le noeud precedent
     * @param r le noeud dont on veut le précédent
     * @return le maillon precedent
     */
    public Noeud getPrecedent(Noeud r) {
        Noeud precedent = tete;
        Noeud courant = precedent.getSuivant();
        while (courant != r) {
            precedent = courant;
            courant = courant.getSuivant();
        }
        return precedent;
    }

    /**
     * Description de la méthode
     * echange de position entre les 2 noeud de la liste
     * @param r1 premier noeud à échanger
     * @param r2 second noeud à échanger
     */
    public void echanger(Noeud r1, Noeud r2) {
        if (r1 != r2){
            Noeud precedentR1;
            Noeud precedentR2;
            if (r1 != tete && r2 != tete) {
                precedentR1 = getPrecedent(r1);
                precedentR2 = getPrecedent(r2);
                precedentR1.setSuivant(r2);
                precedentR2.setSuivant(r1);
            }
            else if (r1 == tete) {
                precedentR2 = getPrecedent(r2);
                precedentR2.setSuivant(tete);
                tete = r2;
            }
            else{
                precedentR1 = getPrecedent(r1);
                precedentR1.setSuivant(tete);
                tete = r1;
            }
            Noeud temp = r2.getSuivant();
            r2.setSuivant(r1.getSuivant());
            r1.setSuivant(temp);
        }
    }
}
