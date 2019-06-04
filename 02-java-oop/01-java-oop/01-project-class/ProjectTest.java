import javax.sound.sampled.Port;

class ProjectTest {
    public static void main(String[] args) {
        Portfolio portfolio = new Portfolio();
        Project evilPlan = new Project("Operation X");
        String name = evilPlan.getName();
        // System.out.println("The Project name is: " + name);
        Project worldDomination = new Project();
        // Project car = new Project();
        worldDomination.setDescription(
                "Gee, Brain, what do you want to do tonight? / The same thing we do every night, Pinky - try to take over the world!");
        worldDomination.setName("Pinky and The Brain");
        worldDomination.setInitialCost(1000000);
        evilPlan.setInitialCost(3);
        // System.out.println("The Project is :"
        // + worldDomination.elevatorPitch(worldDomination.getName(),
        // worldDomination.getDescription()));
        portfolio.addProject(worldDomination).addProject(evilPlan);
        // System.out.println(portfolio.getProjects());
        // System.out.println(portfolio.getPortfolioCost());
        portfolio.showPortfolio();
    }
}
