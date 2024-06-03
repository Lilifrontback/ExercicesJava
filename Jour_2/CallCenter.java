public class CallCenter {
    public void dispatchCall(Call call) {
        Respondent respondent = new Respondent();
        Manager manager = new Manager();
        Director director = new Director();


        if (respondent.isFree) {
           respondent.handleCall(call);
            System.out.println("Respondent handling call: " + respondent.name + respondent.employee);
        } else if (manager.isFree) {
             manager.handleCall(call);
            System.out.println("Manager handling call: "  + manager.name + manager.employee);
        } else {
          director.handleCall(call);
            System.out.println("Director handling call: "  + director.name + director.employee);
        }

    }



    public static void main(String[] args) {
        CallCenter callCenter = new CallCenter();
        Call incomingCall = new Call("John Doe");
        callCenter.dispatchCall(incomingCall);

    }




}