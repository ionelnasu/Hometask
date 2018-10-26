import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

        public static void main(String[] args) {
            try {
                readwrite ( );
            } catch (IOException e) {
                e.printStackTrace ( );
            }
        }
        public static void readwrite() throws IOException {
            String patchinput = "C:\\Users\\black82\\Documents\\GitHub\\Hometask\\Inputoutputhometask2\\Listname&price.txt";
            BufferedReader reader = new BufferedReader ( new FileReader ( patchinput ) );
            File file = new File ( "C:\\Users\\black82\\Documents\\GitHub\\Hometask\\Inputoutputhometask2\\Listname&price2.txt" );
            if (!file.exists ( )) file.createNewFile ( );
            BufferedWriter writer = new BufferedWriter ( new FileWriter ( file ) );
            List <PersonDevaice> personDevaiceList = refactoryfiletolist ( reader );
            Set <PersonDevaice> listtosumeprice = refactorylisttosumprice ( personDevaiceList );
            System.out.println ( listtosumeprice );
            sortlist ( listtosumeprice );
            writetofile ( writer , listtosumeprice );
        }
        public static List <PersonDevaice> refactoryfiletolist(BufferedReader reader) throws IOException {
            List <PersonDevaice> personDevaices = new LinkedList <> ( );
            String readline = reader.readLine ( );
            while (readline != null) {
                String line = reader.readLine ( );
                if (line == null) break;
                String[] split = line.split ( "," );
                String Name = split[0];
                String Family = split[1];
                String Devaic = split[2];
                int price = Integer.parseInt ( split[3] );
                personDevaices.add ( new PersonDevaice ( Name , Family , Devaic , price ) );
            }
            reader.close ( );
            return personDevaices;
        }
        public static List <PersonDevaice> sortlist(Set <PersonDevaice> list) {
            return list.stream ( ).sorted ( (a1 , a2) -> Integer.compare ( a1.getDevaicprice ( ) , a2.getDevaicprice ( ) ) ).collect ( Collectors.toList ( ) );
        }
        public static Set <PersonDevaice> refactorylisttosumprice(List <PersonDevaice> list) {
            Set <PersonDevaice> list1 = new HashSet <> ( );
            for (int i = 0; i < list.size ( ) - 1; i++) {
                for (int s = 1; s < list.size ( ); s++) {
                    if (list.get ( i ).getName ( ).equalsIgnoreCase ( list.get ( s ).getName ( ) ) && list.get ( i ).getFamily ( ).equalsIgnoreCase ( list.get ( s ).getFamily ( ) ) && !list.get ( i ).getDevaic ( ).equalsIgnoreCase ( list.get ( s ).getDevaic ( ) )) {
                        int newprice = list.get ( i ).getDevaicprice ( ) + list.get ( s ).getDevaicprice ( );
                        list1.add ( new PersonDevaice ( list.get ( i ).getName ( ) , list.get ( i ).getFamily ( ) , list.get ( i ).getDevaic ( ) , newprice ) );
                    }
                }
            }
            list1.addAll ( list );
            return list1;
        }
        public static void writetofile(BufferedWriter writer , Set <PersonDevaice> list) throws IOException {
            for (PersonDevaice s : list) {
                writer.write ( s.getName ( ) + "," + s.getFamily ( ) + "," + s.getDevaicprice ( ) + "\r\n" );
            }
            writer.flush ( );
            writer.close ( );
        }
    }
    class PersonDevaice {
        private String Name;
        private String Family;
        private String Devaic;
        private int Devaicprice;
        public String getName() {
            return Name;
        }
        public String getFamily() {
            return Family;
        }
        public String getDevaic() {
            return Devaic;
        }
        public int getDevaicprice() {
            return Devaicprice;
        }
        public PersonDevaice(String name , String family , String devaic , int devaicprice) {
            Name = name;
            Family = family;
            Devaic = devaic;
            Devaicprice = devaicprice;
        }
        @Override
        public String toString() {
            return "PersonDevaice{" + "Name='" + Name + '\'' + ", Family='" + Family + '\'' + ", Devaic='" + Devaic + '\'' + ", Devaicprice=" + Devaicprice + "\n" + '}';
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass ( ) != o.getClass ( )) return false;
            PersonDevaice that = (PersonDevaice) o;
            return Objects.equals ( Name , that.Name ) && Objects.equals ( Family , that.Family );
        }
        @Override
        public int hashCode() {
            return Objects.hash ( Name , Family );
        }

}
