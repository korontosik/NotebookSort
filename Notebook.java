/*Задание
-Подумать над структурой класса Ноутбук для магазина техники - выделить поля и
методы. Реализовать в java.
-Создать множество ноутбуков.
-Написать метод, который будет запрашивать у пользователя критерий (или критерии)
фильтрации и выведет ноутбуки, отвечающие фильтру. Критерии фильтрации можно
хранить в Map. Например:
“Введите цифру, соответствующую необходимому критерию:
1 - ОЗУ
2 - Объем ЖД
3 - Операционная система
4 - Цвет …
-Далее нужно запросить минимальные значения для указанных критериев - сохранить
параметры фильтрации можно также в Map.
-Отфильтровать ноутбуки их первоначального множества и вывести проходящие по
условиям. */

import java.util.Objects;

public class Notebook {
    String model;  //Модель
    int ram;       //ОЗУ
    int hdd;       //Объем ЖД
    String os;     //ОС
    String color;  // Цвет
    String sn;        // Серийный номер

    public Notebook(String model, int ram, int hdd, String os, String color, String sn){
        this.model = model;
        this.ram = ram;
        this.hdd = hdd;
        this.os = os;
        this.color = color;
        this.sn = sn;
    }
// Геттер
    public String getModel(){
        return model;
    }
    public int getRam(){
        return ram;
    }
    public int getHdd(){
        return hdd;
    }
    public String getOs(){
        return os;
    }
    public String getColor(){
        return color;
    }
    public String getSn(){
        return sn;
    }

//Сеттер
    public void setModel(String model){
        this.model = model;
    }
    public void setRam(int ram){
        this.ram = ram;
    }
    public void setHdd(int hdd){
        this.hdd = hdd;
    }
    public void setOs(String os){
        this.os = os;
    }
    public void setColor(String color){
        this.color = color;
    }
    public void setSn(String sn){
        this.sn = sn;
    }

    
    @Override
    public String toString() {
        return "Модель: " + model + ", Объем ОЗУ: " + ram + "ГБ" + ", Объем жесткого диска: "
        + hdd + "ГБ" + ", Операционная система: " + os + ", Цвет: " + color;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Notebook notebook = (Notebook) obj;
        return(model.equals(notebook.model)) && (ram == notebook.ram) && (hdd == notebook.hdd) && (os.equals(notebook.os)) && 
        (color.equals(notebook.color)) && (sn.equals(notebook.sn));
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, ram, hdd, os, color, sn);
    }
}
