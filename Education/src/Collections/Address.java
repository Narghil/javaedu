//Gyakorlás a setekkel
package Collections;

import java.util.*;


class SpecialSortKey implements Comparator<Address> {

    @Override
    public int compare(Address o1, Address o2){
        return 0;
    }
}


public class Address implements Comparable{
    private int num;
    private String street;
    private String city;
    private int zip;

    public Address( int num, String street, String city, int zip ){
        this.num = num;
        this.street = street;
        this.city = city;
        this.zip = zip;
    }

    @Override
    public int compareTo(Object o) {
        //String sMe = this.toString();
        //String sO = o.toString();
        int result;

        if (this == o) return 0;
        if (o == null || this.getClass() != o.getClass()) return 0;
        Address myO = (Address)o;
        return this.zip == myO.zip ? 0 : (this.zip > myO.zip ? 1 : -1) ;
        //return (this.toString().compareTo( o.toString()));

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return num == address.num &&
                zip == address.zip &&
                Objects.equals(street, address.street) &&
                Objects.equals(city, address.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(num, street, city, zip);
    }

    @Override
    public String toString() {
        return num+" "+street+", "+city+", "+zip+"|";
    }

    public static void main(String[] args) {
        //Address A1 = new Address(6454, "Cascade Street", "San Diego",92122 );
//        System.out.println(A1);
        //Set s = new HashSet();
        Set s = new TreeSet();

        s.add(new Address(6455, "Cascade one Street", "San Diego",92123 ));
        s.add(new Address(6454, "Cascade Street", "San Diego",92122 ));
        s.add(new Address(6456, "Cascade two Street", "San Diego",92124 ));
        s.add(new Address(6454, "Cascade Street", "San Diego",92122 ));


        System.out.println(s);
    }
}
