
class Project {
    private String name;
    private String description;
    private int initialCost;

    public String elevatorPitch() {
        return name + "(" + initialCost + ") : " + description;
    }

    public Project() {
    }

    public Project(String name) {
        // setting the color attribute to the value from the color parameter
        this.name = name;
    }

    public Project(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Project(String name, String description, int initialCost) {
        this.name = name;
        this.description = description;
        this.initialCost = initialCost;
    }

    // getter
    public String getName() {
        return name;
    }

    // setter
    public void setName(String projectName) {
        name = projectName;
    }

    // getter
    public String getDescription() {
        return description;
    }

    // setter
    public void setDescription(String description) {
        this.description = description;
    }

    // getter
    public int getInitialCost() {
        return initialCost;
    }

    // setter
    public void setInitialCost(int cost) {
        initialCost = cost;
    }
}
