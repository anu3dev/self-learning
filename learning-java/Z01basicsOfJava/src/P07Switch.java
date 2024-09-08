class SwitchCaseInJavaEx1 {
	public SwitchCaseInJavaEx1() {
		String day = "Mon";
        int alarmTime = 0;
 
        alarmTime = switch (day){
            case "Sat", "Sun" -> 6;
            case "Mon", "Tue", "Thu", "Fri" -> 7;
            case "Wed" -> 8;
            default -> 12;
        };

        System.out.println(alarmTime);
	}
}

public class P07Switch {
	public static void main(String[] args) {
		new SwitchCaseInJavaEx1();
	}
}
