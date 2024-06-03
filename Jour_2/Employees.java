public class Employees {
    public boolean isFree;
    public String employee;
    public String name;



    public Employees() {
        this.isFree = true;
    }
    public void handleCall(Call call) {
        // Handle the call
        System.out.println("Respondent handling call from: " + call.getCallerName());
    }

}
