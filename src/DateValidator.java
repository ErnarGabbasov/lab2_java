import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateValidator
{
    public static void main(String[] args)
    {
        String date1 = "29/02/2000";
        String date2 = "30/04/2003";
        String date3 = "01/01/2003";
        String date4 = "29/02/2001";
        String date5 = "30-04-2003";
        String date6 = "1/1/1899";
        String date7 = "01.11/2099";
        String date8 = "11-09-3444";
        String date9 = "12/12/1599";
        String date10 = "01/01/1600";
        String date11 = "12/12/9999";
        String date12 = "01/01/10000";

        // регулярное выражение для проверки валидности даты в формате "dd/mm/yyyy"
        String regex = "^(0[1-9]|1\\d|2\\d|3[01])/(0[1-9]|1[0-2])/((16\\d{2})|([2-9]\\d{3}))$";
        Pattern pattern = Pattern.compile(regex); // Создается объект Pattern с использованием регулярного выражения

        System.out.println("Результаты:");

        // Вызывается метод isValidDate для каждой из дат и выводится результат
        System.out.println(date1 + " - " + isValidDate(date1, pattern));
        System.out.println(date2 + " - " + isValidDate(date2, pattern));
        System.out.println(date3 + " - " + isValidDate(date3, pattern));
        System.out.println(date4 + " - " + isValidDate(date4, pattern));
        System.out.println(date5 + " - " + isValidDate(date5, pattern));
        System.out.println(date6 + " - " + isValidDate(date6, pattern));
        System.out.println(date7 + " - " + isValidDate(date7, pattern));
        System.out.println(date8 + " - " + isValidDate(date8, pattern));
        System.out.println(date9 + " - " + isValidDate(date9, pattern));
        System.out.println(date10 + " - " + isValidDate(date10, pattern));
        System.out.println(date11 + " - " + isValidDate(date11, pattern));
        System.out.println(date12 + " - " + isValidDate(date12, pattern));
    }

    private static boolean isValidDate(String date, Pattern pattern) // Принимает два аргумента: строку date и объект Pattern
    {
        Matcher matcher = pattern.matcher(date); // Создается объект Matcher с использованием регулярного выражения из pattern и строки date
        //Если совпадение найдено, то: извлекаются значения дня, месяца и года из групп регулярного выражения
        if (matcher.matches())
        {
            int day = Integer.parseInt(matcher.group(1));
            int month = Integer.parseInt(matcher.group(2));
            int year = Integer.parseInt(matcher.group(3));

            boolean isLeapYear = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0); // Проверка на високосный год
            if (month == 2 && day > 29)
            {
                return false;
            } else if (month == 2 && day == 29 && !isLeapYear) {
                return false;
            }
            return true;
        }
        return false; // Если совпадение не найдено
    }
}