import java.util.ArrayList;

public class Portfolio {
    private ArrayList<Project> projects = new ArrayList<Project>();

    public Portfolio addProject(Project project) {
        projects.add(project);
        return this;
    }

    public ArrayList<Project> getProjects() {
        return projects;
    }

    public int getPortfolioCost() {
        int sum = 0;
        for (Project project : projects) {
            sum += project.getInitialCost();
        }
        return sum;
    }

    public void showPortfolio() {
        for (Project project : projects) {
            System.out.println(project.elevatorPitch());
        }
        int projectCost = getPortfolioCost();
        System.out.println("The total cost of all projects is: " + projectCost);
    }
}