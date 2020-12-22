package com.botscrew.university.view;

import com.botscrew.university.MyRunner;
import com.botscrew.university.service.DepartmentService;
import com.botscrew.university.service.LectorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

@Component
public class MyView {

    private DepartmentService departmentService;
    private LectorService lectorService;

    private Map<String, String> menu;
    private Map<String, String> nameOfDepartment;
    private Map<String, Printable> methodsMenu;

    private String title;

    private static Scanner input = new Scanner(System.in);
    private static final Logger logger = LoggerFactory.getLogger(MyRunner.class);

    public MyView(DepartmentService departmentService,LectorService lectorService) {
        this.departmentService =departmentService;
        this.lectorService=lectorService;
        listOfDepartment();
        setMenu();
        setMethodsMenu();
    }

    private void listOfDepartment(){
        nameOfDepartment = new LinkedHashMap<>();
        nameOfDepartment.put("1","Computer Science");
        nameOfDepartment.put("2","Psychology");
        nameOfDepartment.put("3","History");
        nameOfDepartment.put("4","Physics");
        nameOfDepartment.put("5","Economic");
    }

    private void setMenu(){
        menu = new LinkedHashMap<>();
        menu.put("1","1 - Show head of department");
        menu.put("2","2 - Show statistics");
        menu.put("3","3 - Show average salary");
        menu.put("4","4 - Show count of employee");
        menu.put("5","5 - Show global search by template");
        menu.put("Q","Q - Exit");

    }

    private void setMethodsMenu(){
        methodsMenu= new LinkedHashMap<>();
        methodsMenu.put("1", this::showHeadOfDepartment);
        methodsMenu.put("2", this::showStatistics);
        methodsMenu.put("3", this::showAverageSalary);
        methodsMenu.put("4", this::showCountOfEmployee);
        methodsMenu.put("5", this::showGlobalSearch);
    }

    private void showHeadOfDepartment(){
        System.out.println(title);
        System.out.println("Who is head of department " + title + "?");
        System.out.println(departmentService.getHeadByTitle(title));

        logger.info("Who is head of department "+title+"?");
        logger.info(departmentService.getHeadByTitle(title));
    }

    private void showStatistics() {
        System.out.println("Show " + title + " statistics.");
        System.out.println(departmentService.getStatistic(title));

        logger.info("Show "+title+ " statistics.");
        logger.info(departmentService.getStatistic(title));
    }
    private void showAverageSalary() {
        System.out.println("Show the average salary for the department " + title);
        System.out.println(departmentService.getAverageSalary(title));

        logger.info("Show the average salary for the department "+title);
        logger.info(departmentService.getAverageSalary(title));
    }
    private void showCountOfEmployee() {
        System.out.println("Show count of employee for " + title);
        System.out.println(departmentService.getCountOfEmployee(title));

        logger.info("Show count of employee for "+title);
        logger.info(String.valueOf(departmentService.getCountOfEmployee(title)));
    }

    private void showGlobalSearch(){
        System.out.print("Enter template: ");
        String template = input.nextLine();
        System.out.println("Global search by " + template);
        System.out.println(lectorService.globalSearchByTemplate(template));

        logger.info("Global search by " + template);
        logger.info(lectorService.globalSearchByTemplate(template));
    }

    private void outputMenu() {
        System.out.println("\nMENU:");
        for (String str : menu.values()) {
            System.out.println(str);
        }
    }

    private void outputListOfDepartments(){
        System.out.println("\nDepartments:");
        for(Map.Entry<String,String> item : nameOfDepartment.entrySet()){
            System.out.println(item.getKey()+" - "+item.getValue());
        }

    }

    private String getNameOfDepartment(){
        System.out.print("Please, select number of departments: ");
        String number = input.nextLine().toUpperCase();
        for(Map.Entry<String,String> item : nameOfDepartment.entrySet()){
            if(number.equals(item.getKey())){
            title = item.getValue();}
        }
        return title;
    }

    public void show() {
        outputListOfDepartments();
        getNameOfDepartment();
        String keyMenu;
        do {
            outputMenu();
            System.out.println("Please, select menu point.");
            keyMenu = input.nextLine().toUpperCase();
            try {
                methodsMenu.get(keyMenu).print();
            } catch (Exception e) {
            }
        } while (!keyMenu.equals("Q"));
    }
}