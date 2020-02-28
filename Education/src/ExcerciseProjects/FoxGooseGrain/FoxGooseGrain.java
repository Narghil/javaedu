package ExcerciseProjects.FoxGooseGrain;

import java.util.Scanner;

public class FoxGooseGrain {

    public static void main(String[] args) {
        RiverSide thisSide  = new RiverSide(" Ezen a parton", true);
        RiverSide otherSide = new RiverSide("A túlsó parton", false);
        Scanner scanner = new Scanner(System.in);
        boolean inGame = true;
        String inputLine;
        int moveMember;

        while (inGame) {
            thisSide.printMembers();
            otherSide.printMembers();
            if (thisSide.ifAnyEat() || otherSide.ifAnyEat()) {
                System.out.println("Vesztettél.");
                inGame = false;
            } else {
                if (otherSide.ifAllIsHere()) {
                    System.out.println("Mindenkit sikerült átszállítanod! Nyertél!");
                    inGame = false;
                } else {
                    System.out.println();
                    System.out.print("Mit vigyen át a gazda? 0-Csak maga menjen, 1-Rókát, 2-Libát, 3-Búzát, 4-Kilépés: ");
                    inputLine = scanner.nextLine();
                    try {
                        moveMember = Integer.parseInt(inputLine);
                        if(moveMember >=0 && moveMember <=4) {
                            if (moveMember == 4) {
                                System.out.println("Kiléptél.");
                                inGame = false;
                            } else {
                                if (thisSide.ifHere(moveMember) || otherSide.ifHere(moveMember)) {
                                    thisSide.flipMember(moveMember);
                                    otherSide.flipMember(moveMember);
                                    if (thisSide.ifAllIsHere()) {
                                        System.out.println("...kezdheted előlről az égeszet...");
                                    }
                                } else {
                                    System.out.println("A másik parton van!");
                                }
                            }
                        }
                    } catch(Exception e){}
                }
            }
        }

    }
}
