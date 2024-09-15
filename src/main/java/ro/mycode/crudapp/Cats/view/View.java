package ro.mycode.crudapp.Cats.view;


import org.springframework.stereotype.Service;
import ro.mycode.crudapp.Cats.exceptions.CatListEmpty;
import ro.mycode.crudapp.Cats.models.Cat;
import ro.mycode.crudapp.Cats.service.CatService;

import java.util.List;
import java.util.Scanner;

@Service
public class View {

    private Scanner scanner;
private CatService catService;
private Cat cat;

    public View(CatService catService){
        this.catService = catService;
        this.scanner= new Scanner(System.in);
    }

    public void meniu(){
        System.out.println("Apasa tasta 1 pen6tru a afisa toate produsele");
        System.out.println("Apasa tasta 2 pentru a adauga un produs");
        System.out.println("Apasa tasta 3 pentru a sterge un produs");
        System.out.println("Apasa tasta 4 pentru a actualiza marca  produsului ");
    }


    public void play(){
        int alegere=0;
        boolean running =true;


        while (running){
            meniu();
            alegere=Integer.parseInt(scanner.nextLine());
            switch (alegere){
                //afisare
                case 1:afisare();
                    break;
                    // adaugare
                case 2://adaugaremakeup();
                    break;
                    //stergere
                case 3:// stergeremakeup();
                    break;
                case 4: //updatemakeup();
                break;

                default:
                    System.out.println("Alegerea este gresita");
                    break;
            }

        }
    }
    private  void  afisare(){
        try {
            List<Cat> cat = catService.getAllCats();
            cat.forEach(masian -> {
                System.out.println(masian);
            });
        } catch (CatListEmpty catListEmpty) {
            System.out.println(catListEmpty.getMessage());
        }
    }




}
