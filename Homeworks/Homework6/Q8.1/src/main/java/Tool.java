interface Tool extends Cloneable {
    /**
     * @return string of the name of the tool
     */
    String getName();

    /**
     * simple interface where the tool will define its usage
     */
    void use();
}
