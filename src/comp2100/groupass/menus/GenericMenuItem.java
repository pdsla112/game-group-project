package comp2100.groupass.menus;


/**
 * generic menu item without extra features
 */
public class GenericMenuItem implements MenuItem {
    protected String optionText;

    public GenericMenuItem(String text) {
        this.optionText = text;
    }

    public String getOptionText() {
        return optionText;
    }



}
