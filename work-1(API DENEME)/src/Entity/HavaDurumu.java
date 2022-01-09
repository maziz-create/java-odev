package Entity;

import Core.IEntity;

public class HavaDurumu implements IEntity {
    protected String description;
    protected String temp;

    //setters
    public void setTemp(String temp) {
        this.temp = temp;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    //getters
    public String getDescription() {
        return description;
    }
    public String getTemp() {
        return temp;
    }
}
