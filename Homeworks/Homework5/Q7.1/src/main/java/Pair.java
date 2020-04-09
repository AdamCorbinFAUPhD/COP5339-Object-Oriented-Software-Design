import java.io.Serializable;

/**
 * This class supports grouping 2 objects together. You can shalow clone this object and it can be serializable
 *
 * @param <K> part 1 of pari
 * @param <V> part 2 of pair
 */
public class Pair<K extends Comparable, V> implements Cloneable, Serializable,Comparable<Pair<K,V>> {

    private K k;
    private V v;

    public Pair(K k, V v) {
        this.k = k;
        this.v = v;

    }

    public K k() {
        return k;
    }

    public V v() {
        return v;
    }

    /**
     * Ensuing classes are the same type and k & v are equivalent
     * @param obj tested if this is has the same contents
     * @return true == equalivent, false something doesnt not match up
     */
    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null) return false;
        if(getClass() != obj.getClass()) return false;
        Pair<K,V> other = (Pair<K,V>) obj;
        return other.k.equals(this.k) && other.v.equals(this.v);
    }

    /**
     * @return the k hashCode plus the v hashcode
     */
    @Override
    public int hashCode() {
        return this.k.hashCode() + this.v.hashCode();
    }

    /**
     * @return formatted (v,k) as a string
     */
    @Override
    public String toString() {
        return super.toString() + "(" + k.toString() + "," + v.toString() + ")";
    }

    /**
     * @return shallow clone of the object
     * @throws CloneNotSupportedException if clone runs into an issue with cloning
     */
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    /**
     * When comparing objects mainly for sorting we will be using the K object to sort
     * @param o object to compare to this
     * @return reference super class docs
     */
    @Override
    public int compareTo(Pair<K, V> o) {
        return k.compareTo(o.k);
    }
}
