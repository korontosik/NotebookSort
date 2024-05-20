import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class MainNotebook {
    public static void main(String[] args) {
        Notebook notebook1 = new Notebook("notebook1", 8, 256, "Windows", "Black", "sn001");
        Notebook notebook2 = new Notebook("notebook2", 16, 256, "Windows"," Black", "sn002");
        Notebook notebook3 = new Notebook("notebook3", 32, 256, "Windows", "Black", "sn003");
        Notebook notebook4 = new Notebook("notebook4", 8, 512, "Windows", "Silver", "sn004");
        Notebook notebook5 = new Notebook("notebook5", 16, 512, "Windows", "Silver", "sn005");
        Notebook notebook6 = new Notebook("notebook6", 32, 512, "Windows", "Silver", "sn006");
        Notebook notebook7 = new Notebook("notebook7", 8, 256, "MacOS", "White", "sn007");
        Notebook notebook8 = new Notebook("notebook8", 16, 256, "MacOS", "White", "sn008");
        Notebook notebook9 = new Notebook("notebook9", 32, 256, "MacOS", "White", "sn009");
        Notebook notebook10 = new Notebook("notebook10", 8, 512, "MacOS", "Silver", "sn010");
        Notebook notebook11 = new Notebook("notebook11", 16, 512, "MacOS", "Silver", "sn011");
        Notebook notebook12 = new Notebook("notebook12", 32, 512, "MacOS", "Silver", "sn0012");
        Notebook notebook13 = new Notebook("notebook13", 64, 1024, "Windows", "Gold", "sn013");
        Notebook notebook14 = new Notebook("notebook14", 64, 1024, "MacOS", "Gold", "sn0014");

        System.out.println(notebook1);
//Создаем множество в котором будут храниться экземпляры класса Notebook

        Set<Notebook> notebooks = new HashSet<>(Arrays.asList(notebook1, notebook2, notebook3, notebook4, notebook5, notebook6, notebook7,
        notebook8, notebook9, notebook10, notebook11, notebook12, notebook13, notebook14));
        // for (Notebook notebook : notebooks) {
        //     System.out.println(notebook);
        // }
        filterNotebooks(notebooks);
    } 

    public static void filterNotebooks(Set<Notebook> notebooks) {
        Map<String, String> filterNum = new HashMap<>();
        filterNum.put("1", "ram");
        filterNum.put("2", "hdd");
        filterNum.put("3", "os");
        filterNum.put("4", "color");

        Scanner scanner = new Scanner(System.in);
        System.out.println("1 - Объем оперативной памяти");
        System.out.println("2 - Объкем жесткого диска");
        System.out.println("3 - Операционная система");
        System.out.println("4 - Цвет");
        System.out.print("Выберите категорию : ");
        String inputNumCategori = scanner.nextLine();

        if (filterNum.containsKey(inputNumCategori)) {
            String selectedFilterNum = filterNum.get(inputNumCategori);
            
            //Фильтрация ноутбуков по выбранной категории.
            Set<Notebook> filtredNotebooks = new HashSet<>();
            if (inputNumCategori.equals("1") || inputNumCategori.equals("2")) {
                System.out.println("Введите минимальный параметр: ");                
            }
            else if (inputNumCategori.equals("3")) {
                System.out.println("Введите 'Windows' или 'MacOS'");
            }
            else if (inputNumCategori.equals("4")) {
                System.out.println("Введите цвет 'Black', 'White', 'Silver', 'Gold'");                
            }
            
            String mineValue = scanner.nextLine();
            switch (selectedFilterNum) {
                case "ram":
                int ram = Integer.parseInt(mineValue);
                    for (Notebook notebook : notebooks) {
                        if (notebook.getRam() >= ram) {
                            filtredNotebooks.add(notebook);                            
                        }
                    }
                    break;
                case "hdd":
                    int hdd = Integer.parseInt(mineValue);
                    for (Notebook notebook : notebooks) {
                        if (notebook.getHdd() >= hdd) {
                            filtredNotebooks.add(notebook);                            
                        }
                    }
                    break;
                case "os":
                    for (Notebook notebook : notebooks) {
                        if (notebook.getOs().equalsIgnoreCase(mineValue)) {
                            filtredNotebooks.add(notebook);
                        }
                        
                    }
                    break;
                case "color":
                    for (Notebook notebook : notebooks) {
                        if (notebook.getColor().equalsIgnoreCase(mineValue)) {
                            filtredNotebooks.add(notebook);
                        }
                    }                
                    break;
                    default:
                    System.out.println("Ошибка ввода");
                                        
                }
                if (filtredNotebooks.isEmpty()){
                    System.out.println("Ноутбуков нет ");
                }
                else{
                    for (Notebook notebook : filtredNotebooks) {
                        System.out.println(notebook);
                    }
                }
        }
        else{
            System.out.println("Такой категории не существует");
        }
        scanner.close();
    }    
    
}
