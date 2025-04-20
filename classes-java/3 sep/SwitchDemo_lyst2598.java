public class SwitchDemo {
    public static void main(String[] args) {

        String day = "Mon";
        int alarmTime = 0;
        // sat, sun = 6, mon-fri = 7 and wed = 8

        alarmTime = switch (day){
            case "Sat", "Sun" -> 6;

            case "Mon", "Tue", "Thu", "Fri" -> 7;

            case "Wed" -> 8;

            default -> 12;

        };


        System.out.println(alarmTime);
    }
}
